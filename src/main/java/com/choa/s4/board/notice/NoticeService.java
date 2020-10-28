package com.choa.s4.board.notice;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.choa.s4.board.BoardDTO;
import com.choa.s4.board.BoardService;
import com.choa.s4.util.FileSaver;
import com.choa.s4.util.Pager;

@Service
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private FileSaver fileSaver;
	
	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile files, HttpSession session) throws Exception {
		//지정할 폴더 경로 설정
		String path = session.getServletContext().getRealPath("/resources/upload/notice");
		System.out.println(path);
		File file = new File(path);
		
		//fileSaver.save(files, session, "notice");
		String fileName = fileSaver.saveCopy(file, files);
		return 0;//noticeDAO.setInsert(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setDelete(boardDTO);
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		pager.makeRow();
		pager.setTotalCount(noticeDAO.getCount(pager));
		pager.makePage();
		return noticeDAO.getList(pager);
	}

	@Override
	public BoardDTO getOne(BoardDTO boardDTO) throws Exception {
		return noticeDAO.getOne(boardDTO);
	}

}
