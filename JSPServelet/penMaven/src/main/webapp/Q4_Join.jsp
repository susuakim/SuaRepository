<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
fieldset {
	display: inline;
}
legend{
text-align: center;
}
</style>
</head>
<body>
	<form action="Q4_JoinCon">
		<fieldset>
			<legend>회원가입</legend>
			<table>
				<tr>
					<td>ID</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>PW</td>
					<td><input type="password" name="pw"></td>
				</tr>
				<tr>
					<td>NICKNAME</td>
					<td><input type="text" name="nick"><input type="submit" value="전송"></td>
					
				</tr>
				<tr>
					<td>EMAIL</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td>TEL</td>
					<td><input type="text" name="tel"></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>