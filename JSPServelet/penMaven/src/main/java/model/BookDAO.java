package model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import db.SqlSessionManager;

public class BookDAO {

	private SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();

	// 회원가입
		public int insert_member(BookDTO dto) {
			SqlSession session = sqlSessionFactory.openSession(true);
			int row = session.insert("insert_member", dto);
			session.close();

			return row;
		}

	// 로그인
		public BookDTO login_member(BookDTO dto) {
			SqlSession session = sqlSessionFactory.openSession(true);
			BookDTO info = session.selectOne("login_member", dto);
			session.close();

			return info;
		}
}
