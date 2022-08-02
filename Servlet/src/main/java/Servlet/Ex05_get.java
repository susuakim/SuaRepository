package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex05_get")
public class Ex05_get extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
	
//		콘솔창에 출력하기
		System.out.println("이름은: " + name);
		System.out.println("나이는: " + age);
	
//		웹에 출력하기
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.print("당신의 이름은 " + name + "<br>");
		out.print("당신의 나이는 " + age + "<br>");
//		== response.getWriter().print("");
	}

}
