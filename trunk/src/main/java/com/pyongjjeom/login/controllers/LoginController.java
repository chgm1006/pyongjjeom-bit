/**
 * 
 */

package com.pyongjjeom.login.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

/*	@Autowired
	private UserService userService;*/

	private DBCode dc = new DBCode();

	@RequestMapping(value = "loginsuccess.do", method = RequestMethod.POST)
	public String login(@Valid Member user, HttpServletRequest request) {

		String email = request.getParameter("email");
		String passwd = request.getParameter("passwd");
		System.out.println(email);
		System.out.println(passwd);

		Member member = new Member(email, passwd);
		member = loginService.login(member);
		if (member == null) {
			
			System.out.println("아이디와패스워드불일치");
			return "login/login";
		}
		HttpSession session = request.getSession();

		/*
		 * if (!session.isNew()) { session = request.getSession(true); }
		 */

		session.setAttribute("member", member);
		System.out.println(request.getSession() + "로그인세션등록완료");
		return "contents/movieIndex";

	}

	// 로그인폼으로 이동
	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String loginForm(HttpServletRequest request) {

		return "login/login";

	}

	@RequestMapping(value = "logout.do", method = RequestMethod.GET)
	public String logout() {

		return "login/logout";
	}

	// @RequestMapping(value = "", method = RequestMethod.GET)
	// public String checkMemberLogin(String email) {
	//
	// loginService.checkMemberLogin(email);
	// return null;
	// }

	@RequestMapping(value = "register.do", method = RequestMethod.POST)
	public String inserMember(@Valid Member user) {

		String logCD = dc.getMemberCD("G");
		System.out.println("dd");
		user.setMemCD(logCD);
		System.out.println(user);
		loginService.insertMember(user);

		return "login/registersucess";
	}

	@RequestMapping(value = "registerMember.do", method = RequestMethod.GET)
	public String createMember() {

		return "login/registerMember";
	}

}
