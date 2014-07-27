/**
 * 
 */

package com.pyongjjeom.test.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pyongjjeom.contents.parsing.common.MovieGrades;
import com.pyongjjeom.contents.service.ContentService;

/**
 * <pre>
 * com.pyongjjeom.test.controllers 
 *    |_ FBTestController.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
@Controller
public class FBTestController {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private ContentService contentService;

	@RequestMapping(value = "FBTest.do")
	public String goFBTest(Model model, HttpServletRequest request) {
		log.info("FBTestController goFBTest");

		return "test/FBTest";
	}

	@ResponseBody
	@RequestMapping(value = "ajaxTest.do", method = RequestMethod.POST)
	public Map<String, Object> ajaxTest(@RequestBody Map paramMap, HttpServletRequest request) {

		System.out.println("name = " + paramMap.get("name"));
		System.out.println("data = " + paramMap.get("data"));

		String name = (String) paramMap.get("name");
		String data = (String) paramMap.get("data");

		List<String> list = new ArrayList<String>();
		list.add("json 테스트입니다.11111");
		list.add("json 테스트입니다.22222");
		list.add("json 테스트입니다.33333");

		MovieGrades grades = new MovieGrades();
		grades = contentService.movieGradeSelect("끝까지 간다");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("data", data);
		map.put("msg", "json 객체 사용");
		map.put("list", list);
		map.put("grades", grades);
		return map;
	}
}
