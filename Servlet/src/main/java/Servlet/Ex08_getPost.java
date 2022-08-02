package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex08_getPost")
public class Ex08_getPost extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		디코딩 : 코드 -> 문자
//		Get방식 디코딩
//		Server폴더 > server.xml > 63번째 줄 connector태그 밑에 > URIEncoding="인코딩방식"

//		post 디코딩
//		request객체에 디코딩 방식을 지정
//		데이터를 꺼내오기 전에 디코딩부터 진행
		request.setCharacterEncoding("UTF-8");
		
		
//		데이터 보낸 방식 확인하기(get or post)
		String method = request.getMethod();
		System.out.println("방식:  " + method);
		
//		데이터 받아오기
		String data = request.getParameter("data");
		System.out.println("데이터:  " + data);
	}

}
