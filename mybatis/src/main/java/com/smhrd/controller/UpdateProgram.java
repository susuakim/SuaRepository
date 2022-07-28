package com.smhrd.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.DAO;
import com.smhrd.model.DTO;

public class UpdateProgram extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("[UpdateProgram]");
		
		// 1.
		request.setCharacterEncoding("UTF-8");
		
		// 2. 
		String name = request.getParameter("rename");
		
		// 3. 
		String id="";
		Cookie[] cookies = request.getCookies();
		
		for(int i = 0; i < cookies.length; i++) {
			if(cookies[i].getName().equals("id")) {
				id = cookies[i].getValue();
				System.out.println("쿠키id값: " +  cookies[i].getValue());
			}
		}
		
		System.out.print("수정이름: "+ name);
		
		// 3. 
		DTO dto = new DTO(id, null, name);
		
		// 4.
		int row = new DAO().update(dto);
		System.out.print(row);
		
		// 5.
		Cookie cookie = new Cookie("name", URLEncoder.encode(name,"UTF-8"));	
		response.addCookie(cookie);
		
		response.sendRedirect("./Name.jsp");

	}

}
