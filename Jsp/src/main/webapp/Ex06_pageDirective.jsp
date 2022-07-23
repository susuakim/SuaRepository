<!-- 지시자 : jsp가 servlet으로 변환될 때 필요한 정보들을 기술 -->

<!-- 1. page 지시자 : jsp 페이지에 대한 환경설정
				- language : 사용하는 언어를 명시
				- contentType : 문서의 종류, 인코딩 방식등을 지정
					=> servlet으로 변환이 되면 
					=> response.setContentType(매개변수)
					=> response.setContentType("text/html; charset=UTF-8")
					=> 매개변수로 호출이 된다.
				- import : 다른 클래스나 객체를 import할 때 사용 == Java와 동일
				- eooroPage : 에러가 났을 때 대신 보여줄 페이지 지정
				-->

<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage = "./Ex06_errorPage.html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=
	2%0
%>

</body>
</html>