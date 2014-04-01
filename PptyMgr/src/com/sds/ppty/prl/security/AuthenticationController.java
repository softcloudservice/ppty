package com.sds.ppty.prl.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sds.ppty.common.exception.PrlExceptionHandler;
import com.sds.ppty.constants.WebConstants;
import com.sds.ppty.entities.common.UserVO;
import com.sds.ppty.prl.test.TestController;
import com.sds.ppty.services.security.SecurityService;

@Controller
public class AuthenticationController {

	static final Logger logger = LogManager.getLogger(TestController.class.getName());
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	@Qualifier("authenticationValidator")
	private AuthenticationValidator validator;
	
	/**
	   * Attach the custom validator to the Spring context
	   */
	  @InitBinder
	  protected void initBinder(WebDataBinder binder) {
	    binder.setValidator(validator);
	    logger.info("adding validator");
	    
	  }
	
	@RequestMapping(value="login.auth", method = RequestMethod.GET)
	public String login(ModelMap model) { 
		return "security/login"; 
	}
	
	@RequestMapping("register.auth")
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView(WebConstants.REGISTRATION_PAGE,"message","Please register");
		return mv; 
	}
	
	@RequestMapping("registerUser.auth")
	public ModelAndView registerUser(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute(WebConstants.USER) UserVO userVO,BindingResult result) {
		ModelAndView mv=null;
		try{
				validator.validate(userVO, result);
				if(!result.hasErrors())
				{
					this.getSecurityService().registerUser(userVO);
				}
				mv = new ModelAndView(WebConstants.LOGIN_PAGE,WebConstants.USER,userVO);
		}									
		catch (Exception e)
		{
			mv = this.getExceptionHandler().handleException(e, result,
			        WebConstants.LOGIN_PAGE);
		}
		return mv; 
	}
	
	@RequestMapping("frgtpsswd.auth")
	public ModelAndView forgotPsswd(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mv = new ModelAndView(WebConstants.FORGOT_PSSWD_PAGE,"message","Enter the details");
		return mv; 
	}

	/**
	 * @return the validator
	 */
	public AuthenticationValidator getValidator() {
		return validator;
	}

	/**
	 * @param validator the validator to set
	 */
	public void setValidator(AuthenticationValidator validator) {
		this.validator = validator;
	}

	/**
	 * @return the securityService
	 */
	public SecurityService getSecurityService() {
		return securityService;
	}

	/**
	 * @param securityService the securityService to set
	 */
	public void setSecurityService(SecurityService securityService) {
		this.securityService = securityService;
	}

	@Autowired
	@Qualifier("PrlExceptionHandler")
	private PrlExceptionHandler exceptionHandler;

	/**
	 * @return the exceptionHandler
	 */
	public PrlExceptionHandler getExceptionHandler() {
		return exceptionHandler;
	}

	/**
	 * @param exceptionHandler the exceptionHandler to set
	 */
	public void setExceptionHandler(PrlExceptionHandler exceptionHandler) {
		this.exceptionHandler = exceptionHandler;
	}
}
