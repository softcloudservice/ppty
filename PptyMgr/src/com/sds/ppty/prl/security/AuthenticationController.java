package com.sds.ppty.prl.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sds.ppty.constants.WebConstants;
import com.sds.ppty.entities.common.UserVO;

@Controller
public class AuthenticationController {

	
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
		
		System.out.println(request.getParameter("firstName"));
		System.out.println(request.getParameter("password"));
		System.out.println(request.getParameterMap().keySet().toString());
		System.out.println(request.getParameterMap().values().toString());
		
		ModelAndView mv = new ModelAndView(WebConstants.LOGIN_PAGE,"infomation","Login successful..");
		return mv; 
	}
	
	@RequestMapping("frgtpsswd.auth")
	public ModelAndView forgotPsswd(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mv = new ModelAndView(WebConstants.FORGOT_PSSWD_PAGE,"message","Enter the details");
		return mv; 
	}
}
