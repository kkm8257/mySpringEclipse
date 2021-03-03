package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;



// servlet-context.xml에 component-scan으로 설정된 패키지 아래의클래스만 찾아서 생성해준다.


@Controller
//sample이라고앞에 경로 명시해준경우에만 들어온다.
@RequestMapping("/sample")
@Log4j  //pom.xml에서 log4j   scope runtime 지워야 에러안뜸 
public class SampleController {
	
	//url 맵핑이랑 연결될 수 있는 기능을 가진 것이 @Controller
	//log info 가 콘솔에 뜰때  Mapped를 보면 맵핑이 되었따는 로그가 보인다 
	
	
	//RequestMapping 에 ""만 치면  위에 적은(포함하는 클래스에서 적은)  /sample 을 치면 들어오는 메소드로 명시가능 
	//sample만 치면  basic()메소드가 실행
	@RequestMapping("")
	public void basic() {
		log.info("basic....");
	}
	
	
	//RequestMapping을 쓸때 get 방식으로 받으려면 value를 써야한다. RequestMapping의 파라미터이름이 value라고 생각하면 된다.
	//그리고 method설정 필요
	//RequestMapping에 아무런 조건을 안주면(위처럼) , 모든 방식을 허용한다는 이야기 
	
	
	//@RequestMapping(value = "basicOnlyGet" , method=RequestMethod.GET)
	//RequestMapping을 쓰면 너무 길어지니까 GetMapping으로 간단하게도 명시가능하다 . 
	
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("basicOnlyGet.....");
		
	}
	
	

}
