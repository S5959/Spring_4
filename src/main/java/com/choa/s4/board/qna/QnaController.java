package com.choa.s4.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.choa.s4.board.BoardDTO;
import com.choa.s4.util.Pager;

@Controller
@RequestMapping(value="/qna/**")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@GetMapping("qnaSelect")
	public ModelAndView getOne(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardDTO = qnaService.getOne(boardDTO);
		
		mv.addObject("board", "notice");		
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/boardSelect");
		
		return mv;
	}
	
	@PostMapping("qnaWrite")
	public ModelAndView setInsert(BoardDTO boardDTO) throws Exception {
		//NoticeDTO noticeDTO 로 파라미터 받아와도 상관없음
		ModelAndView mv = new ModelAndView();
		
		int result = qnaService.setInsert(boardDTO);
		String msg = "Write Fail";
		if(result > 0) {
			msg = "Write Success";
		}
		
		mv.addObject("msg", msg);
		mv.addObject("path", "./qnaList");
		mv.setViewName("common/result");
				
		return mv;
	}
	
	@GetMapping("qnaWrite")
	public ModelAndView setInsert() throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("board", "qna");
		
		mv.setViewName("board/boardWrite");
		
		return mv;
	}
	
	//@RequestMapping(value="qnaList")
	@GetMapping("qnaList")
	public ModelAndView getList(Pager pager) throws Exception {
		System.out.println("Controller QnA List");
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar =  qnaService.getList(pager);
		
		BoardDTO boardDTO = ar.get(0);
		QnaDTO qnaDTO = (QnaDTO)boardDTO;
		System.out.println(qnaDTO.getDepth());
		
		mv.addObject("board", "qna");
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/boardList");
		
		return mv;
	}
}
