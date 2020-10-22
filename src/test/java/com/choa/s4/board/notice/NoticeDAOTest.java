package com.choa.s4.board.notice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.s4.MyTestCase;
import com.choa.s4.board.BoardDTO;
import com.choa.s4.util.Pager;

public class NoticeDAOTest extends MyTestCase {

	@Autowired
	private NoticeDAO noticeDAO;

	@Test void getCountTest() throws Exception {
		Pager pager = new Pager();
		noticeDAO.getCount(pager);
		
	}
	
	@Test
	public void setDeleteTest() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		noticeDAO.setDelete(boardDTO);
	}
	
	//@Test
	public void setUpdateTest() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(164);
		boardDTO.setTitle("164 title");
		boardDTO.setContents("164 contents");
		int result = noticeDAO.setUpdate(boardDTO);
		
		assertEquals(1, result);
	}	
	
	//@Test
	public void getOneTest() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(122);
		noticeDAO.getOne(boardDTO);
		
		assertNotNull(boardDTO);
	}
	
	//@Test
	public void getListTest() throws Exception {
		Pager pager = new Pager();
		pager.makeRow();
		
		List<BoardDTO> ar = noticeDAO.getList(pager);
		System.out.println(ar.size());
		assertNotEquals(0, ar.size());
	}
	
	//@Test
	public void setInsertTest() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setTitle("title test");
		boardDTO.setWriter("writer test");
		boardDTO.setContents("contents test");
		int result = noticeDAO.setInsert(boardDTO);
		
		assertEquals(1, result);
	}


}
