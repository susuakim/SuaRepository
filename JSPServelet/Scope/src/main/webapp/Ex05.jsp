<%@page import="org.eclipse.jdt.internal.compiler.ast.ParameterizedSingleTypeReference"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 입력받은 숫자 2개 받아와서 합을 구하고, 그 결과값(합)을 Ex06.jsp로 전송
	조건: forward 방식 사용, request 객체에 합 정보 담기 -->
<%
	System.out.println("Ex05 입니다!!");

	int num1 = Integer.parseInt(request.getParameter("num1"));
	int num2 = Integer.parseInt(request.getParameter("num2"));
	
	// 합 구하기
	int result = num1 + num2;
	
	// 결과값 request 객체에 담기
	request.setAttribute("result", result);
	
	// request 객체 Ex06.jsp로 전송
	RequestDispatcher rd = request.getRequestDispatcher("Ex06.jsp");
	rd.forward(request, response);
%>
</body>
</html>