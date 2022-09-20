package com.smhrd.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionManager {
	
	// static 블록 : 객체를 호출할 때 무조건 한번 실행되는 부분
	static SqlSessionFactory sqlSessionFactory;
	static {
		// resource : 환경설정 파일의 경로
		try {
			String resource = "com/smhrd/db/config.xml";
			InputStream inputStream;
			inputStream = Resources.getResourceAsStream(resource);

			// SqlSessionFactory = Connection과 같은 역할
			// DB연결을 **미리** 하는 것(connection Pool = CP)
			// conn, close가 자원소모가 심하기 때문에 mybatis에서 해결하려고
			// => Connection 객체를 미리 만들어서 빌려주고 반납하는 형식
			sqlSessionFactory =
					new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// DAO에서 SqlSessionFactory를 사용하기 위해서 반환해주는 메소드를 생성
	public static SqlSessionFactory getSqlSession() {
		return sqlSessionFactory;
	}
}
