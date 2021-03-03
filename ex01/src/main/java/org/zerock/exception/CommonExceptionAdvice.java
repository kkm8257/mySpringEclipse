package org.zerock.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.log4j.Log4j;




//요청한 url을 처리하면서 나오는 예외를 처리해주는 클래스  , 이거해라 저거해라 하는게 컨트롤러인데  이 떄 에러발생시 해결하기 위한 클래스 라고 보면된다 . 임의로 만든것 
//Controller 관련된 (url 관련) 것이면  servlet-context 와 연관 


// 자동 생성이 되는 것들  @Controller , @Service, @Advice, @Repository ,@Component, @RestController 등이 있는데, 이것들은  아무거나 해주는게아니라
//servlet-context.xml 에 component-scan으로 설정된 패키지 아래의 클래스만 생성해준다 . 

@ControllerAdvice
@Log4j    // log 객체를 만들어준다 
public class CommonExceptionAdvice {

	//예외를 처리하는 메서드   -> 예외의 종류가 Exception인 것을 처리한다 . 
	@ExceptionHandler(Exception .class)
	public String exception(Exception ex, Model model) {

		log.error("Exception......"+ex.getMessage());
		model.addAttribute("exception",ex);  //파라미터로 받은 예외 ex를  넘긴다는 것   ,jsp에서는 ${exception}으로 쓰면 된다 .
		return "error_page";
	}
	
	
	
	
	
}
