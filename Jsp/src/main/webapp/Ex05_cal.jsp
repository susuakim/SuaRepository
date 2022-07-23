<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%! 

public int add(int num1, int num2){
		return num1+num2;
}

public int sub(int num1, int num2){
	return num1-num2;
}

public int mul(int num1, int num2){
	return num1*num2;
}

public int div(int num1, int num2){
	return num1/num2;
}

%>

<% 
response.setContentType("text/html; charset=utf-8");

int num1 = Integer.parseInt(request.getParameter("num1"));
int num2 = Integer.parseInt(request.getParameter("num2"));

int addRE = add(num1, num2);
int subRE = sub(num1, num2);
int mulRE = mul(num1, num2);
int divRE = div(num1, num2);

%>
 
<%= num1 %> + <%= num2 %> = <%= addRE %> <br> 
<%= num1 %> - <%= num2 %> = <%= subRE %> <br>
<%= num1 %> * <%= num2 %> = <%= mulRE %> <br>
<%= num1 %> / <%= num2 %> = <%= divRE %> <br>

</body>
</html>