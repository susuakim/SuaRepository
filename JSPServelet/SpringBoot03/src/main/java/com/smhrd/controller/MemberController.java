package com.smhrd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smhrd.domain.Member;
import com.smhrd.mapper.MemberMapper;

@Controller
public class MemberController {
	
	@Autowired
	private MemberMapper mapper;

	@RequestMapping("/")
	public String memberList(Model model) {
		
		List<Member> List = mapper.memberList();
		
		System.out.println(List);
		model.addAttribute("list", List);
		
		return "MemberList";  // WEB-INF/view/MemberList.jsp가 된다
	}
}
