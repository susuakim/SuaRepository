package com.smhrd.model;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.SqlSessionManager;

public class MemberDAO {

	private SqlSessionFactory sqlsessionFactory = SqlSessionManager.getSqlSession();
	
	// 회원정보조회
	public ArrayList<MemberDTO> showMember() {
		SqlSession session = sqlsessionFactory.openSession(true);
		ArrayList<MemberDTO> mem_list = (ArrayList)session.selectList("showMember");
		session.close();
		
		return mem_list;
	}
	
}



