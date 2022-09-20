<%@page import="model.BookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
fieldset{
display:inline;
height: 300px;
}
button{
/*  width: 100px;*/
padding: 50px 50px;
}
legend{
text-align: center;
}
</style>
</head>
<body>
<%BookDTO info = (BookDTO)session.getAttribute("info");%>
		<%
		if(!info.getId().equals("admin")) {
		%>
<fieldset>
<legend><%=info.getNick()%>님 환영합니다.</legend>

<button>도서검색</button>
<button>나의책방</button>
<button>즐겨찾기</button>
<button>회원정보</button>
</fieldset>
		<%
		} else if (info.getId().equals("admin")) {
		%>
<fieldset>
<legend><%=info.getNick()%>님 환영합니다.</legend>

<button>회원관리</button>
<button>도서관리</button>
<button>대여관리</button>
<button>재고관리</button>
<%} %>
</fieldset>
</body>
</html>