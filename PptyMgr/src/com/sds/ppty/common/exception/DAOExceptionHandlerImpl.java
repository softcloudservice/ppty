package com.sds.ppty.common.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

public class DAOExceptionHandlerImpl implements SDSExceptionHandler {

	private static final Logger logger = LogManager.getLogger(DAOExceptionHandlerImpl.class.getName());
	
	@Override
	public Exception handleException(Exception e) {
		this.logException(e);
		return this.getDAOException("system.error", e);
	}
	
	public void logException(Exception e) {
			logger.error("Exception - ****logException****" + e.getMessage());
			e.printStackTrace();
	}
	
	private DAOException getDAOException(String exceptionID, Throwable th) {
		DAOException daoException = new DAOException(exceptionID, th);
		return daoException;
	}

}
