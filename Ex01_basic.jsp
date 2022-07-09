<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> Jsp 기본 문법</h1>
<!-- 1. 스크립트릿 : Jsp문서 내에 Java코드를 작성하기 위한 문법 -->
<% 
	//Java 언어
	int a = 10;
	int b = 20;
	int result = a+b;
	System.out.println("a+b의 결과: " + result);

%>

<!-- 2. 표현식 : Web에 결과값을 출력하기 위해 사용하는 문법 -->
<h1> a+b의 결과 : result </h1>
<h1> a+b의 결과 : <%= result %> </h1>




</body>
</html>