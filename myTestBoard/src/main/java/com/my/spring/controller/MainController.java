package com.my.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//ctrl+ shitf + O
//java 파일아이콘에 S 가 있으면 스프링의 제어를 받는  안뜨는경우 버그 , 아니면 진짜 아닐수도 ㅇ

@Controller
@RequestMapping("/")
public class MainController {

	@RequestMapping("")
	public String main() {
		return "home";  //home 을 리턴하면 sesrvlet-context.xml에 작성한대로   views에 있는 home.jsp로 연결 
	}
	
}
