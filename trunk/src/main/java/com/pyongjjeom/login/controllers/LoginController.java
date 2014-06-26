/**
 * 
 */

package com.pyongjjeom.login.controllers;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pyongjjeom.common.code.DBCode;
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
	
	private DBCode dc = new DBCode();
	private Member mem;

	@RequestMapping(value = "login.force", method = RequestMethod.GET)
	public String checkMemberLogin(String email) {
		
			
		loginService.checkMemberLogin(email);
		return "login/login";
	}

	@RequestMapping(value = "registerMember.force", method = RequestMethod.GET)
	public String createMember(@Valid Member user) {
		
		String logCD = dc.getMemberCD("G");
		user.setMemCD(logCD);
				
		loginService.createMember(user);
		return "login/registerMember";
	}

}
