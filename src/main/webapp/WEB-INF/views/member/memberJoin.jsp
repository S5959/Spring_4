<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
<c:import url="../template/bootStrap.jsp"></c:import>
<style type="text/css">
	.idCheck0 {
		color: blue;
	}
	.idCheck1 {
		color: red;
	}
</style>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container">
	<h3>Member Join Form</h3>
	<form action="./memberJoin" method="post" id="frm">
		<div class="form-group">
			<label for="id">Id:</label>
			<input type="id" class="form-control" id="id" placeholder="Enter id" name="id">
			<div id="idResult"></div>
		</div>
		<div class="form-group">
			<label for="pw">Password:</label>
			<input type="password" class="form-control" id="pw" placeholder="Enter password" name="pw">
		</div>
		<div class="form-group">
			<label for="pw">Password:</label>
			<input type="password" class="form-control" id="pw2" placeholder="Enter password" name="pw2">
			<div id="pwResult"></div>
		</div>
		<div class="form-group">
			<label for="name">Name:</label>
			<input type="name" class="form-control empty" id="name" placeholder="Enter name" name="name">
			<div class="emptyResult"></div>
		</div>
		<div class="form-group">
			<label for="email">Email:</label>
			<input type="email" class="form-control empty" id="email" placeholder="Enter email" name="email">
			<div class="emptyResult"></div>
		</div>
		
		<input type="button" value="Join" class="btn btn-default" id="join">
	</form>
</div>

<script type="text/javascript">
	//********  Join Button Check  *********
	var idCheck = false;
	var pwCheck = false;
	var emptyCheckResult = true;
	
	$("#join").click(function() {
		emptyCheck();
		
		var name = $("#name").val();
		var email = $("#email").val();
		
		if(idCheck && pwCheck && emptyCheckResult) {
			$("#frm").submit();
		}
		
	});
	//*************************************
	
	//************  Id Check  *************
	$("#id").blur(function() {
		idCheck = false;
		var id = $(this).val();
		
		if(id != '') {
			
			$.ajax({
				url : "./memeberIdCheck",
				type : "POST",
				data : {id:id},
				success : function(data) {
					data = data.trim();
					
					var str = "중복된 ID 입니다.";
					$("#idResult").remove("idCheck0").addClass("idCheck1");
					if(data==0) {
						str = "사용 가능한 ID 입니다.";
						$("#idResult").removeClass("idCheck1").addClass("idCheck0");
						idCheck = true;
					}				
					$("#idResult").html(str);
				}
			});
			
			
			/*
			$.post("./memberIdCheck", {id:id}, function(data) {
				//a 	사용가능, 		b 		사용불가
				//true 	사용가능,		false 	사용불가
				//0 	사용가능, 		1 		사용불가
				data = data.trim();
				
				var str = "중복된 ID 입니다.";
				$("#idResult").remove("idCheck0").addClass("idCheck1");
				if(data==0) {
					str = "사용 가능한 ID 입니다.";
					$("#idResult").removeClass("idCheck1").addClass("idCheck0");
					idCheck = true;
				}				
				$("#idResult").html(str);
			});
			*/
		} else {
			$("#idResult").html("ID는 필수 입력 항목 입니다.");
			$("#idResult").remove("idCheck0").addClass("idCheck1");
		}
		
	});
	//*************************************
	
	//************  PW Check  *************
	$("#pw2").blur(function() {
		pwCheck = false;
		
		var pw = $("#pw").val();
		var pw2 = $(this).val();
		
		if(pw=='' || pw2=='') {
			$("#pwResult").html("Password 를 입력하세요.");
			$("#pwResult").removeClass("idCheck0").addClass("idCheck1");
		} else if(pw==pw2) {
			$("#pwResult").html("입력한 Password 가 일치합니다.");
			$("#pwResult").removeClass("idCheck1").addClass("idCheck0");
			pwCheck = true;
		} else {
			$("#pwResult").html("입력한 Password 가 다릅니다.");
			$("#pwResult").removeClass("idCheck0").addClass("idCheck1");
		}
	});
	//*************************************
	
	//***********  Empty Check  ***********
	function emptyCheck() {
		emptyCheckResult=true;
		$(".emptyResult").removeClass("idCheck1");
		$(".emptyResult").html('');
		$(".empty").each(function() {
			var data = $(this).val();
			console.log(data);
			if(data=='') {
				emptyCheckResult = false;
				$(this).next().html("필수 입력항목입니다.");
				$(".emptyResult").addClass("idCheck1");
			}
		});
	}
	//*************************************
</script>

</body>
</html>