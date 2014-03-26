package com.sds.ppty.service.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.ppty.dao.test.TestDAO;

@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	private TestDAO testDAO;

	public TestDAO getTestDAO() {
		return testDAO;
	}

	public void setTestDAO(TestDAO testDAO) {
		this.testDAO = testDAO;
	}

	@Override
	public int getTestData() {
		int result = this.getTestDAO().getTestData();
		return result;
	}

}
