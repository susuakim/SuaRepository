package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

import model.MemberDTO;

public class JoinMember {



	public int insert (MemberDTO dto) {
		
		int cnt = 0;
		
		Connection conn = null; //conn�� �������� ���� �� �־
		PreparedStatement psmt = null;
		
		//1. �����ε�
		//1-1. ojdbc6.jar �����߰��ϰ�
		//���� �ε��� class file ã��	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");		
			System.out.println("����̹� �ε� ����");
			
			//2. DB ����
			//1)url 2) db_id 3) db_pw
			String url ="jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String db_id ="hr";
			String db_pw ="hr";
			
			conn = DriverManager.getConnection(url, db_id, db_pw);
			//!conn.isClosed()
			if(conn != null) {
				System.out.println("���� ����");				
			}
			
			String id = dto.getId();
			String pw = dto.getPw();
			String name = dto.getName();
			
			
			
			//3. SQL ����
			String sql = "insert into member values(?, ?, ?)";
			psmt = conn.prepareStatement(sql);
			
			// C: create(insert), R: read(select), U: update(update), D: delete(delete)
			
			//executeUpdate(); => c, u, d�� �����Ҷ� ���
			//executeQuery(); => r�� ������ �� ���
			
			//sql���� �����ϱ����� ?�� ä����
			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, name);
				
			
			cnt = psmt.executeUpdate(); //int Ÿ���̶� ���� �������
	
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("�ε� ����");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("���� ����");
			System.out.println("ȸ������ ����");
		} finally { //try-catch ���࿩�� ������� ������ ����ǰ� �Ǿ��ִ�.
			//4. ��������: �������� �ݴ´�
			//psmt �ݱ�, conn �ݱ�			
			try {
				if(psmt != null) {
					psmt.close();									
				}
				if(conn != null) {
					conn.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return cnt;
	}

}
