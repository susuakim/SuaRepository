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
	// 쿠키삭제 : setMaxAge(0);
	Cookie[] cookies = request.getCookies();
	
	for(Cookie c : cookies){
		c.setMaxAge(0);
		// 쿠키 업데이트 될 시에는 다시 전달
		response.addCookie(c);
	}
	
	response.sendRedirect("List.jsp");
%>

</body>
</html>