package Model;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	
	//DAO : Data Access object 데이터베이스에 접근할 수 있는 객체
	
	PreparedStatement psmt = null;
	Connection conn = null;
	ResultSet rs = null;
	
	// DD 연결 메소드
	public void db_conn() {
		
		try {
		
		// 1. ojdbc6.jar 라이브러리 불러오기
		// C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib
		//	webapp > WEB-INF > lib 폴더에 넣기
					
		// 2. OracleDriver 클래스 불러오기
		// OracleDriver : Java-DB사이에 통로를 만들어주는 역할
		Class.forName("oracle.jdbc.driver.OracleDriver"); //try-catch 해주기
					
		// 3-1. DB에 접속하기 위한 카드키 설정(주소, 계정, 비번)
		//db 주소 : Data Source Explorer > New Oracle > 오른쪽 마우스 > Properties > connection URL
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
		String db_user = "hr";
		String db_pw = "hr";
					
		// 3-2. 카드키로 DB 문 열기	
		conn = DriverManager.getConnection(url, db_user, db_pw); //try-catch 해주기
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// DB연결 종료 메소드
	public void db_close() {

		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
	} catch(SQLException e) {
		e.printStackTrace();
		}
			
	}
	
	// 회원가입 기능
	public int join(DTO dto) {

		int row = 0;
		
		try {
			db_conn();
				
			// 4. SQL 쿼리 작성
			String sql = "insert into Member values(?, ?, ?)";
			
			// 5. SQL문장을 DB에 전달 - 
			psmt = conn.prepareStatement(sql);
			
			// 6. 
			// psmt.setString
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());
			psmt.setString(3,  dto.getName());
			
			//  7. 
			// executeUpdate : 
			row = psmt.executeUpdate();
			
			
			}catch (Exception e) {
				e.printStackTrace();
			} finally { //
				// 8.
				db_close();
			} return row;
		}

	
	// 
	public String login(DTO dto) {
		
		String name = null;
		
		// 1. ojdbc6.jar
		// 2. OracleDriver
		try {
			
			db_conn();
			// 4.
			String sql = "select * from Member where id=? and pw=?";
			
			// 5. 
			psmt = conn.prepareStatement(sql);
			
			// 6. 
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());
			
			// 7.
			rs = psmt.executeQuery();
			
			// rs.next()
			if(rs.next()) {
				name = rs.getString("name");
//				String name = rs.getString(3);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db_close();
			
	} return name;
		
	}
}
