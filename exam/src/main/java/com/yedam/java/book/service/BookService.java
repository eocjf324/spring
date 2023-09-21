package com.yedam.java.book.service;

import java.util.List;

public interface BookService {
	public List<BookVO> selectBookList();
	public int insertBook(BookVO bookVO);
}
