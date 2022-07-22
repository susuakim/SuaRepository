package Session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ex03_makeSession")
public class ex03_makeSession extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Session : client의 정보를 유지하기 위해서 사용
		// 1. 저장위치 : ServerPC
		// 2. 보안 : 상대적으로 강력
		// 3. 자원 : Server의 자원을 사용하기 때문에 남발X
		// 4. 용량제한 : Server가 허용하는 한 제한X
		// 5. 저장형식 : Object -> 모든 객체를 담을 수 있다
		
		// 1. Session 객체 생성
		HttpSession session = request.getSession();
		
		// 2. Session 생성
		// session의 값은 Object : 모든 객체를 담을 수 있다
		// session 이름이 같으면 덮어쓰기가 된다
		session.setAttribute("이름", "김수아");
		session.setAttribute("나이", "20");
		
		// 3. Session 유효기간 설정
		// 단위 : 초
		// 일정 시간동안 요청이 없으면 session을 제거
		session.setMaxInactiveInterval(60*60);
		
		response.getWriter().print("<h1> Making Session </h1>");
	}

}
