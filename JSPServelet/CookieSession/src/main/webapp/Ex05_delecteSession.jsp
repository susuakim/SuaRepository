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
	// 5. session 삭제
	// 5-1) 특정 session 삭제
	session.removeAttribute("이름");
	response.sendRedirect("./Ex04_showSession.jsp");
	
	// 5-2) 전체 session 종료
	session.invalidate();
%>

</body>
</html>