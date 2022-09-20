<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 3. 선언문 : 클래스 영역에 선언하기 위해서 사용하는 문법 -->
<%! 
	// 합을 구하는 메소드
	// 메인이 없기때문에 static을 사용하지 않아도 됨
	public int add(int a, int b){
		return a+b;
}
%>

<% int result = add(1, 2); %>

<%= result %>

</body>
</html>