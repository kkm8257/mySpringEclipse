package org.zerock.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/*
 * @RequestingMapping에서 value에 "/" 면 / 를 만나면 실행이 된다는 것  
 * 
 * model이라는 곳에 데이터를 담았는데 , 이 값이 views에 jsp쪽으로 간다. 이때 return을 home만 햇음. 
 * 왜 home만했는데 jsp로 알아서가는가? 
 * Spring 폴더 밑에 servlet-context.xml에 보면 ,  prefix와 suffix가 존재함 이걸로 참고한다  
 * 
 * 
 * 처음에 web.xml에서 디스패처서블릿이 받도록 되어잇고, @어노테이션에 대한 매핑을 조회하기위해 HandlerMapping에 요청을하고 (여기에 매핑정보가담겨있다)
 * 매핑정보를 받아와서 그 정보를가지고 HandlerAdapter로 가서 찾아서 실행을한다  이 떄 실행하는 것이 우리가 짠 코드  Controller이다
 * 이제 컨트롤러에서 처리를 다하고 다시 HandlerAdapter를 지나 디스패처 서블릿으로 결과값을 전달해주고 
 * 디스패처 서블릿을 뷰 리졸버로 정보를 넘기는데 ,  뷰 리졸버는 어떤 뷰로 가라는 결과값을 다시 건내준다
 * 그 값을 가지고 디스패처 서블릿은 View로가서 결과값에 맞는 view를 보여준다 (jsp파일) 
 * 
 * 
 * */







@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
