package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex04_get")
public class Ex04_get extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		사용자가 입력한 데이터를 받아오는 Servlet
//		== action에 적힌 주소
		
//		request객체 : 요청과 관련된 모든 정보를 담고 있는 객체
//		== 로그인버튼, 센드버튼을 누르면 입력한 데이터가 request객체게 담겨지게 되고, 데이터를 꺼내오게 되었을때도 request객체를 이용
//		request.getParameter("form 태그에서 입력한 name 값")
		String data = request.getParameter("data");
		System.out.println("사용자가 입력한 값은 : " + data);
	}

}
