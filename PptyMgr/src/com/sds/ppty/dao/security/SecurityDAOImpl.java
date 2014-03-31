package com.sds.ppty.dao.security;

import org.springframework.stereotype.Repository;

import com.sds.ppty.entities.common.UserVO;

@Repository
public class SecurityDAOImpl implements SecurityDAO {

	@Override
	public void registerUser(UserVO user) {
		
		System.out.println("Adding user to DAO");

	}
}
