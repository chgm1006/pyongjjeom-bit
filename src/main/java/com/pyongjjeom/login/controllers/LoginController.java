/**
 * 
 */

package com.pyongjjeom.login.controllers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

	/*
	 * @Autowired private UserService userService;
	 */

	private DBCode dc = new DBCode();

	@RequestMapping(value = "loginsuccess.do", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String login(@Valid Model model, Member user,
			HttpServletRequest request, HttpServletResponse response) throws IOException {

		String email = request.getParameter("email");
		String passwd = request.getParameter("passwd");
		System.out.println(email);
		System.out.println(passwd);

		Member member = new Member(email, passwd);
		member = loginService.login(member);
		if (member == null) {
			return "login/login_check1";
		} else if (member.getMemKind().equals("D")) {
			return "login/login_check2";
		}

		else {
			System.out.println(member.getMemKind());
			HttpSession session = request.getSession();

			session.setAttribute("member", member);
			System.out.println(request.getSession() + "로그인세션등록완료");

			return "contents/movieIndex";
		}

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

	@ResponseBody
	@RequestMapping(value = "fbLogin.do", method = RequestMethod.POST)
	public Member fbLogin(@RequestBody Member member, HttpServletRequest request) {
		log.info("fbLogin");

		// System.out.println(paramMap.get("email"));

		member.setMemCD(dc.getMemberCD("F"));
		member.setPasswd(Math.round(Math.random() * 10) + "");

		String memCD = loginService.getMemCDbyFBID(member.getFbId().trim());

		int cnt = 0;
		if (memCD == null || memCD == "") {
			cnt = loginService.regiesterFBMember(member);
		} else {
			cnt = loginService.updateFBMember(member);
		}

		Member sMember = loginService.getMemberInfoByFBID(member.getFbId());
		System.out.println("cnt = " + cnt);
		HttpSession session = request.getSession(false);
		if (cnt > 1) {
			session.setAttribute("memCD", sMember.getMemCD());
			session.setAttribute("email", sMember.getEmail());
			session.setAttribute("memCD", sMember.getMemNm());
			session.setAttribute("memNm", sMember.getMemCD());
			session.setAttribute("fbId", sMember.getFbId());
			session.setAttribute("imgPath", sMember.getImgPath());
		}else{
			session.setAttribute("errorMSG", "정보가 정상적으로 저장되지 않았습니다.");
		}
		return sMember;
	}

}
