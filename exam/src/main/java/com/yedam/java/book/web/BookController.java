package com.yedam.java.book.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("bookInsert")
	public String boardInsert(BookVO bookVO, Model model) {
		List<BookVO> list = bookService.selectBookList();
		
		int max = 0;
		for(BookVO vo : list) {
			if(vo.getBookNo() > max) {
				max = vo.getBookNo();
			}	
		}
		model.addAttribute("insert", max+1);
		return "book/bookInsert";
	}
	@PostMapping("bookInsert")
	public String bookInsert(BookVO bookVO) {
		bookService.insertBook(bookVO);
		return "book/bookInsert";
	}
	
	@GetMapping("bookList")
	public String bookList(Model model) {
		model.addAttribute("bookList",bookService.selectBookList());
		return "book/bookList";
	}
	
	
}
