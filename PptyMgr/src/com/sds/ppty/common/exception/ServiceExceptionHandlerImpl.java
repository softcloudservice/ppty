package com.sds.ppty.common.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServiceExceptionHandlerImpl implements SDSExceptionHandler {
	
private static final Logger logger = LogManager.getLogger(ServiceExceptionHandlerImpl.class.getName());
	
	@Override
	public Exception handleException(Exception e) {
		this.logException(e);
		return this.getServiceException("system.error", e);
	}
	
	public void logException(Exception e) {
			logger.error("Exception - ****logException****" + e.getMessage());
			e.printStackTrace();
	}
	
	private ServiceException getServiceException(String exceptionID, Throwable th) {
		ServiceException serviceException = new ServiceException(exceptionID, th);
		return serviceException;
	}

}
