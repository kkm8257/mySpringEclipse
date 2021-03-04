package com.webjjang.board.mapper;

import java.util.List;

import com.webjjang.board.vo.BoardVO;

import net.webjjang.util.PageObject;

//mapper 식으로 쓰려면

//root-context에 	<mybatis-spring:scan base-package="com.webjjang" /> 를 적어서 dao를 자동으로 만들어주기 위한 위치를 설정



public interface BoardMapper {
	
	//게시판 리스트
	public List<BoardVO> list(PageObject pageObject);  //메소드의 이름이  boardMapper.xml 에 있는 sql 문 id와 똑같이해줘서 쓰면 된다.
	
	//전체 데이터 가져오기
	public Integer getCount();
	
	public List<String> myList();
	
	public List<BoardVO> myList_get();

}
