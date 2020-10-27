package com.choa.s4.member;

public interface MemberDAO {
	
	//join
	public int setMemberJoin(MemberDTO memberDTO) throws Exception;
		
	//login
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception;
	
	//update
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception;
	
	//delete
	public int setMemberDelete(MemberDTO memberDTO) throws Exception;
	
	//idCheck
	public long getMemberIdCheck(MemberDTO memberDTO) throws Exception;
}
