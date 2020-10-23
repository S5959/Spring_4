<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>
<c:import url="../template/bootStrap.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container">
	<table class="table table-condensed" >
		<tr>
			<th>Num</th>	<td></td>
			<th>ID</th>		<td></td>
			<th>Name</th>	<td></td>
			<th>Email</th>	<td></td>
		</tr>
	</table>
</div>
</body>
</html>