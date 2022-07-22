<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 컴퓨터 상세 페이지 </h1>
<h3> 모델명 : 컴퓨터<br>
	가격 : 2,000,000원
</h3>

<a href="List.jsp"> 제품 목록 페이지로 돌아가기 </a>

<%

	Cookie cookie = new Cookie("item2", URLEncoder.encode("컴퓨터", "UTF-8"));
	
	response.addCookie(cookie);

%>

</body>
</html>