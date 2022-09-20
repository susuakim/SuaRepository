<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원목록</h1>
	<table border="1">
		<tr>
			<td>ID</td>
			<td>NICKNAME</td>
			<td>ADDRESS</td>
		</tr>
		<c:forEach var="list" items="${list}">
			<tr>
				<td>${list.id}</td>
				<td>${list.nick}</td>
				<td>${list.address}</td>

			</tr>
		</c:forEach>
	</table>

</body>
</html>