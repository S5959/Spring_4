package com.choa.s4.member.memberUser;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.s4.MyTestCase;
import com.choa.s4.member.MemberDTO;

public class MemberUserDTOTest extends MyTestCase {

	@Autowired
	private MemberUserDAO memberUserDAO;
	
	@Test
	public void getMemberLoginTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id4");
		memberDTO.setPw("pw4");
		
		MemberDTO result = memberUserDAO.getMemberLogin(memberDTO);
		
		assertNotNull(result);
	}

}
