package com.choa.member.memberFile;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.s4.MyTestCase;
import com.choa.s4.member.memberFile.MemberFileDAO;
import com.choa.s4.member.memberFile.MemberFileDTO;

public class MemberFileDAOTest extends MyTestCase{

	@Autowired
	private MemberFileDAO memberFileDAO;
	
	@Test(expected = RuntimeException.class)
	public void setInsertTest() throws Exception {
		
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setId("id445645613");
		memberFileDTO.setFileName("fileName");
		memberFileDTO.setOriName("oriName");
		
		int result = memberFileDAO.setInsert(memberFileDTO);
		
		assertEquals(1, result);
	}

}
