/**
 * 
 */

package com.pyongjjeom.test.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

	@RequestMapping(value = "FBTest.force")
	public String goFBTest(Model model, HttpServletRequest request) {
		log.info("FBTestController goFBTest");

		return "test/FBTest";
	}
}
