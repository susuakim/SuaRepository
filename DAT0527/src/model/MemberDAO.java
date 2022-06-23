package model; //패키지는 첫글자 소문자,  클래스는 첫글자 대문자

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;//참고로 이 경로는 바뀌지않는다

public class MemberDAO { // member 테이블에 접근해서 접근할(DAO) 클래스

	Connection conn; // *3번에서 사용할 pre~이 사용하기위해 전역변수로 선언해야 함(DB연결을 위한 객체)
	PreparedStatement psmt; // **3번에서 사용할 SQL문을 실행하느 객체
	ResultSet rs; // ***쿼리의 결과값을 받아오는 객체

	public void select() { // db에 접근해서 데이터를 가져올 함수

		// jdbc를 실행하기위한, 연결하기위한 4단계가 있다.(무조건해야 함)
		// 1. 동적로딩 2. DB연결 3. SQL문 실행 4. 연결종료(역순으로)

		// 1.
		// 동적로딩---------------------------------------------------------------------------------------------------
		// 동적로딩 -> 외부에 있어서 자바파일(ojdbc6.jar)을 추가해줘야함(외부에서)
		// 1-1. class.forname() 클래스파일 찾기!

		// 자바가 실행되는동안 계쏙해서 실행되게 하는것
		// 이경로로 오라클을 사용할수잇다.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // ->예외처리를 해야하는 이유는 1.특별한 상황에 예외가 발생할수있어서 그 아래도 무조건
																// 실행하기위해서, 2. 컴파일 이후에 알 수 있는 오류에 대해서 예외처리해야 한다. 3. 경로가
																// 오타날 수도 있어서
			System.out.println("드라이버 로딩 성공");

		} catch (ClassNotFoundException e) { // 에러를 확인할 수 있는 클래스이름
			e.printStackTrace(); // 에러를 사용자에게 보여주는 메소드
		}

		// 2.
		// db연결-----------------------------------------------------------------------------------------------------

		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe"; // db주소를 받을 url 변수
		String db_id = "hr"; // db에 연결하기위해서는 id, pw가 필요함
		String db_pw = "hr";

		// db연결을 위한 객체(클래스) =>db통로 열어보러 간다.
		// == connection 객체(connection은 통로라고 생각하며 된다)

		try {
			conn = DriverManager.getConnection(url, db_id, db_pw);// *오른쪽이 정상적으로 실행된다면 conn은 null이 아니다
			if (conn != null) {
				System.out.println("db 연결 성공");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 3. SQL문
		// 실행--------------------------------------------------------------------------------------------------
		// PreparedStatement: sql을 실행하는 객체(**connection을 사용하여 전달하기때문에 conn도, psmt도 전역변수로
		// 해야한다, conn, psmt도 여기서 불러올 것이다)

		String sql = "select * from member";

		try {
			psmt = conn.prepareStatement(sql); // **이것도 예외처리해주기
			rs = psmt.executeQuery(); // ***1) prepareStatement는 준비중이니까 실제로 실행해줘야 함
			// 2) 컬럼 카리키는 Resultset 화살표를 한칸 내린다.

			System.out.print("ID" + "\t\t");
			System.out.print("PW" + "\t");
			System.out.println("NAME");

			while (rs.next()) { // 리턴값 boolean이고, 화살표가 다음 있을때 true이고 값이 있을때만 돌것이다.
				String id = rs.getString(1); // 3) 화살표된 행의 값을 얻고, 열 인덱스는 1부터 시작한다
				String pw = rs.getString(2); // 즉, member 테이블에는 총 3개 컬럼이 있으니 각각 인덱스 1,2,3 이다
				String name = rs.getString(3);
				System.out.print(id + "\t");
				System.out.print(pw + "\t");
				System.out.println(name);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			// 4번.
			// 연결종료-----------------------------------------------------------------------------------------------------
			// conn->psmt->rs 순으로 통로를 열었고, 반대로 닫기
		} finally {

			try {
				if (rs != null) {
					rs.close(); // ***rs.close()로 바로 닫을려고했지만 rs가 지역변수라서 사용할 수 없으니 전역변수로 선언해주기,, 그리고 닫긴 닫는데
								// 열려있을때만 닫아주기 꼭!!
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

	public void selectName(String id) { // 회원 id를 통해서 회원이름 검색하는 클래스

		// 1. 동적로딩 2.DB연결 3.SQL문 실행 4.연결종료

		// 1.
		// 동적로딩-------------------------------------------------------------------------------
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 2.
		// DB연결----------------------------------------------------------------------------------------------
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String db_id = "hr";
		String db_pw = "hr";

		try {
			conn = DriverManager.getConnection(url, db_id, db_pw);
			if (conn != null) {
				System.out.println("DB 연결 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 3. SQL문
		// 실행--------------------------------------------------------------------------------
		// member 테이블을 NAME COLUMN을 select해서, ID값이 'rlatnwl'인 테이블을 select한다
		String sql = "select name from member where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			// ?는 반드시 execute전에 설정이 되어 있어야 한다.
			psmt.setString(1, id); // ?에 id가 채워져 있다
			rs = psmt.executeQuery(); // db에서 찾은 값을 다시 우리한텐 돌려줘야하니까 rs로 받기
			if (rs.next()) {
				// rlatnwl id에 해당하는 이름은 ~~~~ 입니다.
				String name = rs.getString(1); // rs.getString("NAME");으로 해줘도 된다.
				System.out.println(id + "에 해당하는 이름은" + name);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			//4. 연결 종료------------------------------------------------------------------------
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

		System.out.println("이건예시=> 김수아");
	}

	public void login(MemberDTO dto) { //로그인할거니까 id로 select해서 사용자가 한 id와 같으면 로그인 성공
		// 1. 동적로딩 2.DB연결 3.SQL문 실행 4.연결종료

		// 1.
		// 동적로딩-------------------------------------------------------------------------------
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 2.
		// DB연결----------------------------------------------------------------------------------------------
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String db_id = "hr";
		String db_pw = "hr";

		try {
			conn = DriverManager.getConnection(url, db_id, db_pw);
			if (conn != null) {
				System.out.println("DB 연결 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 3. SQL문-----------------------------------------------------------------------------------------------
		//id, pw 
		//membr 테이블의 PW COLUMN SELECT
		//ID의 값이 id인 것
		//일치하면 '로그인 성공', 일지하지 않으면 '로그인 실패'

		String sql = "select pw from member where id = ?";//****물음표가 있다면 반드시 채어줘야한다
		try {
			psmt = conn.prepareStatement(sql);
			// ?는 반드시 execute전에 설정이 되어 있어야 한다.
			psmt.setString(1, dto.getId()); //****?에 id가 채워져 있다
			rs = psmt.executeQuery(); // db에서 찾은 값을 다시 우리한텐 돌려줘야하니까 rs로 받기
			if (rs.next()) {
				String result = rs.getString(1); // rs.getString("pw");으로 해줘도 된다.
				if(result.equals(dto.getPw())) {
					System.out.println("로그인 성공");
				}else {
					System.out.println("로그인 실패");
				}
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		//4. 연결 종료-----------------------------------------------------------------------------------------
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

		System.out.println("이건로그인=> 김수아");
	}
	
		
}
