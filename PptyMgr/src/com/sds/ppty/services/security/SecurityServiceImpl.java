package com.sds.ppty.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.ppty.common.exception.DAOException;
import com.sds.ppty.common.exception.ServiceException;
import com.sds.ppty.dao.security.SecurityDAO;
import com.sds.ppty.entities.common.UserVO;

@Service
public class SecurityServiceImpl extends SDSCommonService implements SecurityService {

	@Autowired
	private SecurityDAO securityDAO;
	
	/**
	 * @return the securityDAO
	 */
	public SecurityDAO getSecurityDAO() {
		return securityDAO;
	}

	/**
	 * @param securityDAO the securityDAO to set
	 */
	public void setSecurityDAO(SecurityDAO securityDAO) {
		this.securityDAO = securityDAO;
	}

	@Override
	public void registerUser(UserVO user) throws ServiceException{
		
		try {
			this.getSecurityDAO().registerUser(user);
		} catch (DAOException e) {
			throw (ServiceException) this.getExceptionHandler().handleException(e);
		}

	}
}
