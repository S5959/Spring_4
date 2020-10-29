package com.choa.s4.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {

	//save 메서드 생성
	
	//Multipartfile.transferTo
	public String saveTransfer(File dest, MultipartFile multipartFile) throws Exception {

		if(!dest.exists()) {
			dest.mkdirs();
		}
		
		String fileName = UUID.randomUUID().toString();
		fileName = fileName+"_"+multipartFile.getOriginalFilename();
		
		dest = new File(dest, fileName);

		multipartFile.transferTo(dest);
		
		return fileName;
	}
	
	//filecopyUtil.copy
	public String saveCopy(File dest, MultipartFile multipartFile) throws Exception {
		
		if(!dest.exists()) {
			dest.mkdirs();
		}
		
		String fileName = UUID.randomUUID().toString();
		fileName = fileName+"_"+multipartFile.getOriginalFilename();
		
		dest = new File(dest, fileName);

		FileCopyUtils.copy(multipartFile.getBytes(), dest);
		
		return fileName;
	}
	
	//내가 짠 코드
	public void save(MultipartFile multipartFile, HttpSession session, String folder) throws Exception {
		//HDD 폴더에, 이름
		
		//지정할 폴더 경로
		String path = session.getServletContext().getRealPath("/resources/upload/"+folder);
		
		File file = new File(path);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		System.out.println(path);
		
		
		//저장할 파일명 설정
		//1. 시간
		Calendar ca = Calendar.getInstance();
		long time = ca.getTimeInMillis();
		String fileName = multipartFile.getOriginalFilename();
		fileName = time+"_"+fileName;
		System.out.println(fileName);
		
		//2. Unique한 이름 생성하는 객체
		//fileName = UUID.randomUUID().toString();
		//System.out.println(fileName);
		
		file = new File(path, fileName);
		
		
		//HDD에 저장 
		//-- (원래 3가지 방법이나 나머지 1개는 활용도가 떨어져서 생략)
		//1.FileCopyUtils 라는 객체의 메서드 활용
		//byte[] ar = photo.getBytes();
		//FileCopyUtils.copy(ar, file);
		
		//2. MultipartFile 객체의 메서드 활용
		multipartFile.transferTo(file);
		
	}
	

}
