package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

//자동생성이 되는 어노테이션 선언 -> @Controller(url이 들어오면 어떤 메소드를 실행해라) ,  @service(전체적인 처리부분을 담은 클래스에 사용), @Repository (데이터에 해당)
//@Component(구성요소) , @RestController(Ajax를쓰기위함)

//단 조건이 있다.src폴더 밑 main webapp spring 안에  root-context.xml  이나 servlet-context.xml 에서  component-scan이 정의한 패키지안에 있어야 한다.

@Component
@Data
public class Restaurant {
	
	//lombok이 자동으로 만들어놓은  setter를 이용해서 DI적용 
	
	
	@Setter(onMethod_ = @Autowired)
	private Chef chef;
	
	//정상적으로 주입이 되었는지 체크하려면 , chef가null인지 아닌지를 확인해야함 
	
	
	
	
	
}
