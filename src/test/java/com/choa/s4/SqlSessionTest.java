package com.choa.s4;

import static org.junit.Assert.assertNotNull;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.s4.MyTestCase;

public class SqlSessionTest extends MyTestCase {

	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		assertNotNull(sqlSession.getConnection());
	}

}
