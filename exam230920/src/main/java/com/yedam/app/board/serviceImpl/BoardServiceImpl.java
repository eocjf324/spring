package com.yedam.app.board.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.board.BoardVO;
import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;
	@Override
	public List<BoardVO> getBoardList() {
		List<BoardVO> list = boardMapper.selectBoardList();
		return list;
	}

	@Override
	public BoardVO getBoardInfo(BoardVO boardVO) {
		return boardMapper.selectBoardInfo(boardVO);
	}

	@Override
	public int insertBoardInfo(BoardVO boardVO) {
		return boardMapper.insertBoard(boardVO);
	}

	@Override
	public int updateBoardInfo(BoardVO boardVO) {
		return boardMapper.updateBoard(boardVO);
	}

	@Override
	public int deleteBoardInfo(int boardNo) {
		return boardMapper.deleteBoard(boardNo);
	}

}
