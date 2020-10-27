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
	<div id="result">
		
	</div>
	<button id="more" class="btn btn-danger del">더보기</button>
</div>

<script type="text/javascript">
	var curPage=1;
	getList();
	
	
	//************  More  *************
	$("#more").click(function() {
		curPage++;
		console.log(curPage);
		getList();
	});	
	//*********************************	
	
	
	//*************  DEL  **************
	/* 더보기의 del 만 걸어지고 table의 del 버튼은 적용안됨
	 *
	$(".del").click(function() {
		alert("del");
	});
	*/
	
	$("#result").on("click", ".del", function() {
		var num = $(this).attr("title");
		//var num2 = $("#num"+num).html();	//사용비추, 결과 fail...
		
		$.ajax({
			url : "./memoDelete",
			type : "POST",
			data : {num:num},
			success : function(data) {
				data=data.trim();	//공백때문에 true 인데 false로 결과 출력될 수 있기때문에 사전방지
				if(data>0) {
					$("#result").html('');
					curPage=1;
					getList();
				} else {
					alert("Delete Fail");
				}
			}
		});
		
		/*
		$.post("./memoDelete", {num:num}, function(data) {
			data=data.trim();	//공백때문에 true 인데 false로 결과 출력될 수 있기때문에 사전방지
			if(data>0) {
				getList();
			} else {
				alert("Delete Fail");
			}
		});
		*/
	});
	//**********************************

	
	//************  Write  *************
	$("#write").click(function() {
		var writer = $("#writer").val();
		var contents = $("#contents").val();
		
		$.ajax({
			url : "./memoWrite",
			type : "POST",
			data : {
				writer:writer, 
				contents:contents
			},
			success : function(result) {
				result = result.trim();
				if(result>0) {
					console.log(result);
					$("#writer").val('');
					$("#contents").val('');
					$("#result").html('');
					curPage=1;
					getList();
				} else {
					alert("Write Fail");
				}				
			}
		});
		
		/*
		$.post("./memoWrite", {writer:writer, contents:contents}, function(result) {
			console.log(result);
			$("#writer").val('');
			$("#contents").val('');
			getList();
		});
		*/
	});
	
	//*********************************	
	
	
	//************  List  *************
	function getList() {
		$.ajax({
			url : "./memoList",
			type : "GET",
			data : {curPage:curPage},
			success : function(data) {
				//$("#result").html(data);
				$("#result").append(data);
			}
		});
		
		/*
		$.get("./memoList", function(data) {
			$("#result").html(data);
		});
		*/
	}
	//*********************************	
</script>

</body>
</html>