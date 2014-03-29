package com.sds.ppty.prl.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sds.ppty.entities.common.BaseVO;
import com.sds.ppty.service.test.TestService;

@Controller
public class TestController {
	
	static final Logger logger = LogManager.getLogger(TestController.class.getName());
	
	@Autowired
	private TestService testService;

	public TestService getTestService() {
		return testService;
	}

	public void setTestService(TestService testService) {
		this.testService = testService;
	}
	@RequestMapping(value = "/welcome.sd", method = RequestMethod.POST)
	public String welcomeAdmin(ModelMap model) {

		model.addAttribute("message", "Spring Security logout example");
		return "hello";

	}
	
	@RequestMapping("test.sd")
    public ModelAndView  testMyBatis(@ModelAttribute("name") String name,HttpServletRequest request,
	        HttpServletResponse response) {
		logger.info("Spring MVC Log4j!");
		System.out.println(this.getTestService().getTestData());		
		BaseVO vo =  new BaseVO();
		System.out.println(vo.getCreatedUser());
		System.out.println(vo.getUpdatedUser());
		System.out.println(vo.getCurrentTimestamp());
		System.out.println(vo.getCreatedTimeStamp());
		System.out.println(vo.getUpdatedTimeStamp());
		
		ModelAndView mv = new ModelAndView("test","sriharsha","sriharsha");
		return mv;
    }
	

}
