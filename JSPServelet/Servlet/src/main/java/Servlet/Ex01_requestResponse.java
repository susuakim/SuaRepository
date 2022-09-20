package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// URL Mapping : Servlet을 대체하는 문자열
// 사용이유 : 경로가 길면 불편하고, 경로가 노출이 되면 보안상의 문제가 있음
@WebServlet("/Ex01_requestResponse")

//								  -> Servlet은 HttpServlet 클래스를 상속 받는다.	
public class Ex01_requestResponse extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	               service 메소드 : Java의 main 메소드와 같은 역할
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		1. request 객체 : client가 요청을 했을 때, 요청에 대한 정보를 담고 있는 객체
//		ex) 요청이 들어온 주소, 요청할 때 넘겨운 데이터(사용자가 입력한 id, pw 등)
		
//		실습1. 내 servlet에 요청이 들어온 ip 주소를 확인하기
//		내 ip주소 확인 방법 : cmd > ipconfig > "ipv4"
		String client_id = request.getRemoteHost(); //string 형태로 반환한다
		System.out.println("들어온 사람 : " + client_id);
		
		
//		2. response 객체 : 사용자에게 응답할 때 사용하는 객체
//		ex) html 문서, Text, 페이지 이동 등등
		
//		응답할 html 문서에 대한 설정 필요
		response.setContentType("text/html; charset=utf-8");
		
//		웹에 출력하기 : PrintWrier 객체 사용
		PrintWriter out = response.getWriter();
		out.print("안녕하세요!");
		out.print("<h1> 여기는 김수아입니다.</h1>");
		
//		이미지 출력하기
//		Servlet 실행 위치 : webapp 폴더에서 실행
//		상대경로 현재폴더 ./
//		       상위폴더 ../
//		       최상위폴더 /
		out.print("<img src = 'img/img.jfif'>");
	}

}
