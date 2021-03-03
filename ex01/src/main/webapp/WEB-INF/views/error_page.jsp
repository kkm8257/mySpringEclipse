<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <!-- uri 를 치고 컨트롤 스페이스바 누르면 3번째꺼  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" import="java.util.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>예외 처리 페이지</h1>
<h4><c:out value="${exception.message }"></c:out></h4> <!--여기서알아둘것은 jstl에서는 저런식으로 property를 호출하는것처럼 보여도,
실제로는 getter를 통해 가져온 것이다.  -->

<!-- 단독 태그로 써도된다 -->
<h4>${exception.message }</h4>

<!--jstl을 사용하지않으면 아래처럼 getter로 가져와야한다.  -->
<h4>${exception.getMessage() }</h4>


</body>
</html>