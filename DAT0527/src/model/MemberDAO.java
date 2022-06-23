package model; //��Ű���� ù���� �ҹ���,  Ŭ������ ù���� �빮��

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;//����� �� ��δ� �ٲ����ʴ´�

public class MemberDAO { // member ���̺� �����ؼ� ������(DAO) Ŭ����

	Connection conn; // *3������ ����� pre~�� ����ϱ����� ���������� �����ؾ� ��(DB������ ���� ��ü)
	PreparedStatement psmt; // **3������ ����� SQL���� �����ϴ� ��ü
	ResultSet rs; // ***������ ������� �޾ƿ��� ��ü

	public void select() { // db�� �����ؼ� �����͸� ������ �Լ�

		// jdbc�� �����ϱ�����, �����ϱ����� 4�ܰ谡 �ִ�.(�������ؾ� ��)
		// 1. �����ε� 2. DB���� 3. SQL�� ���� 4. ��������(��������)

		// 1.
		// �����ε�---------------------------------------------------------------------------------------------------
		// �����ε� -> �ܺο� �־ �ڹ�����(ojdbc6.jar)�� �߰��������(�ܺο���)
		// 1-1. class.forname() Ŭ�������� ã��!

		// �ڹٰ� ����Ǵµ��� ����ؼ� ����ǰ� �ϴ°�
		// �̰�η� ����Ŭ�� ����Ҽ��մ�.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // ->����ó���� �ؾ��ϴ� ������ 1.Ư���� ��Ȳ�� ���ܰ� �߻��Ҽ��־ �� �Ʒ��� ������
																// �����ϱ����ؼ�, 2. ������ ���Ŀ� �� �� �ִ� ������ ���ؼ� ����ó���ؾ� �Ѵ�. 3. ��ΰ�
																// ��Ÿ�� ���� �־
			System.out.println("����̹� �ε� ����");

		} catch (ClassNotFoundException e) { // ������ Ȯ���� �� �ִ� Ŭ�����̸�
			e.printStackTrace(); // ������ ����ڿ��� �����ִ� �޼ҵ�
		}

		// 2.
		// db����-----------------------------------------------------------------------------------------------------

		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe"; // db�ּҸ� ���� url ����
		String db_id = "hr"; // db�� �����ϱ����ؼ��� id, pw�� �ʿ���
		String db_pw = "hr";

		// db������ ���� ��ü(Ŭ����) =>db��� ����� ����.
		// == connection ��ü(connection�� ��ζ�� �����ϸ� �ȴ�)

		try {
			conn = DriverManager.getConnection(url, db_id, db_pw);// *�������� ���������� ����ȴٸ� conn�� null�� �ƴϴ�
			if (conn != null) {
				System.out.println("db ���� ����");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 3. SQL��
		// ����--------------------------------------------------------------------------------------------------
		// PreparedStatement: sql�� �����ϴ� ��ü(**connection�� ����Ͽ� �����ϱ⶧���� conn��, psmt�� ����������
		// �ؾ��Ѵ�, conn, psmt�� ���⼭ �ҷ��� ���̴�)

		String sql = "select * from member";

		try {
			psmt = conn.prepareStatement(sql); // **�̰͵� ����ó�����ֱ�
			rs = psmt.executeQuery(); // ***1) prepareStatement�� �غ����̴ϱ� ������ ��������� ��
			// 2) �÷� ī��Ű�� Resultset ȭ��ǥ�� ��ĭ ������.

			System.out.print("ID" + "\t\t");
			System.out.print("PW" + "\t");
			System.out.println("NAME");

			while (rs.next()) { // ���ϰ� boolean�̰�, ȭ��ǥ�� ���� ������ true�̰� ���� �������� �����̴�.
				String id = rs.getString(1); // 3) ȭ��ǥ�� ���� ���� ���, �� �ε����� 1���� �����Ѵ�
				String pw = rs.getString(2); // ��, member ���̺��� �� 3�� �÷��� ������ ���� �ε��� 1,2,3 �̴�
				String name = rs.getString(3);
				System.out.print(id + "\t");
				System.out.print(pw + "\t");
				System.out.println(name);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			// 4��.
			// ��������-----------------------------------------------------------------------------------------------------
			// conn->psmt->rs ������ ��θ� ������, �ݴ�� �ݱ�
		} finally {

			try {
				if (rs != null) {
					rs.close(); // ***rs.close()�� �ٷ� �������������� rs�� ���������� ����� �� ������ ���������� �������ֱ�,, �׸��� �ݱ� �ݴµ�
								// ������������ �ݾ��ֱ� ��!!
				}

				if (psmt != null) {
					psmt.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		System.out.println("hello world");
	}

	public void selectName(String id) { // ȸ�� id�� ���ؼ� ȸ���̸� �˻��ϴ� Ŭ����

		// 1. �����ε� 2.DB���� 3.SQL�� ���� 4.��������

		// 1.
		// �����ε�-------------------------------------------------------------------------------
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� ����");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 2.
		// DB����----------------------------------------------------------------------------------------------
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String db_id = "hr";
		String db_pw = "hr";

		try {
			conn = DriverManager.getConnection(url, db_id, db_pw);
			if (conn != null) {
				System.out.println("DB ���� ����");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 3. SQL��
		// ����--------------------------------------------------------------------------------
		// member ���̺��� NAME COLUMN�� select�ؼ�, ID���� 'rlatnwl'�� ���̺��� select�Ѵ�
		String sql = "select name from member where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			// ?�� �ݵ�� execute���� ������ �Ǿ� �־�� �Ѵ�.
			psmt.setString(1, id); // ?�� id�� ä���� �ִ�
			rs = psmt.executeQuery(); // db���� ã�� ���� �ٽ� �츮���� ��������ϴϱ� rs�� �ޱ�
			if (rs.next()) {
				// rlatnwl id�� �ش��ϴ� �̸��� ~~~~ �Դϴ�.
				String name = rs.getString(1); // rs.getString("NAME");���� ���൵ �ȴ�.
				System.out.println(id + "�� �ش��ϴ� �̸���" + name);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			//4. ���� ����------------------------------------------------------------------------
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(psmt != null) {
					psmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("�̰ǿ���=> �����");
	}

	public void login(MemberDTO dto) { //�α����ҰŴϱ� id�� select�ؼ� ����ڰ� �� id�� ������ �α��� ����
		// 1. �����ε� 2.DB���� 3.SQL�� ���� 4.��������

		// 1.
		// �����ε�-------------------------------------------------------------------------------
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� ����");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 2.
		// DB����----------------------------------------------------------------------------------------------
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String db_id = "hr";
		String db_pw = "hr";

		try {
			conn = DriverManager.getConnection(url, db_id, db_pw);
			if (conn != null) {
				System.out.println("DB ���� ����");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 3. SQL��-----------------------------------------------------------------------------------------------
		//id, pw 
		//membr ���̺��� PW COLUMN SELECT
		//ID�� ���� id�� ��
		//��ġ�ϸ� '�α��� ����', �������� ������ '�α��� ����'

		String sql = "select pw from member where id = ?";//****����ǥ�� �ִٸ� �ݵ�� ä������Ѵ�
		try {
			psmt = conn.prepareStatement(sql);
			// ?�� �ݵ�� execute���� ������ �Ǿ� �־�� �Ѵ�.
			psmt.setString(1, dto.getId()); //****?�� id�� ä���� �ִ�
			rs = psmt.executeQuery(); // db���� ã�� ���� �ٽ� �츮���� ��������ϴϱ� rs�� �ޱ�
			if (rs.next()) {
				String result = rs.getString(1); // rs.getString("pw");���� ���൵ �ȴ�.
				if(result.equals(dto.getPw())) {
					System.out.println("�α��� ����");
				}else {
					System.out.println("�α��� ����");
				}
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		//4. ���� ����-----------------------------------------------------------------------------------------
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(psmt != null) {
					psmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		System.out.println("�̰Ƿα���=> �����");
	}
	
		
}
