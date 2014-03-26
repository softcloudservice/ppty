package com.sds.ppty.dao.test;

import org.springframework.stereotype.Repository;

import com.sds.ppty.dao.common.BaseDAO;

@Repository
public class TestDAOImpl extends BaseDAO implements TestDAO {

	@Override
	public int getTestData() {
		int result = (Integer)this.queryForObject("getTestData");
		return result;
	}

}
