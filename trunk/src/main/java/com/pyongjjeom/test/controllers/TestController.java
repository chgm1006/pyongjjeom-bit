package com.pyongjjeom.test.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pyongjjeom.test.parsing.contents.ContentsValue;
import com.pyongjjeom.test.parsing.movie.CgvParsing;
import com.pyongjjeom.test.parsing.movie.LotteParsing;
import com.pyongjjeom.test.parsing.movie.MegaBoxParsing;
import com.pyongjjeom.test.service.TestService;

@Controller
public class TestController {
	@Autowired
	private TestService testService;

	private static final Logger logger = LoggerFactory
			.getLogger(TestController.class);

	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String getEmpCount(Model model, HttpServletRequest request) {
		System.out.println("왓수?");
		logger.info("EmpController getEmpCount");

		CgvParsing cgvParsing = new CgvParsing();

		List<ContentsValue> cgvValues = new ArrayList<ContentsValue>();

		for (int i = 0; i < 20; i++) {
			cgvValues.add(new ContentsValue(cgvParsing.getTitleList().get(i),
					cgvParsing.getGradeList().get(i)));
		}
		System.out.println(cgvValues.toString());

		testService.gradeUpdate(cgvValues);

		// model.addAttribute("count", empService.getAllEmpCount());
		return "emp/count";
	}
}