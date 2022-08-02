package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex03")
public class Ex03_url extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		ContextPath : WAS에서 웹어플리케이션을 구분하기 위한 Path => 프로젝트 이름
		System.out.println("ContextPath : " + request.getContextPath());
	
//		ServletPath : Servlet을 구분하기 위한 Path => URL Mapping 값
		System.out.println("ServletPath : " + request.getContextPath());
		
		System.out.println("requestURL : " + request.getRequestURL());
		
		System.out.println("requestURI : " + request.getRequestURI());
	
	
	}

}
