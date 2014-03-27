package com.sds.ppty.prl.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sds.ppty.service.test.TestService;

@Controller
public class TestController {
	
	@Autowired
	private TestService testService;

	public TestService getTestService() {
		return testService;
	}

	public void setTestService(TestService testService) {
		this.testService = testService;
	}
	
	@RequestMapping("test.sd")
    public ModelAndView  testMyBatis(@ModelAttribute("name") String name,HttpServletRequest request,
	        HttpServletResponse response) {
		System.out.println(this.getTestService().getTestData());
		ModelAndView mv = new ModelAndView("test","sriharsha","sriharsha");
		return mv;
    }
	

}