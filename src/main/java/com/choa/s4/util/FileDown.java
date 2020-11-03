package com.choa.s4.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.choa.s4.board.file.BoardFileDTO;

@Component
public class FileDown extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// DB에 있는 파일을 0과 1로 만들어 보내주는 역할
		String board = (String)model.get("board");
		//String fileName = (String)model.get("fileName");
		BoardFileDTO boardFileDTO = (BoardFileDTO)model.get("fileDTO");
		
		System.out.println(board);
		
		
		//session 대신에 request 사용
		String path = request.getSession().getServletContext().getRealPath("/resources/upload/"+board);
		
		File file = new File(path, boardFileDTO.getFileName());
		
		
		//내보낼 때
		//파일 한글 처리
		response.setCharacterEncoding("UTF-8");
		
		//파일의 크기
		response.setContentLength((int)file.length());
		
		//다운로드시 파일 이름 인코딩
		String downName = URLEncoder.encode(boardFileDTO.getOriName(), "UTF-8");
		
		//header 설정
		response.setHeader("Content-Disposition", "attachment;fileName=\""+downName+"\"");	
		response.setHeader("content-Transfer-Encoding", "binary");
		
		//Client 전송
		FileInputStream fi = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		
		FileCopyUtils.copy(fi, os);
		
		os.close();
		fi.close();
		
	}
	
}
