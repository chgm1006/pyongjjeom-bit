package com.pyongjjeom.test.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pyongjjeom.test.service.EmpService;

@Controller
public class EmpController {
	@Autowired
	private EmpService empService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(EmpController.class);

	@RequestMapping(value = "emp/count.force", method = RequestMethod.GET)
	public String getEmpCount(Model model, HttpServletRequest request) {
		System.out.println(request.getParameter("data"));
		System.out.println("1111");
		logger.info("EmpController getEmpCount");
		model.addAttribute("count", empService.getAllEmpCount());
		return "emp/count";
	}
}