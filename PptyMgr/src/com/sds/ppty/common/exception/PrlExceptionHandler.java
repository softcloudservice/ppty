package com.sds.ppty.common.exception;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

public interface PrlExceptionHandler extends SDSExceptionHandler {

	public ModelAndView handleException(Exception e, BindingResult result, String errorView);
	
}
