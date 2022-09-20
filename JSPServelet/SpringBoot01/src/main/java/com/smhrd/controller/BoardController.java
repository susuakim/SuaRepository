package com.smhrd.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smhrd.domain.Board;

@Controller
public class BoardController {

	@RequestMapping("/boardList.do")
	public String boardList(Model model) {
		
		List<Board> list = new ArrayList<Board>();
		list.add(new Board(1, "스프링게시판", "김수아", "Spring Boot", "22/09/05", 0));
		list.add(new Board(2, "스프링게시판", "김수지", "Spring Boot", "22/09/05", 0));
		
		model.addAttribute("list", list);
		
		return "view/boardList"; //templates/view/boardList.html
	}
	
	@RequestMapping("/boardContent.do")
	public String boardContent(Model model) {
		
		Board board = new Board(1, "스프링게시판", "김수아", "Spring Boot01", "22/09/06", 0);
		
		model.addAttribute("board", board);
		
		return "view/boardContent";
	}
}
