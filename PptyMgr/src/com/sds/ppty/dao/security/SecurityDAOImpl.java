package com.sds.ppty.dao.security;

import org.springframework.stereotype.Repository;

import com.sds.ppty.common.exception.DAOException;
import com.sds.ppty.dao.common.BaseDAO;
import com.sds.ppty.entities.common.UserVO;

@Repository
public class SecurityDAOImpl extends BaseDAO implements SecurityDAO {

	@Override
	public void registerUser(UserVO user)  throws DAOException{
		try{
			System.out.println("Adding user to DAO");
		}
		catch (Exception e) {
			throw (DAOException) this.getExceptionHandler().handleException(e);
		}
	}
}
