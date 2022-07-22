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
<h1> 핸드폰 상세 페이지 </h1>
<h3> 모델명 : 갤럭시 S21 울트라<br>
	가격 : 1,500,000원 
</h3>

<a href="List.jsp"> 제품 목록 페이지로 돌아가기 </a>

<%
	Cookie cookie = new Cookie("item3", URLEncoder.encode("핸드폰", "UTF-8"));
	response.addCookie(cookie);
%>


</body>
</html>