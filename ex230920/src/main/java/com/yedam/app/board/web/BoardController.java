package com.yedam.app.board.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.app.board.BoardVO;
import com.yedam.app.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;

	// 전체조회 :
	@GetMapping("boardList")
	public String boardList(Model model) {
		model.addAttribute("boardList", boardService.getBoardList());
		return "board/boardList";
	}

	// 단건조회 :
	@GetMapping("boardInfo")
	public String boardInfo(BoardVO boardVO, Model model) {
		model.addAttribute("boardInfo", boardService.getBoardInfo(boardVO));
		return "board/boardInfo";
	}
	// 등록 - 페이지 : URI -boardInsert / return board/boardInsert
	@GetMapping("boardInsert")
	public String boardInsert() {
		return "board/boardInfo";
	}
	// 등록 - 처리 : URI -boardInsert/ parameter - BoardVO / RETURN -전제조회 다시 호출 
	@GetMapping("boardInsert")
	public String boardInsert(BoardVO boardVO,  RedirectAttributes attr) {
		
		int result = boardService.insertBoardInfo(boardVO);
		
		String message = null;
		if(result == 1) {
			message = "등록성공";
		}else {
			message = "등록실패";
		}
		attr.addFlashAttribute("result", message);
	return "redirect:bno?type=Insert";
	}
	// 수정 - 페이지 : URI - boardUpdate/ return - board/boardUpdate
	@GetMapping("boardUpdate")
	public String boardUpdate() {
		return "board/boardUpdate";
	}
	
	// 수정 - 처리 : URI - boardUpdate / Parameter -boardVO
	@GetMapping("boardUpdate")
	@ResponseBody
	public String boardUpdate(@RequestBody BoardVO boardVO) {
		return ;
	}

	// 삭제 - 처리
	@GetMapping("boardDelete")
	public String boardDelete(int bno, RedirectAttributes attr) {
		int result= boardService.deleteBoardInfo(bno);
		String message = null;
		if(result == 1) {
			message = "삭제성공";
		}else {
			message = "삭제실패";
		}
		
		attr.addFlashAttribute("result", message);
		return "redirect:bno?type=Delete";
	}

}
