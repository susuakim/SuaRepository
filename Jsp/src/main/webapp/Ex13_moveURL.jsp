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

	String site = request.getParameter("site");
	
	if(site.equals("네이버")){
		response.sendRedirect("https://www.naver.com");
	}else if(site.equals("구글")){
		response.sendRedirect("https://www.google.com");
	}else if(site.equals("유튜브")){
		response.sendRedirect("https://www.youtube.com");
	}
	
%>

</body>
</html>