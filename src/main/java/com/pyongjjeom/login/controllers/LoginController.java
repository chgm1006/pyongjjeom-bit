/**
 * 
 */

package com.pyongjjeom.login.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
	public String login(@Valid Model model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws IOException {

		String email = request.getParameter("email");
		String passwd = request.getParameter("passwd");
		System.out.println(email);
		System.out.println(passwd);

		Member member = new Member(email, passwd);
		member = loginService.login(member);
		System.out.println("세션 등록 전 = " + member);

		if (member == null) {
			return "login/login_check1";
		} else if (member.getMemKind().equals("D")) {
			return "login/login_check2";
		}

		else {
			System.out.println(member.getMemKind());

			session.setAttribute("member", member);
			System.out.println("sessiong = " + member);
			System.out.println(session.getAttribute("member"));
			System.out.println(request.getSession() + "로그인세션등록완료");
			return "contents/movieIndex";
		}

	}

	/*
	 * @RequestMapping(value="gologin.do", method=RequestMethod.GET) public void
	 * gologin(HttpServletRequest request, HttpServletResponse response)throws
	 * ServletException, IOException{ String redirectPage =
	 * request.getParameter("uri"); String redirectPage = (String)
	 * request.getAttribute("redirectURI");
	 * System.out.println(request.getAttribute("redirectURI")+"uri체크");
	 * if(redirectPage ==null){ redirectPage = "movieIndex.do"; }else{
	 * response.sendRedirect(redirectPage);
	 * 
	 * } }
	 */

	// 로그인폼으로 이동
	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String loginForm(HttpServletRequest request) {

		return "login/login";

	}

	@RequestMapping(value = "logout.do", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String logout(HttpSession session) {
		log.info("logout.do");
		Member member = (Member) session.getAttribute("member");
		System.out.println("세션 삭제 전 member 데이터 : " + member.toString());
		session.removeAttribute("member");
		member = null;
		System.out.println("세션 삭제 후 member 데이터 : " + member);

		return "contents/movieIndex";
	}

	@RequestMapping(value = "register.do", method = RequestMethod.POST)
	public String insertMember(@Valid Member user) {

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

	/*
	 * @RequestMapping(value = "idCheck.do", method = RequestMethod.GET) public
	 * String getEamil(String email, Model model){
	 * 
	 * Member member = loginService.getEmail(email); if(member == null){
	 * model.addAttribute("result", "true"); }else{ model.addAttribute("result",
	 * "false"); } return "login/idCheck"; }
	 */

	@ResponseBody
	@RequestMapping(value = "fbLogin.do", method = RequestMethod.POST)
	public Member fbLogin(@RequestBody Member member, HttpSession session) {
		log.info("fbLogin");

		Member memInfo = loginService.getMemberInfoByMember(member);

		boolean isMemInfo = (memInfo.getEmail().equals(member.getEmail())
				&& memInfo.getFbId().equals(member.getFbId()) && memInfo.getFbYn() == 'Y');

		if (isMemInfo) {
			session.setAttribute("member", memInfo);
		} else {
			memInfo = null;
		}
		return memInfo;

	}

	@ResponseBody
	@RequestMapping(value = "fbRegisterMember.do", method = RequestMethod.POST)
	public Member fbRegisterMember(@RequestBody Member member,
			HttpServletRequest request) {
		log.info("fbRegisterMember");

		// System.out.println(paramMap.get("email"));

		member.setMemCD(dc.getMemberCD("F"));
		member.setPasswd(Math.round(Math.random() * 10) + "");

		Member memInfo = loginService.getMemberInfoByMember(member);

		int cnt = 0;
		if (memInfo.getMemCD().equals("") && memInfo.getFbId().equals("")) {
			cnt = loginService.regiesterFBMember(member);
		} else {
			cnt = loginService.updateFBMember(member);
		}

		Member sMember = loginService.getMemberInfoByFBID(member.getFbId());
		System.out.println("cnt = " + cnt);
		HttpSession session = request.getSession();
		if (cnt > 0) {
			session.setAttribute("member", sMember);
			session.setAttribute("fbErrorMSG", "");
		} else {
			session.setAttribute("fbErrorMSG", "정보가 정상적으로 저장되지 않았습니다.");
		}
		return sMember;

	}

	@RequestMapping(value = "ajaxLoginCheck.do", method = RequestMethod.POST)
	public ModelAndView AjaxCheck(@Valid Member user, HttpServletRequest request) {
		System.out.println("로그인 체크");
		ModelAndView view = new ModelAndView("ajax_views/userajax");
		System.out.println("11111");
		System.out.println(request.getParameter("email"));
		String email = request.getParameter("email");

		Member emailStr = loginService.getEmail(email);
		System.out.println("emailStr : " + emailStr);

		if (emailStr != null) {
			if (email.trim().equals(emailStr.getEmail().trim()) == true) {
				view.addObject("result", "true");
				System.out.println("아이디가 존재합니다");
			} else {
				System.out.println("아이디오류 오류");
				view.addObject("result", "fail");
			}

			return view;
		} else {
			System.out.println("아이디를 사용할 수 있습니다");
			view.addObject("result", "fail");

		}

		return view;
	}

}
