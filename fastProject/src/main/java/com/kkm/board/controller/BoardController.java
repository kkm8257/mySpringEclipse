package com.kkm.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kkm.board.vo.BoardVO;

import net.webjjang.util.PageObject;

//유의 사항 - > 404 뜨는데 맵핑도 잘썻다면 , servlet-context.xml 에서  component-scan 경로가 올바른지볼것 지금같은경우 원래 뒤에 .main이 있어서
// 이패키지를 스캔못햇음  . 그래서 뒤에 .main을 지워줌 


@Controller
@RequestMapping("/board")
public class BoardController {
	
	private final String MODUEL_NAME ="board";
	
	@Autowired
	private BoardService service ; 
	

	
	@GetMapping("/list.do")
	public String list(Model model, PageObject pageObject) {
		
		model.addAttribute("list",service.list(pageObject));  //여기 두줄이 매우매우 중요 
		model.addAttribute("pageObject",pageObject);
		
		return MODUEL_NAME+"/list";
	}
	
	
	@GetMapping("/write.do")
	public String writeForm() {
		
		return MODUEL_NAME+"/write";
	}
	
	@PostMapping("/write.do")
	public String wirte(BoardVO vo) {
		
		service.write(vo);
		
		return "redirect:list.do";   //jsp가아니라 처리를 해주는 거니까 처리 완료후 redirect로 list 로 가라는 처리 
	}
	
	
}
