package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
	//인터페이스를 만들고 실행할 쿼리나 어노테이션을 xml에담아둘 인터페이스  
	//쿼리문장을 어노테이션으로 쓸 수 있다.
	
	@Select("SELECT sysdate FROM dual")
	public String getTime();   //추상메소드 , 시간을 알려줄 메소드  
	

}
