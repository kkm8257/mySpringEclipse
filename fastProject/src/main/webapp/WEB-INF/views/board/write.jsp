<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- ctrl + space 세번쨰에 http 링크 나옴  나머지도 자동완성가능  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
	
	<script>
		$(function(){
		
		$(".cancelBtn").click(function() {
		history.back();
		
		});
		
		});
		
	</script>
	
</head>
<body>

	<h2>게시판 글쓰기</h2>

	<form method="post" action="" class="form-group">
		<table class="table">
			<tr>
				<th>제목</th>
				<td><input class="form-control" name="title"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><input class="form-control" name="content"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input class="form-control" name="writer"></td>
			</tr>
			<tr>
				<td colspan="2">
					<button>등록</button>
					<button type="reset">새로입력</button>
					<button type="button" class="cancelBtn">취소</button>
			</tr>


		</table>
	</form>

</body>
</html>