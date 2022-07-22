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
<h1> 마우스 상세 페이지 </h1>
<h3> 모델명 : 로지텍 마우스<br>
	가격 : 100,000원
</h3>

<a href="List.jsp"> 제품 목록 페이지로 돌아가기</a>

<%
	// 쿠키 생성
	// 상품정보가 담긴 쿠키 만들기
	Cookie cookie = new Cookie("item1", URLEncoder.encode("마우스", "UTF-8"));

	//쿠키 보내기
	response.addCookie(cookie);
%>

</body>
</html>