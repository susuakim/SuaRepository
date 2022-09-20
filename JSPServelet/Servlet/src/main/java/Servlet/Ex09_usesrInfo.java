package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex09_usesrInfo")
public class Ex09_usesrInfo extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		1. Post 방식 디코딩(코드 -> 문자)
		request.setCharacterEncoding("UTF-8");
		
//		2. 사용자가 입력한 데이터 가져오기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String rpw = request.getParameter("rpw");
		String gender = request.getParameter("gender");
		String blood = request.getParameter("blood");
		String birth = request.getParameter("birth");
//		checkbox는 같은 name 값을 여러개의 데이터가 가지므로,
//		getParameterValues 사용 -> 배열 타입으로 변환
		String[] sport = request.getParameterValues("sport");
		String color = request.getParameter("color");
		String talk = request.getParameter("talk");
		
//		3. Web에 출력하기
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("id: "+ id + "<br>");
		out.print("pw: " + pw + "<br>");
		out.print("rpw: " + rpw + "<br>");
		out.print("성별: " + gender + "<br>");
		out.print("blood: " + blood + "<br>");
		out.print("birth: " + birth + "<br>");
		
		out.print("취미: ");
		for(int i=0; i<sport.length; i++) {
			out.print(sport[i] + " ");
		}
		out.print("<br>");

		out.print("color: " + color + "<br>");
		out.print("<div style='width:200px; height:200px; background-color : "+color+"'> </div>");
		out.print("<br>");
		out.print("talk: " + talk + "<br>");
		
		
		
		
		
	}

}
