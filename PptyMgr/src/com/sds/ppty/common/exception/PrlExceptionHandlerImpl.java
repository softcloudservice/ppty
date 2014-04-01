package com.sds.ppty.common.exception;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

public class PrlExceptionHandlerImpl implements PrlExceptionHandler {
	
	private static final Logger logger = LogManager
	        .getLogger(PrlExceptionHandlerImpl.class.getName());

	private String commonErrorPage;
	
	@Autowired
	private ResourceBundleMessageSource messageSource;
	
	
	/**
	 * @return the commonErrorPage
	 */
	public String getCommonErrorPage() {
		return commonErrorPage;
	}

	/**
	 * @param commonErrorPage the commonErrorPage to set
	 */
	public void setCommonErrorPage(String commonErrorPage) {
		this.commonErrorPage = commonErrorPage;
	}

	/**
	 * @return the messageSource
	 */
	public ResourceBundleMessageSource getMessageSource() {
		return messageSource;
	}

	/**
	 * @param messageSource the messageSource to set
	 */
	public void setMessageSource(ResourceBundleMessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@Override
	public Exception handleException(Exception e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView handleException(Exception e, BindingResult result,
			String errorView) {

		
		e.printStackTrace();
		logger.error("Exception***" + e.getMessage());
		
		String detailedMessage = "Error ";
		String field = null;
		String view = "";
		Map mdl = null;
		ModelMap model = new ModelMap();
		
		detailedMessage = "message";//MessageResourceUtil.getDetailedMessage(this.getMessageSource(), e);
		
		if(e instanceof SDSException)
		{
			if(e instanceof ServiceException)
			{
				ServiceException busException = (ServiceException)e;				
				result.reject(busException.getExceptionID(),detailedMessage);
				view = errorView;
				mdl = result.getModel();
				model.addAllAttributes(mdl);
			}			
		}		
		else
		{
			view = this.getCommonErrorPage();
			mdl = result.getModel();
			model.addAllAttributes(mdl);
			
			detailedMessage = "message";//MessageResourceUtil.getDetailedMessage(this.getMessageSource(),"system.error");
			if(e.getCause() == null)
			{
				model.put("message", detailedMessage);
				model.put("stackTrace", e.getStackTrace());
			}
			else
			{
				model.put("message", detailedMessage);
				model.put("stackTrace", e.getCause().getStackTrace());
			}
		}		
		return new ModelAndView(view, model);
	}

}
