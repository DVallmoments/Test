package com.test.myapp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.test.myapp.dao.BoardDAO;
import com.test.myapp.vo.BoardDTO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Resource(name = "boardDAO")
	private BoardDAO boardDAO;

	@Override
	public List<BoardDTO> listAll() throws Exception {
		return boardDAO.listAll();
	}

	@Override
	public void writing(BoardDTO boardDTO) throws Exception {
		boardDAO.writing(boardDTO);
	}

	@Override
	public BoardDTO view(int bno) throws Exception {
		return boardDAO.view(bno);
	}

	@Override
	public void modify(BoardDTO boardDTO) throws Exception {
		boardDAO.modify(boardDTO);
	}

	@Override
	public void delete(int bno) throws Exception {
		boardDAO.delete(bno);
	}
}
