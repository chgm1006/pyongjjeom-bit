/**
 * 
 */

package com.pyongjjeom.login.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value = "loginsuccess.force", method = RequestMethod.POST)
	public  String login(){
		
		System.out.println("ddd");
		return "login/loginsuccess";
		
	}
	
	@RequestMapping(value = "login.force", method = RequestMethod.GET)
	public String loginForm(){
		
		return "login/login";
		
	}
	
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String checkMemberLogin(String email) {
		
			
		loginService.checkMemberLogin(email);
		return null;
	}
	
	@RequestMapping(value = "register.force", method = RequestMethod.POST)
	public String inserMember(@Valid Member user){
		
		String logCD = dc.getMemberCD("G");
		System.out.println("dd");
		user.setMemCD(logCD);
		System.out.println(user);
		loginService.insertMember(user);
		
		return "login/registersucess";
	}
	@RequestMapping(value = "registerMember.force", method = RequestMethod.GET)	
	public String createMember() {
		
		
		return "login/registerMember";
	}

}
