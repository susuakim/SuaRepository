package view; //패키지는 첫글자 소문자,  클래스는 첫글자 대문자,, 뷰 클래스에서 출력하고자 한다.

import model.MemberDAO;
import model.MemberDTO;

public class View {

	public static void main(String[] args) {
		
	MemberDAO dao = new MemberDAO();
//	dao.select();
	
//	dao.selectName("rlatnwl");

	MemberDTO dto = new MemberDTO("rlatndk7777", "1234"); //로그인을 할때 이름은 입력하지 않으니 id pw만 있는 생성자도 추가로 만들기
	
	
	dao.login(dto); //dto안에는 id, pw 둘다 있다.
	
	
		
	}

}
