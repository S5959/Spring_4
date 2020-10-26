package com.choa.s4.board.memo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.choa.s4.util.Pager;

@Controller
@RequestMapping(value="/memo/**")
public class MemoController {
	
	@Autowired
	private MemoService memoService;
	
	@GetMapping("memoList")
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<MemoDTO> ar = memoService.getList(pager);
		
		mv.addObject("list", ar);
		mv.setViewName("memo/memoTest");
		return mv;
	}
	
	@PostMapping("memoWrite")
	public ModelAndView setInsert(MemoDTO memoDTO) throws Exception {
		System.out.println("Memo Write");
		System.out.println("writer : " + memoDTO.getWriter());
		System.out.println("contents : " + memoDTO.getContents());
		
		ModelAndView mv = new ModelAndView();
		
		int result = memoService.setInsert(memoDTO);
		
		String msg = "Insert Fail";
		if(result > 0) {
			msg = "Insert Success";
		}
		
		mv.addObject("msg", msg);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}
	
	@GetMapping("memoWrite")
	public void setInsert() throws Exception {
		System.out.println("Memo Write");
		//int result = memoService.setInsert(memoDTO);		
	}
	
	@PostMapping("memoDelete")
	public ModelAndView setDelete(MemoDTO memoDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result = memoService.setDelete(memoDTO);

		mv.addObject("msg", result);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}
	
	@GetMapping("memoTest")
	public ModelAndView memoTest(MemoDTO memoDTO) throws Exception {		
		ModelAndView mv = new ModelAndView();
		memoDTO.setNum(memoDTO.getNum());
		memoDTO = memoService.getOne(memoDTO);
		
		mv.addObject("dto", memoDTO);
		mv.setViewName("memo/memoTest");
		return mv;
	}
	
	@GetMapping("memoPage")
	public void memoPage() throws Exception {}

}