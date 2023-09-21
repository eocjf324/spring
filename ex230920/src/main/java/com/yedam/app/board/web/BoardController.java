package com.yedam.app.board.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.board.BoardVO;
import com.yedam.app.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;

	// 전체조회 : : URI - boardList / RETURN - board/boardList
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
		//등록 페이지를 호출할 때 미리 primary key를 보여야하는 경우 Model이 필요함 => selectkey 사용 안함 
		return "board/boardInfo";
	}
	// 등록 - 처리 : URI -boardInsert/ parameter - BoardVO / RETURN -전제조회 다시 호출 
	@PostMapping("boardInsert")
	public String boardInsert(BoardVO boardVO) {
		
		boardService.insertBoardInfo(boardVO);
		return "redirect:boardList";
	}
	// 수정 - 페이지 : URI - boardUpdate/ Parameter - boardVO/ return - board/boardUpdate
	@GetMapping("boardUpdate")
	public String boardUpdate(BoardVO boardVO, Model model) {
		model.addAttribute("boardInfo", boardService.getBoardInfo(boardVO));
		return "board/boardUpdate";
	}
	
	// 수정 - 처리 : URI - boardUpdate / Parameter -boardVO
	@PostMapping("boardUpdate")
	@ResponseBody
	public Map<String, Object> boardUpdate(@RequestBody BoardVO boardVO) {
		Map<String, Object> map = new HashMap<String,Object>();
		int result = boardService.updateBoardInfo(boardVO);
		if(result >-1 ) {
			map.put("result", true);
			map.put("bno", result);
		}else {
			map.put("result", false);
		}
		return map;
	}

	// 삭제 - 처리 : URI - boardDelete / Parameter - bno / RETURN - 전체조회 다시 호출
	@GetMapping("boardDelete")
	public String boardDelete(@RequestParam Integer bno) {
		boardService.deleteBoardInfo(bno);
		return "redirect:boardList";
	}

}
