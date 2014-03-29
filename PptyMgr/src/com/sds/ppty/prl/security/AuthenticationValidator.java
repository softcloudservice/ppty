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
		alphaPattern = Pattern.compile(ALPHA_ONLY);
		pswdPattern = Pattern.compile(PASSWORD_PATTERN);
	}
	
	static final Logger logger = LogManager.getLogger(AuthenticationValidator.class.getName());
	
	private Pattern emailsPattern;
	
	private Pattern mobilePattern;
	
	private Pattern userPattern;
	
	private Pattern alphaPattern;
	
	private Pattern pswdPattern;
	
	private Matcher matcher;
	
	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	private static final String MOBILE_PATTERN = "\\d{10}";
	
	private static final String USERNAME_PATTERN = "^[a-zA-Z0-9]*$";
	
	private static final String ALPHA_ONLY =  "^[a-zA-Z]*$";
	
	private static final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*d)(?=.*[A-Z]).{6,12})";
	
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
		
		matcher = alphaPattern.matcher(userVO.getFirstName());
		if(userVO.getFirstName()==null || userVO.getFirstName().isEmpty())
			errors.rejectValue("firstName", "field.required");
		else if(userVO.getFirstName().length() >30 || userVO.getFirstName().length() <3)
			errors.rejectValue("firstName", "field.invalidlength");
		else if(!matcher.matches())
			errors.rejectValue("firstName", "field.alpha");
		
		
		matcher = alphaPattern.matcher(userVO.getMiddleName());
		if(userVO.getMiddleName()!=null && userVO.getMiddleName().length() >30)
			errors.rejectValue("middleName", "field.invalidlength");
		else if(userVO.getMiddleName()!=null && !matcher.matches())
			errors.rejectValue("middleName", "field.alpha");
		
		matcher = alphaPattern.matcher(userVO.getLastName());
		if(userVO.getLastName()==null || userVO.getLastName().isEmpty())
			errors.rejectValue("lastName", "field.required");
		else if(userVO.getLastName().length() >30 || userVO.getLastName().length() <3)
			errors.rejectValue("lastName", "field.invalidlength");
		else if(!matcher.matches())
			errors.rejectValue("lastName", "field.alpha");
		
		
		matcher = userPattern.matcher(userVO.getUsername());
		if(userVO.getUsername()==null || userVO.getUsername().isEmpty())
			errors.rejectValue("username", "field.required");
		else if(userVO.getUsername().length() >10 || userVO.getUsername().length() <6)
			errors.rejectValue("username", "username.invalidlength");
		else if(!matcher.matches())
			errors.rejectValue("username", "username.invalidformat");
		
		matcher = pswdPattern.matcher(userVO.getPassword());
		if(userVO.getPassword()==null || userVO.getPassword().isEmpty())
			errors.rejectValue("password", "field.required");		
		else if(!matcher.matches())
			errors.rejectValue("password", "password.invalidformat");
		
		if(userVO.getConfirmPswd()==null || userVO.getConfirmPswd().isEmpty() 
				|| userVO.getPassword()!=userVO.getConfirmPswd())
			errors.rejectValue("confirmPswd", "passwordconfirm.invalid");	
				
		
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
