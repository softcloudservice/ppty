package com.sds.ppty.entities.common;

import java.sql.Timestamp;
import java.util.Calendar;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class BaseVO {

	/**
	 * @return
	 */
	public java.sql.Timestamp getCreatedTimeStamp()
	{

		java.sql.Timestamp returnTimestamp = this.getCurrentTimestamp();

		return returnTimestamp;
	}

	/**
	 * @return
	 */
	public String getCreatedUser()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = "nologin";
	    if(auth!=null)
	    	name = auth.getName(); //get logged in username		
		return name;
	}

	/**
	 * @return
	 */
	public java.sql.Timestamp getUpdatedTimeStamp()
	{

		java.sql.Timestamp returnTimestamp = this.getCurrentTimestamp();
		return returnTimestamp;
	}

	/**
	 * @return currentTS
	 */
	public Timestamp getCurrentTimestamp()
	{

		Timestamp currentTS = new Timestamp(Calendar.getInstance()
		        .getTimeInMillis());
		return currentTS;
	}

	/**
	 * @return returnString
	 */
	public String getUpdatedUser()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = "nologin";
	    if(auth!=null)
	    	name = auth.getName(); //get logged in username		
		return name;
	}

}
