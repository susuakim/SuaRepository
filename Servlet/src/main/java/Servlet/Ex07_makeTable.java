package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex07_makeTable")
public class Ex07_makeTable extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		int cnt = Integer.parseInt(request.getParameter("cnt"));
		String color = request.getParameter("color");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<style> table{ background-color :" + color + ";} </style>");
		out.print("<table border=1 >" + "<tr>");
		
		for(int i = 1; i <= cnt; i++) {
			out.print("<td>" + i + "</td>");
		}
		
		out.print("</tr>" + "</table>");
		
	}

}
