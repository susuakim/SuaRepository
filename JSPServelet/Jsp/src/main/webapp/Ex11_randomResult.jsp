<%@page import="java.util.Random"%>
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
String main = request.getParameter("main");
String[] item = request.getParameterValues("item");

Random ran = new Random();
int rannum = ran.nextInt(item.length);

%>


<fieldset>
<legend> 랜덤 당첨 결과</legend>

주제: <%= main %> <br>
결과: <%= item[rannum]  %>

</fieldset>

</body>
</html>