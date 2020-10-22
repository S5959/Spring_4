<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select</title>
<c:import url="../template/bootStrap.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container">
	<h3>${board} Select Page</h3>
	
	<h3 id="num">${dto.num}</h3>
	<h3>Title : ${dto.title}</h3>
	<h3>Writer : ${dto.writer}</h3>
	<h3>Contents : ${dto.contents}</h3>
	
	<input type="button" title="${dto.num}" value="Delete" class="btn btn-warning" id="del">
	<input type="button" class="btn btn-primary" value="Update" id="update">
</div>

<script type="text/javascript">
	//$("css선택자").action();
	$("#update").click(function() {
		location.href="./${board}Update?num=${dto.num}";
	});
	
	$("#del").click(function() {
		//var num = $("#num").html();
		var num = $(this).attr("title");
		alert(num);
		location.href="./${board}Delete?num="+num;
	});

</script>


</body>
</html>