package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


//테스트 실행시 사용하는 프로그램은 spring-test를 만들어놧는데(우리가) 그 안에 있는 클래스를 사용한다.
@RunWith(SpringJUnit4ClassRunner.class)
//테스트에서는 root-context.xml과는 상관이 없으므로 root-context.xml 파일정보를 넣어주는것이 ContextConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//log라는 변수를 사용 할 수 있게 하는것 . lombok 설정이 제대로 되어있어야한다.
@Log4j
public class SampleTest {

	
	//자동 DI선언 
	@Setter(onMethod_ = @Autowired)
	private Restaurant restaurant;
	
	//자동 di 테스트  테스트를하려면test어노테이션 필요  아래와 같은 테스트 방법을  JUNIT을 이용한 테스팅이라고한 TEST를 붙여준 것은 모두 테스트를 한다.
	//test/resource에 log4j.xml에 보면 작성 추가해주어야함 새로운 패키지 해놨으니
	
	@Test
	public void testExist() {
		log.info("=====자동 di 테스트  ");
	
		//null인지 체크  
		assertNotNull(restaurant);
		
		log.info(restaurant);
		log.info("---------------");
		log.info(restaurant.getChef());
		
		
	
	}
	
	
	
}
