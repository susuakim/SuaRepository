<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- Cookie : Client의 정보를 유지하기 위해서 사용하는 방법
			1. 저장위치 : Client PC
			2. 보안 취약
			3. 자원 : Client의 자원을 사용해서 서버에 무리X
			4. 용량 : 쿠키 하나 당 4KB x 300개 => 1.2MB
			5. 저장형식 : text로만 저장가능(String)
				-->
		
<%
	// 1. 쿠키 객체 생성
	// new Cookie("쿠키이름", "쿠키값");
	// 한글은 인코딩
	//  URLEncoder.encode("인코딩할 값", "인코딩방식"));
	Cookie cookie = new Cookie("name",
			 URLEncoder.encode("김수아", "UTF-8"));
	
	Cookie cookie2 = new Cookie("age", "20");
	
	// 2. 쿠키의 기한 설정
	// 음수 : 브라우저 종료 시 쿠키가 자동 삭제
	// 양수 : 초 단위로 해당 시간만큼 쿠키 유지
	// 0 : 제거
	cookie.setMaxAge(60*60);
	cookie2.setMaxAge(60*60);
	
	// 3. 쿠키 전송
	// 쿠키는 응답할 때 전송하므로, response객체 사용
	response.addCookie(cookie);
	response.addCookie(cookie2);
	
	
	
	
%>


</body>
</html>