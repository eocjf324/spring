package com.yedam.java.book.mapper;

import java.util.List;

import com.yedam.java.book.service.BookVO;

public interface BookMapper {
	public List<BookVO> selectBookList();
	public int insertBook(BookVO bookVO);
	
}
