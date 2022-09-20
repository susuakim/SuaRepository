package com.smhrd.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.DAO;
import com.smhrd.model.DTO;

public class LoginProgram extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.print("[LoginProgram]");
		
		// 1. post방식 디코딩
		request.setCharacterEncoding("UTF-8");
		
		// 2. id, pw 받아오기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//---------------------------------------------------------------		
		Cookie cookie = new Cookie("id", URLEncoder.encode(id,"UTF-8"));
		
		response.addCookie(cookie);	
		//---------------------------------------------------------------
		// 3. DTO로 묶기
		DTO dto = new DTO(id, pw);
		
		// 4. 로그인 기능 login 메소드 호출
		String name = new DAO().login(dto);
		
		// 5. 로그인 성공실패 여부 확인
		if(name != null) {
			System.out.println("로그인 성공");
			// name값 전송 => 쿼리스트링 방식 사용
			// ? : 데이터 표현의 시작점
			// key = value의 형태로 데이터 전송
			// name 값 인고딩(문자->코드) 진행
			// URLEncoder.encode("인코딩할 값", "인코딩 방식")
			// response.sendRedirect("./LoginSuccess.jsp?name=" + URLEncoder.encode(name, "UTF-8"));
			
			// 2. session 사용
			HttpSession session = request.getSession();
			
			// session 생성
			session.setAttribute("name", name);
			
			response.sendRedirect("./LoginSuccess.jsp");
			
		}else {
			System.out.println("로그인 실패");
			response.sendRedirect("./LoginFail.jsp");
		}
	}

}
