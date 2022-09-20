package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.DTO;


@WebServlet("/JoinProgram")
public class JoinProgram extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("[JoinProgram]");
		
		// 1. post방식 디코딩
		request.setCharacterEncoding("UTF-8");
		
		// 2. id, pw, name 데이터 받아오기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		System.out.println("id>>  " + id);
		System.out.println("pw>>  " + pw);
		System.out.println("name>>  " + name);
		
		// 3.
		// DAO = new DAO();
		// dao.join(id, pw, name);
		
		DTO dto = new DTO(id, pw, name);
		
		int row = new DAO().join(dto);
		
		if(row == 1) {
			System.out.println("join succed");
		}else {
			System.out.println("join fail");
		}
		
		// main.jsp
		response.sendRedirect("./Main.html");
	}

}
