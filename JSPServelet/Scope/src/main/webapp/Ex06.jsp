<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 입력받은 숫자 2개와 그 합을 출력 -->
<%
	System.out.print("Ex06 입니다!!");

	// 입력받은 숫자 2개
	String num1 = request.getParameter("num1");
	String num2 = request.getParameter("num2");
	
	// 합
	int result = (Integer)request.getAttribute("result");
%>

num1 : <%= num1 %><br>
num2 : <%= num2 %><br>
합 : <%= result %>

</body>
</html>