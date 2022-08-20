<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> 선호도 조사 결과</h2>
<% 
// post 방식 디코딩(코드 -> 문자)
request.setCharacterEncoding("UTF-8");

// 데이터 받아오기
String name = request.getParameter("name"); 
String[] str = request.getParameterValues("fruit"); 
%>

<table border=1>
	<tr>
		<td>이름</td>
		<td><%= name %></td>
	</tr>
	<tr>
		<td>좋아하는 과일</td>
		<td>
			<% for(int i = 0; i < str.length; i++){ %>
					<%=str[i] %>
			<%} %>
		
		</td>
	</tr>

</table>


</body>
</html>