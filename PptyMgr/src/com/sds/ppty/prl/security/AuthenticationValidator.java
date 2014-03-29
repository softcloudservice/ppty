package com.sds.ppty.prl.security;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	public AuthenticationValidator() {
		emailsPattern = Pattern.compile(EMAIL_PATTERN);
		mobilePattern = Pattern.compile(MOBILE_PATTERN);
		userPattern   = Pattern.compile(USERNAME_PATTERN);
	}
	
	static final Logger logger = LogManager.getLogger(AuthenticationValidator.class.getName());
	
	private Pattern emailsPattern;
	
	private Pattern mobilePattern;
	
	private Pattern userPattern;
	
	private Matcher matcher;
	
	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	private static final String MOBILE_PATTERN = "\\d{10}";
	
	private static final String USERNAME_PATTERN = "^[a-zA-Z0-9]*$";
	
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
			errors.rejectValue("firstName", "field.required");
		if(userVO.getLastName()==null || userVO.getLastName().isEmpty())
			errors.rejectValue("lastName", "field.required");
		
		matcher = userPattern.matcher(userVO.getUsername());
		if(userVO.getUsername()==null || userVO.getUsername().isEmpty())
			errors.rejectValue("username", "field.required");
		else if(userVO.getUsername().length() >10 || userVO.getUsername().length() <6)
			errors.rejectValue("username", "username.invalidlength");
		else if(!matcher.matches())
			errors.rejectValue("username", "username.invalidformat");
		
		if(userVO.getPassword()==null || userVO.getPassword().isEmpty())
			errors.rejectValue("password", "field.required");
		if(userVO.getConfirmPswd()==null || userVO.getConfirmPswd().isEmpty())
			errors.rejectValue("confirmPswd", "field.required");
		
		matcher = emailsPattern.matcher(userVO.getEmail());
		if(userVO.getEmail()==null || userVO.getEmail().isEmpty())
			errors.rejectValue("email", "field.required");
		else if(!matcher.matches())
			errors.rejectValue("email", "email.invalid");
			
		matcher = mobilePattern.matcher(userVO.getMobile());
		if(userVO.getMobile()==null || userVO.getMobile().isEmpty())
			errors.rejectValue("mobile", "field.required");
		else if(!matcher.matches())
			errors.rejectValue("mobile", "mobile.invalid");
		if(userVO.getLocation()==null || userVO.getLocation().isEmpty())
			errors.rejectValue("location", "field.required");
		
		
		
			
	}

}
