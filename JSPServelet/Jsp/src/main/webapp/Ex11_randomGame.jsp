<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
fieldset{
	display : inline;
}
</style>
</head>
<body>

<% 
int number = Integer.parseInt(request.getParameter("number")); 
%>

<fieldset>
<legend> 랜덤 당첨 작성</legend>
<form action = "Ex11_randomResult.jsp">

	주제: <input type="text" name="main"><br>

	<%for(int i = 1; i <= number; i++){%>
		아이템<%= i %>: <input type="text" name="item"><br>
	<% }%>

	<input type="submit" value="생성하기">

</form>



</fieldset>

</body>
</html>