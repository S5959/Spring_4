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
	<form action="./memberJoin" method="post">
		<div class="form-group">
			<label for="id">Id:</label>
			<input type="id" class="form-control" id="id" placeholder="Enter id" name="id">
			<div id="idResult"></div>
		</div>
		<div class="form-group">
			<label for="pw">Password:</label>
			<input type="password" class="form-control" id="pw" placeholder="Enter password" name="pw">
			<div id="pwResult"></div>
		</div>
		<div class="form-group">
			<label for="pw">Password:</label>
			<input type="password" class="form-control" id="pw2" placeholder="Enter password" name="pw2">
			<div id="pw2Result"></div>
		</div>
		<div class="form-group">
			<label for="name">Name:</label>
			<input type="name" class="form-control" id="name" placeholder="Enter name" name="name">
			<div id="nameResult"></div>
		</div>
		<div class="form-group">
			<label for="email">Email:</label>
			<input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
			<div id="emailResult"></div>
		</div>
		
		<button type="submit" class="btn btn-default">Submit</button>
	</form>
</div>

<script type="text/javascript">
	$("#id").blur(function() {
		var id = $(this).val();
		console.log(id);

		$.post("./memberIdCheck", {id:id}, function(data) {
			//a 	사용가능, 		b 		사용불가
			//true 	사용가능,		false 	사용불가
			//0 	사용가능, 		1 		사용불가
			data = data.trim();
			console.log(data);
			
			var str = "중복된 ID 입니다.";
			$("#idResult").addClass("idCheck1");
			if(data==0) {
				str = "사용 가능한 아이디 입니다.";
				$("#idResult").removeClass("idCheck1").addClass("idCheck0");
			} 
			
			$("#idResult").html(str);
			
		});
		
	});
</script>

</body>
</html>