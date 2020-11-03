<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write</title>
<c:import url="../template/bootStrap.jsp"></c:import>
<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<style type="text/css">
	#add {
		display: none;
	}
	.del {
		color: red;
		font-weight: bold;
		cursor: pointer;
	}
</style>
<!-- HTMl 코드가 뿌려지기 전에 Script를 적용하려면 $(document).ready(function() { 사용해야 함
<script type="text/javascript">
	$(document).ready(function() {
		$('#summernote').summernote();
	});
</script>
 -->
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container">
	<h2>${board} Write Form</h2>
	<form id="frm" action="./${board}Write" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<label for="title">Title:</label>
			<input type="text" class="form-control" id="title" placeholder="Enter Title" name="title">
		</div>
	    
		<div class="form-group">
			<label for="writer">Writer:</label>
			<input type="text" class="form-control" value="${member.id}" id="writer" placeholder="Enter Writer" name="writer">
		</div> 
	    
		<div class="form-group">
			<label for="contents">Contents:</label>
			<textarea class="form-control" rows="10" id="contents" name="contents"></textarea>
		</div>	
	 
	 	<input type="button" value="FileAdd" class="btn btn-info" id="fileAdd">
	 	
	 	<div id="files"> 
		 	
	 	</div>
	 	
	 	
		<input type="button" class="btn btn-primary" value="Write" id="btn">
		<button type="submit" class="btn btn-default">Write</button>
	</form>
	
	<div id="add">
		<div class="input-group">
			<input id="files" type="file" class="form-control" name="files">
			<span class="input-group-addon del">DEL</span>
		</div>
	</div>
	 
</div>

<script type="text/javascript">
	var count = 0;
	
	$('#contents').summernote({
		height: 300,
		callbacks: {
			onImageUpload: function(files, editor, welEditable) {	//files 는 배열
				var formData = new FormData();			//가상의 form 태그 작성 - 안에 있는 것을 데이터로 만듦
				formData.append('file', files[0]);		//파라미터 이름 file
				
				$.ajax({
					data: formData,
					type: "POST",
					url: 'summernote',
					cache: false,
					contentType: false,
					enctype: 'multipart/form-data',
					processData: false,
					success:function(data){
						data = data.trim();
						$("#contents").summernote('editor.insertImage', data);
					}
				})
			}, //upload End
			
			onMediaDelete: function(files) {
				var fileName = $(files[0]).attr("src");
				console.log("before : " + fileName);
				//fileName에서 파일명만 구해오기
				//s4/resources/upload/qna-sdfa-sdfsdf_iu1.jpg
				fileName = fileName.substring( fileName.lastIndexOf("\\") +1 );
				console.log("after : " + fileName);
				
				$.ajax({
					type: "POST",
					url: "./summernoteDelete",
					data: {
						file: fileName
					},
					success: function(data) {
						alert(data);
					}
				});
			} //delete End
			
		} //callbacks End
	});
	
	$('#btn').click(function() {
		var contents = $('#contents').summernote('code');
		alert(contents);
	});
	
	$("#fileAdd").click(function() {
		if(count < 5) {
			var add = $("#add").html().trim();
			$("#files").append(add);
			count++;
		} else {
			alert("첨부파일은 최대 5개까지 가능");
		}		
	});

	$("#files").on("click", ".del", function() {
		var add = $(this).parent();
		console.log(add);
		add.remove();
		count--;
	});
</script>

</body>
</html>