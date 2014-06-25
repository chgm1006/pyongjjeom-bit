/**
 * 
 */

package com.pyongjjeom.login.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pyongjjeom.common.CommonLIB;
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
		return "emailAuth/emailAuth";
	}

	@RequestMapping(value = "emailAuth_sendCD.force", method = RequestMethod.POST)
	public String sendEmailAuth(Member user, HttpServletRequest request) {
		String toUser = (String) request.getParameter("email");
		if (toUser == null) {
			return "emailAuth/emailAuth";
		}

		String memCD = loginService.getMemCD(toUser);
		String subject = "<평쩜> 요청하신 인증번호 입니다";
		String fromUser = "force.pyongjjeom@gmail.com";
		String authCD = Math.round(Math.random() * 999999) / 1 + "";
		String text = getEmailText(authCD);
		Member member = new Member();

		member.setEmail(toUser);
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

		request.setAttribute("member", member);
		// mailService.sendMail(subject, text.toString(), fromUser, toUser);
		return "emailAuth/emailAuth_check";
	}

	protected String getEmailText(String authCD) {
		StringBuilder text = new StringBuilder();
		text.append("<h2>이메일 인증 코드입니다</h2><br>");
		text.append(authCD);
		text.append("<br><a href='http://localhost:8080/pyongjjeom/views/emailAuth_check.force'>인증번호 입력</a>");

		return text.toString();
	}

	@RequestMapping(value = "emailAuth_check.force", method = RequestMethod.POST)
	public String checkEmailAuth(Member user, HttpServletRequest request) {
		String emailCD = (String) request.getParameter("emailAuthCD");
		String email = (String) request.getParameter("email");

		System.out.println("emailCD = " + emailCD);
		System.out.println("email = " + email);

		String erroMSG = checkEmailCD(emailCD);
		if (!(erroMSG.equals(""))) {
			request.setAttribute("errorMSG", erroMSG);
			return "emailAuth/emailAuth_check";
		}
		
		String userAuthCD = loginService.getEmailAuthCD(email);
		System.out.println("userAuthCD = " + userAuthCD);
		
		if(emailCD.equals(userAuthCD)){
			return "emailAuth/emailAuth_ok";
		}

		return "emailAuth/emailAuth_check";
	}

	protected String checkEmailCD(String emailCD) {
		String errorMSG = "";
		if (emailCD == null || emailCD.equals("")) {
			errorMSG = "인증번호를 입력하세요";
		} else if (!CommonLIB.isNumeric(emailCD)) {
			errorMSG = "인증번호를 확인하세요";
		}

		return errorMSG;
	}
}
