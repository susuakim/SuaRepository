package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BookDAO;
import model.BookDTO;



public class Q4_LoginCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		// 1. post방식 디코딩
		request.setCharacterEncoding("UTF-8");
		
		// 2. 데이터 받아오기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
//		완성되면 출력문 지우기
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		
		// 3. DTO로 묶기
		BookDTO dto = new BookDTO(id, pw);
	
		// 4. login메소드 호출
		BookDTO info = new BookDAO().login_member(dto);
		
		// 5. 실행결과 확인
		if(info != null) {
			System.out.println("로그인 성공");
			
			// 로그인한 정보 유지 - session사용
			HttpSession session = request.getSession();
			session.setAttribute("info", info);
		}else {
			System.out.println("로그인 실패");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("./Q4_Main.jsp");
		rd.forward(request, response);
	}

}
