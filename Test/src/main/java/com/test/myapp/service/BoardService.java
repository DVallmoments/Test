package com.test.myapp.service;

import java.util.List;

import com.test.myapp.vo.BoardDTO;

public interface BoardService {

	List<BoardDTO> listAll() throws Exception;

	void writing(BoardDTO boardDTO) throws Exception;

	BoardDTO view(int bno) throws Exception;

	void modify(BoardDTO boardDTO) throws Exception;

	void delete(int bno) throws Exception;
	
}
