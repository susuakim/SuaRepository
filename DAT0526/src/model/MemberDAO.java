package model;

public class MemberDAO {
	
	int cnt; // ���� ���� ������ �����ϴ� ����
	
	public int update() {
		
		cnt = 0;
		
		//1. ����
		//1-1. ojdbc6.jar ���� �߰�
		//oracleDriverŬ���� �ε�
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2. DB ����
		//3. SQL ����
		//4. �ݱ�
		
		
		return cnt;
	}

}
