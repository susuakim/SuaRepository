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
		<legend>업데이트</legend>
		<form action="UpdateProgram">
			<h2> 수정하고 싶은 이름을 적어주세요 </h2><br>
			rename: <input type="text" name="rename"><br> 
			<input type="submit" value="전송">
		</form>
	</fieldset>


</body>
</html>