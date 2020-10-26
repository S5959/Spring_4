<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
<c:import url="../template/bootStrap.jsp"></c:import>
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
	$("#id").change(function() {
		console.log($(this).val());
		
		
	});
</script>

</body>
</html>