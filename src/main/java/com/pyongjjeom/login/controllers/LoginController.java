/**
 * 
 */

package com.pyongjjeom.login.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pyongjjeom.login.service.LoginService;
import com.pyongjjeom.user.dto.Member;
import com.pyongjjeom.user.service.UserService;

/**
 * <pre>
 * com.pyongjjeom.login.controllers 
 *    |_ LoginController.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
@Controller
public class LoginController {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private LoginService loginService;

	@Autowired
	private UserService userService;

	private Member mem;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String checkMemberLogin(String email) {
		return null;
	}

	@RequestMapping(value = "registerMember.force", method = RequestMethod.GET)
	public String createMember(Member user) {
		return "login/registerMember";
	}

}
