<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page</title>
<c:import url="../template/bootStrap.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container">
	<h1>Memo Page</h1>
	
	<form id="frm" action="./memoWrite" method="post">
		<div class="form-group">
			<label for="writer">Writer:</label>
			<input type="text" class="form-control" value="${member.id}" id="writer" placeholder="Enter Writer" name="writer">
		</div> 
	    
		<div class="form-group">
			<label for="contents">Contents:</label>
			<textarea class="form-control" rows="10" id="contents" name="contents"></textarea>
		</div>	
	 
		<div class="form-group">
			<button type="submit" class="btn btn-default" id="write">Write</button>
		</div>
	</form>
	
	<button id="btn" class="btn btn-primary">List</button>
	<div id="result"></div>
	<button class="btn btn-danger del">더보기</button>
</div>

<script type="text/javascript">
	getList();
	
	
	//************* DEL **************
	/* 더보기의 del 만 걸어지고 table의 del 버튼은 적용안됨
	 *
	$(".del").click(function() {
		alert("del");
	});
	*/
	
	$("#result").on("click", ".del", function() {
		console.log("Delete");
		var num = $(this).attr("title");
		//var num2 = $("#num"+num).html();	//사용비추, 결과 fail...
		console.log(num);
		$.post("./memoDelete", {num:num}, function(data) {
			data=data.trim();	//공백때문에 true 인데 false로 결과 출력될 수 있기때문에 사전방지
			console.log(data);
			console.log(data==1);
			getList();
		});
	});
	//********************************

	
	//************ WRITE *************
	$("#write").click(function() {
		var writer = $("#writer").val();
		var contents = $("#contents").val();
		
		$.post("./memoWrite", {writer:writer, contents:contents}, function(result) {
			console.log(result);
			$("#writer").val('');
			$("#contents").val('');
			getList();
		});
	});
	
	//*******************************	
	
	
	function getList() {
		$.get("./memoList", function(data) {
			$("#result").html(data);
		});
	}
</script>

</body>
</html>