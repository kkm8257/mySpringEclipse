package com.kkm.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kkm.board.mapper.BoardMapper;
import com.kkm.board.vo.BoardVO;

import net.webjjang.util.PageObject;

@Service
public class BoardService {

	@Inject
	private BoardMapper mapper;
	
	public List<BoardVO> list(PageObject pageObject){
		
		System.out.println("object -> "+pageObject);
		pageObject.setTotalRow(mapper.getCount());
		return mapper.list(pageObject);
	}

	public Integer write(BoardVO vo) {   //mapper에 Integer라고 써서 이렇게 맞춰주는게 좋다
		
		return mapper.write(vo);
	}
	
	
}
