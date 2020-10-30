package com.choa.s4.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.choa.s4.board.BoardDTO;
import com.choa.s4.util.Pager;

@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;

	@PostMapping("noticeUpdate")
	public ModelAndView setUpdate(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result = noticeService.setUpdate(boardDTO);
		String msg = "Update Fail";
		if(result > 0) {
			msg = "Update Success";
		}
		
		mv.addObject("msg", msg);
		mv.addObject("path", "./noticeList");
		mv.setViewName("common/result");
		
		return mv;
	}
	
	@GetMapping("noticeUpdate")
	public ModelAndView setUpdate(BoardDTO boardDTO, Model model) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		boardDTO = noticeService.getOne(boardDTO);
		if(boardDTO != null) {
			mv.addObject("board", "notice");
			mv.addObject("dto", boardDTO);
			mv.setViewName("board/boardUpdate");
		} else {
			mv.addObject("msg", "No Data");
			mv.addObject("path", "./noticeList");
			mv.setViewName("common/result");
		}		
		
		return mv;
	}
	
	@GetMapping("noticeDelete")
	public ModelAndView setDelete(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result = noticeService.setDelete(boardDTO);
		
		String msg = "Delete Fail";
		if(result > 0) {
			msg = "Delete Success";
		}
		
		mv.addObject("msg", msg);
		mv.addObject("path", "./noticeList");
		mv.setViewName("common/result");
		
		return mv;
	}
	
	@GetMapping("noticeSelect")
	public ModelAndView getOne(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getOne(boardDTO);
		
		if(boardDTO != null) {
			mv.addObject("board", "notice");
			mv.addObject("dto", boardDTO);
			mv.setViewName("board/boardSelect");
		} else {
			mv.addObject("msg", "No Data");
			mv.addObject("path", "./qnaList");
			mv.setViewName("common/result");
		}	
		
		return mv;
	}
	
	
	
	@GetMapping("noticeWrite")
	public ModelAndView setInsert() throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("board", "notice");
		mv.setViewName("board/boardWrite");
				
		return mv;
	}
	
	@PostMapping("noticeWrite")
	public ModelAndView setInsert(BoardDTO boardDTO, MultipartFile[] files, HttpSession session) throws Exception {
		//NoticeDTO noticeDTO 로 파라미터 받아와도 상관없음
		ModelAndView mv = new ModelAndView();
		
		for(int i=0; i<files.length; i++) {
			System.out.println(files[i].getOriginalFilename());			
		}
		
		int result = noticeService.setInsert(boardDTO, files, session);
		String msg = "Write Fail";
		if(result > 0) {
			msg = "Write Success";
		}
		
		mv.addObject("msg", msg);
		mv.addObject("path", "./noticeList");
		mv.setViewName("common/result");
				
		return mv;
	}
	
	
	
	//@RequestMapping(value="noticeList")
	@GetMapping("noticeList")
	public ModelAndView getList(Pager pager) throws Exception {
		System.out.println("Controller Notice List");
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = noticeService.getList(pager);
		
		mv.addObject("board", "notice");
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/boardList");		
		
		return mv;
	}
}
