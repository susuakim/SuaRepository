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
	// 생성 : 객체.setAttribute("이름", "값")
	pageContext.setAttribute("page", "현재 jsp 페이지 내에서 정보 유지");
	request.setAttribute("request", "하나의 요청에 대해서 정보 유지");
	session.setAttribute("session", "하나의 브라우저에 대해서 정보 유지");
	application.setAttribute("application", "하나의 브라우저에 대해서 정보 유지");
	
	// 조회 : 객체.getAttribute("이름")
	String getPage = (String)pageContext.getAttribute("page");
	String getRequest = (String)request.getAttribute("request");
	String getSession = (String)session.getAttribute("session");
	String getApplication = (String)application.getAttribute("application");

	// request 객체 넘기기
	// RequestDispatcher : request 객체를 이동할 페이지로 넘겨주는 역핳을 하는 객체
	RequestDispatcher rd = request.getRequestDispatcher("./Ex02_scope.jsp");
	rd.forward(request, response);
%>

<h1> Ex01_scope.jsp </h1>
page : <%= getPage %> <br>
request : <%= getRequest %> <br>
session : <%= getSession %> <br>
application : <%= getApplication %> <br>

</body>
</html>