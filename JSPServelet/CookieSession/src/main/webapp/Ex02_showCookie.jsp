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
	// 4. 쿠키 조회
	// 서버가 따로 요청하지 않아도 Cookie는 request 객체에 담겨서 온다
	Cookie[] cookies = request.getCookies();
	
	for(int i = 0; i < cookies.length; i++){
		out.print("쿠기이름:  " + cookies[i].getName()+"<br>");
		out.print("쿠키값:  "+ cookies[i].getValue()+"<br>");
	}
%>
<hr>
	<!-- 표현식을 사용해서 Cookie출력 > 디코딩 -->
	<!-- 1. for-each문 
	for(데이터타입 변수명 : 반복 가능한 변수){실행문장} -->
	<!--  -->

<% for(Cookie c : cookies) {%>
	쿠키이름 == URLDecoder.decode(c.getNmae), "UTF=8" )%> <br>
	쿠키값 == URLDecoder.decode(c.getValue "UTF=8" )%> <br>
<% } %>	

</body>
</html>