import model.MemberDAO;

public class View2 {

	public static void main(String[] args) {
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.update();
		if(cnt>0) {
			System.out.println();
		}else {
			System.out.println("��й�ȣ ���� ����");
		}
	}

}
