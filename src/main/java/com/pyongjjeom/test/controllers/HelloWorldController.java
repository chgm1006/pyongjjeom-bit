package com.pyongjjeom.test.controllers;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {
	@RequestMapping("hello.force")
	public ModelAndView hello() {
		System.out.println("111");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("helloworld");
		mav.addObject("greeting", getGreeting());
		return mav;
	}

	private String getGreeting() {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		return "안녕하세요!<br>지금은 " + hour + "시 입니다.";
	}
}