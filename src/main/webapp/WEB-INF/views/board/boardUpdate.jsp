<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
<c:import url="../template/bootStrap.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container">
  <h2>${board} Update Form</h2>
  <form action="./${board}Update" method="post">
  	<input type="hidden" name="num" value="${dto.num}">
  	
    <div class="form-group">
      <label for="title">Title:</label>
      <input type="text" class="form-control" id="title" placeholder="Enter Title" name="title" value="${dto.title}">
    </div>
    
    <div class="form-group">
      <label for="writer">Writer:</label>
      <input type="text" class="form-control" readonly="readonly" id="writer" placeholder="Enter Writer" name="writer" value="${dto.writer}">
    </div> 
    
     <div class="form-group">
      <label for="contents">Contents:</label>
      <textarea class="form-control" rows="10" id="contents" name="contents">${dto.contents}</textarea>
    </div>	
    
    <button type="submit" class="btn btn-default">Update</button>
  </form>
</div>

</body>
</html>