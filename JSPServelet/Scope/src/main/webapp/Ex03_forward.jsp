<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> forward방식 </h1>
	<ul>
		<li> 요청이 들어오면 서버에서 이동해야할 페이지로 알아서 이동 </li>
		<li> 요청이 1번, 처음 요청했던 request 객체에 담긴 정보(id, pw)가 유효함 </li>
		<li> 요청이 1번이라서 네트워크 트레픽이 발생X, 그래서 실행속도 빠름 </li>
		<li> request 객체를 사용하기 때문에 Object 타입으로 모든 객체를 담을 수 있음</li>
		<li> 단점 : 서버 내에서만 이동이 가능 </li>
	</ul>
	
	<h1> sendRedirect 방식 </h1>
	
	<ul>
		<li> 요청이 들어오면 서버에서 이동해야 할 페이지를 응답해서 다시 요청할 수 있도록 함 </li>
		<li> 요청이 2번이고, 서로 다른 request 객체라서 데이터 전송을 할 때 쿼리스트링 방식을 사용해야 함</li>
		<li> 쿼리스트링 방식에는 데이터를 보내기 위한 타입은 Text 형태로만 데이터 전송 가능</li>
		<li> 요청이 2번이라서 네트워크 트래픽이 발생하고, 실행 속도가 느림</li>
		<li> 이동할 페이지로 새롭게 요청을 하는 것이라서, 다른 서버의 페이지로 이동 가능</li>
		<li> </li>
	</ul>

<%	
	// sendRedirect로 다른 서버로 이동 가능
	//response.sendRedirect("http://www.naver.com");
	
	// forward를 통해서는 다른 서버 이동이 불가능
	//RequestDispatcher rd = request.getRequestDispatcher("http://www.naver.com");
	//rd.forward(request, response);
%>
</body>
</html>