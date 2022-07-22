<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> 판매 목록 </h1>
<ul>
	<li><a href="Mouse.jsp">마우스</a> </li>
	<li><a href="Computer.jsp">컴퓨터</a> </li>
	<li><a href="Phone.jsp">핸드폰</a> </li>
</ul>

<hr>

<h1> 최근 본 상품 </h1>
<% 
	//쿠키 조회
	Cookie[] cookies = request.getCookies();
	
	for(Cookie c : cookies){
		String name = c.getName();
		
		// 만약에 쿠키의 이름에 item을 포함하고 있다면 그때만 출력하기
		// 문자열.contains('문자') : 문자열 내에 검색하고자 하는 문자가 있는지 확인
		if(name.contains("item")){
		String value = URLDecoder.decode(c.getValue(), "UTF-8");
		out.print(value + "<br>");

		}
	}
%>

<a href="Delete.jsp"> 최근 본 상품 삭제 </a>

</body>
</html>