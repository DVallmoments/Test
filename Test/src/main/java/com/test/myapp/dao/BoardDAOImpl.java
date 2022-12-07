package com.test.myapp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.myapp.vo.BoardDTO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;
	private String NameSpace = "BoardMapper";

	@Override
	public List<BoardDTO> listAll() throws Exception {
		return sqlSession.selectList(NameSpace + ".listAll");
	}

	@Override
	public void writing(BoardDTO boardDTO) throws Exception {
		sqlSession.insert(NameSpace + ".writing", boardDTO);
	}

	@Override
	public BoardDTO view(int bno) throws Exception {
		return sqlSession.selectOne(NameSpace + ".view", bno); 
	}

	@Override
	public void modify(BoardDTO boardDTO) throws Exception {
		sqlSession.update(NameSpace + ".modify", boardDTO);
	}

	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete(NameSpace + ".delete", bno);
	}
}
