package com.sds.ppty.common.exception;

public class SDSException extends Exception {
	
	private String exceptionID;	
	
	/**
	 * @return the exceptionID
	 */
	public String getExceptionID() {
		return exceptionID;
	}

	/**
	 * @param exceptionID the exceptionID to set
	 */
	public void setExceptionID(String exceptionID) {
		this.exceptionID = exceptionID;
	}

	public SDSException(String exceptionID, Throwable rootCause)
	{
		this(exceptionID);
		this.initCause(rootCause);
	}
	
	public SDSException(String exceptionID)
	{
		this.exceptionID = exceptionID;
	}
	

}
