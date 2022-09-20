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
}
.login{
margin-left: 5px;
}
legend{
text-align: center;
}
</style>
</head>
<body>
<form action="Q4_LoginCon">
<fieldset>
<legend>도서관리시스템</legend>
<table>
<tr>
<td>ID</td> 
<td><input type="text" name="id"></td>
</tr>

<tr>
<td>PW</td> 
<td><input type="text" name="pw"><input class="login" type="submit" value="로그인"></td>
</tr>
</table>

아이디가 없다면 <a href="./Q4_Join.jsp">회원가입</a> 클릭

</fieldset>
</form>
</body>
</html>