package com.sds.ppty.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.sds.ppty.common.exception.SDSExceptionHandler;

public class SDSCommonService {

	@Autowired
	@Qualifier("BslExceptionHandler")
	private SDSExceptionHandler exceptionHandler;

	/**
	 * @return the exceptionHandler
	 */
	public SDSExceptionHandler getExceptionHandler() {
		return exceptionHandler;
	}

	/**
	 * @param exceptionHandler the exceptionHandler to set
	 */
	public void setExceptionHandler(SDSExceptionHandler exceptionHandler) {
		this.exceptionHandler = exceptionHandler;
	}
}
