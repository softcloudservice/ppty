package com.sds.ppty.dao.common;

import org.springframework.stereotype.Repository;

@Repository("SDSAuthDAO")		
public class SDSAuthDAOImpl extends BaseDAO implements SDSAuthDAO {

	@Override
	public String getUserRole(String username) {
		return (String)this.queryForObject("getUserRole", username);
	}

}
