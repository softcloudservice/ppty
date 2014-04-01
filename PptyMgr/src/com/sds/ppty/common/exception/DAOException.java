package com.sds.ppty.common.exception;

public class DAOException extends SDSException {

	/**
	 * constructor
	 * 
	 * @param exceptionID
	 * @param rootCause
	 */
	public DAOException(String exceptionID, Throwable rootCause)
	{
		super(exceptionID, rootCause);
	}
	
	/**
	 * constructor
	 * 
	 * @param exceptionID
	 */
	public DAOException(String exceptionID)
	{
		super(exceptionID);
	}
}
