package com.choa.s4.member.memberUser;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.choa.s4.member.MemberDTO;
import com.choa.s4.member.MemberService;
import com.choa.s4.member.memberFile.MemberFileDAO;
import com.choa.s4.member.memberFile.MemberFileDTO;
import com.choa.s4.util.FileSaver;

@Service
public class MemberUserService implements MemberService {

	@Autowired
	private MemberUserDAO memberUserDAO;
	@Autowired
	private MemberFileDAO memberFileDAO;
	@Autowired
	private FileSaver fileSaver;
	
	@Override
	public int setMemberJoin(MemberDTO memberDTO, MultipartFile photo, HttpSession session) throws Exception {
		
		String path = session.getServletContext().getRealPath("/resources/upload/member");
		System.out.println("path");
		File file = new File(path);
		
		String fileName = fileSaver.saveCopy(file, photo);
		
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setId(memberDTO.getId());
		memberFileDTO.setFileName(fileName);
		memberFileDTO.setOriName(photo.getOriginalFilename());
		memberFileDAO.setInsert(memberFileDTO);
		

		return 0;
		//return memberUserDAO.setMemberJoin(memberDTO);
		
		/*
		 * FileSaver 를 따로 만들어 메서드로 호출하여 사용하도록 변경
		 * 
		//HDD 폴더에, 이름		
		//저장할 폴더 경로 (프로젝트가 있는 위치를 알 수 있음)
		String path = session.getServletContext().getRealPath("/resources/upload/member");
		
		File file2 = new File(path);
		if(!file2.exists()) {
			file2.mkdirs();
		}
		
		System.out.println(path);
		
		//------------------------------------------------------
		//저장할 파일 이름 설정
		//1.시간
		Calendar ca = Calendar.getInstance();
		long time = ca.getTimeInMillis();
		String name = photo.getOriginalFilename();
		name = time + "_" + name;
		System.out.println(name);
		
		//2. Unique한 이름 생성하는 객체
		name = UUID.randomUUID().toString();
		System.out.println(name);
		
		File file = new File(path, name);
		
		
		//------------------------------------------------------
		//HDD 저장 
		//-- (원래 3가지 방법이나 나머지 1개는 활용도가 떨어져서 생략)
		//1. FileCopyUtils 라는 객체의 메서드 활용(스프링에서 제공해주는 클래스)	라이브러리?
		byte[] ar  = photo.getBytes();
		FileCopyUtils.copy(ar, file);
		
		//2. MultipartFile 객체의 메서드 활용
		photo.transferTo(file);
		*/
		
	}
	
	@Override
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception {
		return memberUserDAO.getMemberLogin(memberDTO);
	}
	
	@Override
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception {
		return memberUserDAO.setMemberUpdate(memberDTO);
	}
	
	@Override
	public int setMemberDelete(MemberDTO memberDTO) throws Exception {
		return memberUserDAO.setMemberDelete(memberDTO);
	}
	
	@Override
	public long getMemberIdCheck(MemberDTO memberDTO) throws Exception {
		return memberUserDAO.getMemberIdCheck(memberDTO);
	}
	
}