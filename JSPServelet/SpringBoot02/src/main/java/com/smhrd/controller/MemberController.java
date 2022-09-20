package com.smhrd.controller;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smhrd.domain.Member;
import com.smhrd.mapper.MemberMapper;

@Controller
public class MemberController {

	@Autowired
	private MemberMapper mapper;

	@RequestMapping("/goJoin.do")
	public String goJoin() {

		return "view/join";
	}

	@RequestMapping("/join.do")
	public String join(Member member) {
		// 1. 파라미터 수집

		// 2. SQL 쿼리 정의, mapper interface에 메소드 만들기

		// 3. 메소드 사용
		int cnt = mapper.join(member);
		// 4. 다음 view 리턴
		if (cnt == 1) {
			// 회원가입 성공
			return "index";
		} else {
			// 회원가입 실패
			return "view/join";

		}

	}

	@RequestMapping("/login.do")
	public String login(Member member, HttpSession session) {
		
		// 1. 파라니터 수집
		Member list = mapper.login(member);
	
		// 2. SQL문, 추상 메서드 정의
		System.out.println(list);
		// 3. mapper의 메서드 사용
		
		// 4. 성공 실패 구분
			// 성공 : session에 유저 정보 저장, main
			// 실패 : index
		if (list != null) {
			session.setAttribute("info", list);
			return "view/main";

		} else {
			return "index";
		}
	}

}
