package com.choa.s4.board.qna;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.s4.MyTestCase;
import com.choa.s4.board.BoardDTO;

public class QnaDAOTest extends MyTestCase {

	@Autowired
	private QnaDAO qnaDAO;
	
	//@Test
	public void setInsertTest() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setTitle("qna title test");
		boardDTO.setWriter("qna writer test");
		boardDTO.setContents("qna contents test");
		int result = qnaDAO.setInsert(boardDTO);
		
		assertEquals(1, result);
	}

}
