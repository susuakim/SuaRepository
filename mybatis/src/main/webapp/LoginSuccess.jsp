<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% // 쿼리스트링 방식으로 보낸 데이터 받아오기
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");

	// session에 저장한 데이터 받아오기
	String session_name = (String)session.getAttribute("name");
%>

<h1> 로그인 성공 </h1>
<h1> 쿼리스트링 방식: <%= name %>님 환영합니다. </h1>
<h1> session 방식: <%= session_name %>님 환영합니다. </h1>

<a href="Update.jsp"> 회원정보 수정 </a>

id : <%= id %>
pw : <%= pw %>

</body>
</html>