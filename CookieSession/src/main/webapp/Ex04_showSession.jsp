<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	
	// 4. Session 조회
	// session은 내장객체라서 jsp에서 따로 객체 생성X
	// session의 값은 Object타입, 원하는 데이터 타입으로 강제 형변환
	String name = (String)session.getAttribute("이름");
	String age = (String)session.getAttribute("나이");
	

%>
<h1> 이름 : <%= name %></h1>
<h1> 나이 : <%= age %></h1>

<a href="./Ex05_delecteSession.jsp"> session 삭제 </a>


</body>
</html>