package com.smhrd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.smhrd.model.MemberDAO;
import com.smhrd.model.MemberDTO;

@WebServlet("/ShowMember")
public class ShowMember extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("[ShowMember]");
		
		// 회원list 가지고 오기
		ArrayList<MemberDTO> list = new MemberDAO().showMember();
		
		// Gson : Java에서 Json을 파싱하고 생성하기 위해 사용되는 구글에서 개발한 오픈소스
		//		: Java객체를 Json으로 변환 or Json을 Java객체로 변환
		
		// Gson라이브러리 pom.xml에 추가하기
		// 참고 블로그 : https://hianna.tistory.com/629
		
		// Gson 객체생성 
		Gson gson = new Gson();
		
		// Java객체 -> Json으로 변환
		String json = gson.toJson(list);
		System.out.println(json);
		
		// Json으로 응답해주기
		PrintWriter out = response.getWriter();
		out.print(json);
	}

}
