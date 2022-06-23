package model;

public class MemberDAO {
	
	int cnt; // 변한 행의 개수를 저장하는 변수
	
	public int update() {
		
		cnt = 0;
		
		//1. 동적
		//1-1. ojdbc6.jar 파일 추가
		//oracleDriver클래스 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2. DB 연결
		//3. SQL 실행
		//4. 닫기
		
		
		return cnt;
	}

}
