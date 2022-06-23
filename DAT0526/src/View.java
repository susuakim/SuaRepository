import java.util.Scanner;

import db.JoinMember;
import model.MemberDTO;

public class View {

	public static void main(String[] args) {

		
		//joinMember 클래스 안에 있는 insert() 메소드 호출
		
		
		while(true) {
			
			System.out.println("메뉴를 선택하세요");
			System.out.print("[1]회원가입 [2]회원정보수정 [3]회원탈퇴 [4]로그인 [5]나가기 >> ");
			
			Scanner sc = new Scanner(System.in);
			int menu = sc.nextInt();
			
			if(menu == 1) {
				System.out.println("====회원가입====");
				
				System.out.print("ID 입력>>");
				String id = sc.next();
				
				System.out.print("PW 입력>>");
				String pw = sc.next();
				
				System.out.print("이름 입력>>");
				String name = sc.next();
				
				MemberDTO dto = new MemberDTO(id, pw, name);
				JoinMember dao = new JoinMember();
				
				int cnt = dao.insert(dto);
	
				if(cnt > 0) {
					System.out.println("회원가입 성공");
				}else {
					System.out.println("회원가입 실패");
				}
				
			}else if(menu == 5) {
				System.out.println("종료되었습니다.");
				break;
			}
			
			
			
		}
		
		
	}

}
