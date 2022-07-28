<%@page import="java.net.URLDecoder"%>
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

<h1> 수정된 이름은 </h1>

<%

Cookie[] cookies = request.getCookies();

String name = " ";
for(int i = 0; i < cookies.length; i++) {
	if(cookies[i].getName().equals("name")) {
		name = URLDecoder.decode(cookies[i].getValue(),"UTF-8");
	}
}

%>

<%= name %>

</body>
</html>