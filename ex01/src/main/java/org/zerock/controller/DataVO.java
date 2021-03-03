package org.zerock.controller;

import lombok.Data;


//@Data 덕분에 예전 jsp 할떄처럼  getter setter를 안만들어도 된다.
@Data
public class DataVO {

	
	// 스프링 프레임워크를 쓸때는 private를 필수적으로 붙여주자 , 보안적 문제 
	
	private String name;
	private int age;
	
	
}
