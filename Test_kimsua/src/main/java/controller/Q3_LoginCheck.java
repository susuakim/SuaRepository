package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Q3_LoginCheck")
public class Q3_LoginCheck extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터 받아오기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// 사용자 id, pw 변수 정의
		String user_id = "smhrd"; 
		String user_pw = "1234";
		
		// 세션 객체 생성
		HttpSession session = request.getSession();
		
		if(id.equals(user_id) && pw.equals(user_pw)) {
			session.setAttribute("id", user_id);
			response.sendRedirect("Q3_main.jsp");
		}else {
			response.sendRedirect("Q3_loginForm.html");
		}
		
	}

}
