package com.choa.s4.member.memberUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choa.s4.member.MemberDTO;
import com.choa.s4.member.MemberService;

@Service
public class MemberUserService implements MemberService {

	@Autowired
	private MemberUserDAO memberUserDAO;

	@Override
	public int setMemberJoin(MemberDTO memberDTO) throws Exception {
		return memberUserDAO.setMemberJoin(memberDTO);
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
	
}