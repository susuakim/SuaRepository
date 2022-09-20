package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex06_plus")
public class Ex06_plus extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num1"));
		
		System.out.println(num1 + " 과" + num2 + " 의 합은" + (num1+num2));
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.print(num1 + "과 " + num2 + "의 합은 " + (num1+num2));
		
	}

}
