package com.choa.s4.member.memberUser;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.choa.s4.member.MemberDTO;
import com.choa.s4.member.MemberService;

@Service
public class MemberUserService implements MemberService {

	@Autowired
	private MemberUserDAO memberUserDAO;

	@Override
	public int setMemberJoin(MemberDTO memberDTO, MultipartFile photo, HttpSession session) throws Exception {
		//HDD 폴더에, 이름
		
		//File file = new File("C:\\Sungmin\\workspace2\\spring_4\\src\\main\\webapp\\resources\\upload\\member");
		String path = session.getServletContext().getRealPath();
		System.out.println(path);
		
		
		return 0;
		//return memberUserDAO.setMemberJoin(memberDTO);
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