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
		
		Connection conn = null; //conn이 생성되지 않을 수 있어서
		PreparedStatement psmt = null;
		
		//1. 동적로딩
		//1-1. ojdbc6.jar 파일추가하고
		//동적 로딩할 class file 찾기	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");		
			System.out.println("드라이버 로딩 성공");
			
			//2. DB 연결
			//1)url 2) db_id 3) db_pw
			String url ="jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String db_id ="hr";
			String db_pw ="hr";
			
			conn = DriverManager.getConnection(url, db_id, db_pw);
			//!conn.isClosed()
			if(conn != null) {
				System.out.println("접속 성공");				
			}
			
			String id = dto.getId();
			String pw = dto.getPw();
			String name = dto.getName();
			
			
			
			//3. SQL 실행
			String sql = "insert into member values(?, ?, ?)";
			psmt = conn.prepareStatement(sql);
			
			// C: create(insert), R: read(select), U: update(update), D: delete(delete)
			
			//executeUpdate(); => c, u, d를 실행할때 사용
			//executeQuery(); => r를 실행할 때 사용
			
			//sql문을 실행하기전에 ?를 채우자
			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, name);
				
			
			cnt = psmt.executeUpdate(); //int 타입이라서 갯수 출력해줌
	
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("로딩 실패");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("접속 실패");
			System.out.println("회원가입 실패");
		} finally { //try-catch 실행여부 상관없이 무조건 실행되게 되어있다.
			//4. 연결종료: 역순으로 닫는다
			//psmt 닫기, conn 닫기			
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
