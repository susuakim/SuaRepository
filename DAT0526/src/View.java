import java.util.Scanner;

import db.JoinMember;
import model.MemberDTO;

public class View {

	public static void main(String[] args) {

		
		//joinMember Ŭ���� �ȿ� �ִ� insert() �޼ҵ� ȣ��
		
		
		while(true) {
			
			System.out.println("�޴��� �����ϼ���");
			System.out.print("[1]ȸ������ [2]ȸ���������� [3]ȸ��Ż�� [4]�α��� [5]������ >> ");
			
			Scanner sc = new Scanner(System.in);
			int menu = sc.nextInt();
			
			if(menu == 1) {
				System.out.println("====ȸ������====");
				
				System.out.print("ID �Է�>>");
				String id = sc.next();
				
				System.out.print("PW �Է�>>");
				String pw = sc.next();
				
				System.out.print("�̸� �Է�>>");
				String name = sc.next();
				
				MemberDTO dto = new MemberDTO(id, pw, name);
				JoinMember dao = new JoinMember();
				
				int cnt = dao.insert(dto);
	
				if(cnt > 0) {
					System.out.println("ȸ������ ����");
				}else {
					System.out.println("ȸ������ ����");
				}
				
			}else if(menu == 5) {
				System.out.println("����Ǿ����ϴ�.");
				break;
			}
			
			
			
		}
		
		
	}

}
