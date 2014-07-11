/**
 * 
 */

package com.pyongjjeom.login.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pyongjjeom.common.CommonAES;
import com.pyongjjeom.login.service.LoginService;
import com.pyongjjeom.login.service.MailService;
import com.pyongjjeom.user.dto.Member;

/**
 * <pre>
 * com.pyongjjeom.login.controllers 
 *    |_ MailController.java
 * 
 * 인증메일 전송을 위한 클래스.
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
@Controller
public class MailController {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private MailService mailService;

	@Autowired
	private LoginService loginService;

	@Value("#{common['urlPath']}")
	private String urlPath;

	@RequestMapping(value = "emailAuth.do", method = RequestMethod.GET)
	public String goEmailAuth() {
		return "emailAuth/emailAuth";
	}

	@RequestMapping(value = "emailAuth_sendCD.do", method = RequestMethod.POST)
	public String sendEmailAuth(Member user, HttpServletRequest request) {
		String toUser = (String) request.getParameter("email");
		if (toUser == null) {
			return "emailAuth/emailAuth";
		}

		System.out.println("url = " + urlPath);
		String memCD = loginService.getMemCD(toUser);
		String subject = "<평쩜> 요청하신 인증번호 입니다";
		String fromUser = "force.pyongjjeom@gmail.com";
		String authCD = Math.round(Math.random() * 999999) / 1 + "";
		String text = getEmailText(authCD, toUser);

		Member member = new Member();

		member.setEmail(toUser);
		member.setEmailAuthCD(authCD);
		member.setMemCD(memCD);

		int updateCnt = loginService.updateEmailAuthCD(member);

		request.setAttribute("member", member);

		mailService.sendMail(subject, text.toString(), fromUser, toUser);
		return "emailAuth/emailAuth_check";
	}

	protected String getEmailText(String authCD, String email) {
		StringBuilder text = new StringBuilder();
		CommonAES aes = new CommonAES();
		text.append("<h2><b>이메일 인증 코드입니다</b></h2><br>");
		text.append(authCD);
		text.append("<br><a href='" + urlPath + "emailAuth_forward.jsp?rootc="
				+ aes.getEncryptor(authCD) + "&rootm=" + aes.getEncryptor(email)
				+ "'>인증번호 입력</a>");

		return text.toString();
	}

	// @RequestMapping(value = "emailAuth_check.do", method = RequestMethod.GET)
	// public String checkEmailAuthGET(Member user, HttpServletRequest request) {
	// return checkEmailAuth(user, request);
	// }

	@RequestMapping(value = "emailAuth_check.do", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String checkEmailAuth(Member member, HttpServletRequest request) {
		String emailCD = (String) request.getParameter("emailAuthCD");
		String email = (String) request.getParameter("email");

		String userAuthCD = loginService.getEmailAuthCD(email);
		String resultPage = "";
		member.setEmail(email);
		member.setMemCD(loginService.getMemCD(email));

		if (emailCD.equals(userAuthCD)) {
			loginService.updateEmailAuthCDCheck(member);
			request.setAttribute("email", email);
			resultPage = "emailAuth/emailAuth_ok";
		} else {
			request.setAttribute("errorMSG", "인증번호를 확인하세요");
			resultPage = "emailAuth/emailAuth_check";
		}

		return resultPage;
	}

	@RequestMapping(value = "goChangePasswd.do", method = RequestMethod.POST)
	public String goChangePasswd(Member member, HttpServletRequest request) {

		request.setAttribute("email", member.getEmail());
		System.out.println("email = " + member.getEmail());

		return "emailAuth/changePasswd";
	}

	@RequestMapping(value = "changePasswd.do", method = RequestMethod.POST)
	public String changePasswd(Member member, HttpServletRequest request) {
		System.out.println("passwd = " + member.getPasswd());
		System.out.println("email = " + member.getEmail());

		int cnt = loginService.updateMemberPasswd(member);
		return "emailAuth/changePasswd_success";
	}

}
