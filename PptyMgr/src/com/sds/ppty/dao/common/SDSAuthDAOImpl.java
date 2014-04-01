package com.sds.ppty.dao.common;

import org.springframework.stereotype.Repository;

import com.sds.ppty.common.exception.DAOException;

@Repository("SDSAuthDAO")		
public class SDSAuthDAOImpl extends BaseDAO implements SDSAuthDAO {

	@Override
	public String getUserRole(String username) throws DAOException{
		try{
			return (String)this.queryForObject("getUserRole", username);
		}
		catch (Exception e) {
			throw (DAOException) this.getExceptionHandler().handleException(e);
		}		
	}

}
