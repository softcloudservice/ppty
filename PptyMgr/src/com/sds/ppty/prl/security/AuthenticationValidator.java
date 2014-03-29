package com.sds.ppty.prl.security;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.sds.ppty.entities.common.UserVO;

@Component
public class AuthenticationValidator implements Validator{
	
	static final Logger logger = LogManager.getLogger(AuthenticationValidator.class.getName());
	
	@Autowired
	@Qualifier("messageSource")
	private ResourceBundleMessageSource messageSource;

	public ResourceBundleMessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(ResourceBundleMessageSource messageSource) {
		this.messageSource = messageSource;
	}
	/*
	 * Returns the message for a key
	 */
	public String getMessage(String key)
	{		
		return messageSource.getMessage("sample", null, null);
	}

	@Override
	public boolean supports(Class<?> command) {
		logger.info("supports inside  validator");
		return command.isAssignableFrom(UserVO.class);
	}

	@Override
	public void validate(Object command, Errors errors) {
		logger.info("validating inside validator");
		UserVO userVO = (UserVO)command;
		if(userVO.getFirstName()==null || userVO.getFirstName().isEmpty())
			errors.reject("firstName", getMessage("simple"));
	}

}
