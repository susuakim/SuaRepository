package view; //��Ű���� ù���� �ҹ���,  Ŭ������ ù���� �빮��,, �� Ŭ�������� ����ϰ��� �Ѵ�.

import model.MemberDAO;
import model.MemberDTO;

public class View {

	public static void main(String[] args) {
		
	MemberDAO dao = new MemberDAO();
//	dao.select();
	
//	dao.selectName("rlatnwl");

	MemberDTO dto = new MemberDTO("rlatndk7777", "1234"); //�α����� �Ҷ� �̸��� �Է����� ������ id pw�� �ִ� �����ڵ� �߰��� �����
	
	
	dao.login(dto); //dto�ȿ��� id, pw �Ѵ� �ִ�.
	
	
		
	}

}
