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
	// 조회 : 객체.getAttribute("이름")
	String getPage = (String)pageContext.getAttribute("page");
	String getRequest = (String)request.getAttribute("request");
	String getSession = (String)session.getAttribute("session");
	String getApplication = (String)application.getAttribute("application");
%>

<h1> Ex02_scope.jsp </h1>
page : <%= getPage %> <br>
request : <%= getRequest %> <br>
session : <%= getSession %> <br>
application : <%= getApplication %> <br>

</body>
</html>