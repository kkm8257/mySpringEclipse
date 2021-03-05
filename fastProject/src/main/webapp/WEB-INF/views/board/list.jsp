<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="pageObject" tagdir="/WEB-INF/tags"%>
<!-- ctrl + space 세번쨰에 http 링크 나옴  나머지도 자동완성가능  

 prefix는 임의로 작성할 수 있으나 태그와 맞춰줘야 합니다.
-->
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
	
	<style type="text/css">
	
		.dataRow:hover{
		background:#ddd;
		cursor:pointer;
		}
	
	</style>
	
	<script>
	
	$(function(){
		$('.dataRow').click(function(){
			var no = $(this).find(".no").text();  //클릭한것에 위치한것(this) 중에 find(클래스를찾는다) 한다음에 내용을 가져오라 
			location="view.do?no="+no+"&inc=1"
			
		
		});
		
	
	});
	
	</script>
	
</head>
<body>

	<h2>게시판 리스트</h2>
	<table class="table">

		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>

		<c:if test="${empty list }">
			<tr>
				<td colspan="5">데이터가 존재하지 않습니다.</td>
			</tr>
		</c:if>
		<c:if test="${!empty list }">


			<c:forEach items="${list }" var="vo">
				<tr class="dataRow">
					<td class="no">${vo.no }</td>
					<td >${vo.title }</td>
					<td >${vo.writer }</td>
					<td ><fmt:formatDate value="${vo.writeDate }"
							pattern="yyyy.MM.dd" /></td>
					<td >${vo.hit }</td>


				</tr>
			</c:forEach>

		</c:if>
		
		<td colspan="5">
				 <pageObject:pageNav pageObject="${pageObject }" listURI="list.do" />
		</td>

		<tr>
			<td colspan="5"><a href="write.do" class="btn btn-default">글쓰기</a>
			</td>
		</tr>


	</table>


</body>
</html>