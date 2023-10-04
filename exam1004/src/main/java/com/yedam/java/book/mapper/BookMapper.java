package com.yedam.java.book.mapper;

import java.util.List;

import com.yedam.java.book.service.BookVO;

public interface BookMapper {
	//전체 조회
	public List<BookVO> selectBookAll();
	//단건 조회 -> 북넘버 자동부여 : 예측
	public Integer selectBookNextNo();
	//등록 
	public int insertBookInfo(BookVO bookVO);
	
}
