package com.sds.ppty.prl.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {

	
	@RequestMapping(value="login.auth", method = RequestMethod.GET)
	public String login(ModelMap model) { 
		return "security/login"; 
	}
	
	@RequestMapping("register.auth")
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("security/login","sriharsha","sriharsha");
		return mv; 
	}
	
	@RequestMapping("frgtpsswd.auth")
	public ModelAndView forgotPsswd(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("security/login","sriharsha","sriharsha");
		return mv; 
	}
}
