package com.sds.ppty.dao.common;

import com.sds.ppty.common.exception.DAOException;

public interface SDSAuthDAO {

	public String getUserRole(String username)  throws DAOException;
}
