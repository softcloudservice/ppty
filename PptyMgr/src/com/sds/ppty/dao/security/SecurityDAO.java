package com.sds.ppty.dao.security;

import com.sds.ppty.common.exception.DAOException;
import com.sds.ppty.entities.common.UserVO;

public interface SecurityDAO {
	
	public void registerUser(UserVO user)  throws DAOException;
}
