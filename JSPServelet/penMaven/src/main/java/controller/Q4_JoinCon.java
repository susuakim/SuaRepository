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


public class Q4_JoinCon extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. post방식 디코딩
		request.setCharacterEncoding("UTF-8");
		
		// 2. 데이터 받아오기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nick = request.getParameter("nick");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");

		// 3. DTO로 묶기
		BookDTO dto = new BookDTO(id, pw, nick, email, tel);
		
		// 4. join메소드 호출
		int row = new BookDAO().insert_member(dto);
		
		// 5. 실행결과 확인하기
		String moveURL=null;
		if(row == 1) {
			System.out.println("회원가입 성공");
			moveURL="./Q4_Login.jsp";
		}else {
			System.out.println("회원가입 실패");

			moveURL="./Q4_Login.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(moveURL);
		rd.forward(request, response);
	}

}
