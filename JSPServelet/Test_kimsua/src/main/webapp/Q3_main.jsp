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
String id = (String)session.getAttribute("id");
%>

<table border=1>
	<tr>
		<td><%= id%>님 환영합니다!</td>
	</tr>
	<tr>
		<td>
			<form action="Q3_Logout">
				<% session.setAttribute("id", id); %>
				<input type="submit" value="로그아웃">
			</form>
		</td>
	</tr>

</table>

</body>
</html>