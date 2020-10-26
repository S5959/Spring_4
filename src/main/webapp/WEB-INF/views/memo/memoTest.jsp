<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-hober">
	<tr>
		<th>Num</th>
		<th>Writer</th>
		<th>Contents</th>
		<th>RegDate</th>
		<th>Button</th>
	</tr>
	
	<c:forEach items="${list}" var="dto" varStatus="i">
		<tr>
			<td id="num${i.index}">${dto.num}</td>
			<td>${dto.writer}</td>
			<td>${dto.contents}</td>
			<td>${dto.regDate}</td>
			<td><button class="btn btn-danger del" title="${dto.num}">DEL</button></td>
		</tr>
	</c:forEach>
</table>
