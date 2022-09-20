<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>[1~100까지의 합 구하기]</h1>
<% 
	int sum = 0;
	for(int i = 1; i<=100; i++){
		sum += i;
	}
%>

<h3>1~100 합: <%= sum %></h3>

</body>
</html>