<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
fieldset{
	display: inline;
	}
</style>
</head>
<body>

<% 
// 1. post 방식 디코딩(코드 -> 문자)
request.setCharacterEncoding("UTF-8");

// 2. 데이터 받아오기
String name = request.getParameter("name");

// 3. 점수 데이터는 연산을 위해 int형으로 변환
int java = Integer.parseInt(request.getParameter("java"));
int python = Integer.parseInt(request.getParameter("python"));
int web = Integer.parseInt(request.getParameter("web"));
int machineLearning = Integer.parseInt(request.getParameter("machineLearning"));

// 4. 평균
int avg = (java+python+web+machineLearning)/4;
%>

<%! 
// 5. 학점

public String result(int java, int python, int web, int machineLearning){

		int avg = (java+python+web+machineLearning)/4;
		if(avg == 100){
			return "A+";
		}else if(avg >= 90 && avg <= 99){
			return "A";
		}else if(avg >= 80 && avg <= 89){
			return "B";
		}else if(avg >= 70 && avg <= 79){
			return "C";
		}else{
			return "D";
		}
}
%>

<fieldset>
	<legend> 학점 확인 프로그램</legend>
	<table>
		<tr>
			<td> 이름 </td>
			<td><%= name %></td>
		</tr>
		
		<tr>
			<td> Python 점수 </td>
			<td><%= java %></td>
		</tr>
		
		<tr>
			<td> Web 점수 </td>
			<td><%= web %></td>
		</tr>
		
		<tr>
			<td> Machine Learning 점수 </td>
			<td><%= machineLearning %></td>
		</tr>
		
		<tr>
			<td> 평균 </td>
			<td><%= avg %></td>
		</tr>
		
		<tr>
			<td> 학점 </td>
			<td><%= result(java, python, web, machineLearning) %></td>
		</tr>		
	</table>

</fieldset>

</body>
</html>