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
		</div>
		<div class="form-group">
			<label for="pw">Password:</label>
			<input type="password" class="form-control" id="pw" placeholder="Enter password" name="pw">
		</div>
		<div class="form-group">
			<label for="pw">Password:</label>
			<input type="password" class="form-control" id="pw2" placeholder="Enter password" name="pw2">
		</div>
		<div class="form-group">
			<label for="name">Name:</label>
			<input type="name" class="form-control" id="name" placeholder="Enter name" name="name">
		</div>
		<div class="form-group">
			<label for="email">Email:</label>
			<input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
		</div>
		
		<button type="submit" class="btn btn-default">Submit</button>
	</form>
</div>

</body>
</html>