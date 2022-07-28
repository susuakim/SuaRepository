<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
fieldset{
	display : inline;
}
</style>

</head>
<body>

<fieldset>
<legend> 회원가입 </legend>
	<form action="JoinProgram" method="post">
	
				ID: <input type="text" name="id"><br>
				PW: <input type="text" name="pw"><br>
				NAME: <input type="text" name="name"><br>
				<input type="submit" name="회원가입">

	</form>

</fieldset>

</body>
</html>