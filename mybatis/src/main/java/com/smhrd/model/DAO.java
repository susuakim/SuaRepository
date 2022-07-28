package com.smhrd.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.SqlSessionManager;

public class DAO {
	
	// SqlSessionFactory에 있는 SqlSessionFactory 불러오기 -> Connection pool 역할
	private SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	
	// 회원가입 메소드
	public int join(DTO dto) {
		// openSession() : sqlSessionFractory에서 sqlSession 하나 가지고 오는 것, 
		// connection 하나 가져오는 것
		// true : auto commit
		// 1.
		SqlSession session = sqlSessionFactory.openSession(true);
		
		// session.insert("id값", sql문에서 필요한 데이터)
		// id값 : Mapper에서 작성했던 id값 => 메소드의 이름을 그대로 적는 것이 규칙
		// 2.
		int row = session.insert("join", dto);
		
		// 3. 닫기
		session.close();
		
		return row;
	}
	
	// 로그인 메소드
	public String login(DTO dto) {
		// 1.
		SqlSession session = sqlSessionFactory.openSession(true);
		
		// 2. 메소드 이름과 같은 이름으로 적는다(login == login)
		String name = session.selectOne("login", dto);
		
		// 3.
		session.close();
		
		return name;
	}
	
	public int update(DTO dto) {
		// 1.
		SqlSession session = sqlSessionFactory.openSession(true);
		
		// 2.
		int row = session.update("update", dto);
		
		// 3.
		session.close();
		
		return row;
	}
}
