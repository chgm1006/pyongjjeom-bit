/**
 * 
 */

package com.pyongjjeom.login.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pyongjjeom.login.dao.LoginMapper;
import com.pyongjjeom.login.service.LoginService;
import com.pyongjjeom.login.service.MailService;
import com.pyongjjeom.user.dto.Member;

/**
 * <pre>
 * com.pyongjjeom.login.controllers 
 *    |_ MailController.java
 * 
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

	@RequestMapping(value = "emailAuth.force", method = RequestMethod.GET)
	public String goEmailAuth() {
		return "login/emailAuth";
	}

	@RequestMapping(value = "emailAuth_check.force", method = RequestMethod.POST)
	public String emailAuth(Member user, HttpServletRequest request) {
		String toUser = (String) request.getParameter("email");
		if (toUser == null) {
			return "login/emailAuth";
		}
		System.out.println("toUser = " + toUser);

		Random random = new Random();
		String memCD = loginService.getMemCD(toUser);
		String subject = "<평쩜> 요청하신 인증번호 입니다";
		String fromUser = "force.pyongjjeom@gmail.com";
		String authCD = random.nextInt(999999) + "";
		StringBuilder text = new StringBuilder();
		Member member = new Member();

		text.append("<h2>이메일 인증 코드입니다</h2><br>");
		text.append(authCD);
		text.append("<br><a href='http://localhost:8080/pyongjjeom/views/emailAuth_check.force'>인증번호 입력</a>");

		member.setEmailAuthCD(authCD);
		member.setMemCD(memCD);
		member.setEmail(toUser);

		int updateCnt = loginService.updateEmailAuthCD(member);

		String emailCD = loginService.getEmailAuthCD(toUser);

		System.out.println("memCD = " + memCD);
		System.out.println("authCD = " + authCD);
		System.out.println("text = " + text.toString());
		System.out.println("updateCnt = " + updateCnt);
		System.out.println("emailCD = " + emailCD);

		// mailService.sendMail(subject, text.toString(), fromUser, toUser);
		return "login/emailAuth_check";
	}
}
