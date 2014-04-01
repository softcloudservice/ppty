package com.sds.ppty.common.exception;

public class ServiceException extends SDSException {

	/**
	 * constructor
	 * 
	 * @param exceptionID
	 * @param rootCause
	 */
	public ServiceException(String exceptionID, Throwable rootCause)
	{
		super(exceptionID, rootCause);
	}
	
	/**
	 * constructor
	 * 
	 * @param exceptionID
	 */
	public ServiceException(String exceptionID)
	{
		super(exceptionID);
	}
}
