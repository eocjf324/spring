package com.yedam.java.book.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.java.book.mapper.BookMapper;
import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookMapper bookMapper;
	
	@Override
	public List<BookVO> selectBookList() {
		List<BookVO> list =bookMapper.selectBookList();
		return list;
	}

	@Override
	public int insertBook(BookVO bookVO) {
//		int result = bookMapper.insertBook(bookVO);
//		if(result ==1) {
//			return  1;
//		}else {
//			return -1;
//		}
		return bookMapper.insertBook(bookVO);
	}
}
