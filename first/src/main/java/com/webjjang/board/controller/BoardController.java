package com.webjjang.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webjjang.board.service.BoardService;

import net.webjjang.util.PageObject;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	
	//자동으로 di 적용 시키는 2가지 inject 와 Autowired
	@Autowired
	private BoardService service;

	@GetMapping("/list.do")
	public String list(PageObject pageObject,Model model) {
		
		//model안에는 request가 있따.
		//model에 데이터를 저장하면 request에 저장이 된다.
		
		System.out.println("board Controller.list().pageObject->"+pageObject);
		model.addAttribute("list",service.list(pageObject));
		
		return "board/list";
	}
	
	
}
