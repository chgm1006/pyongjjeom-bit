/**
 * 
 */

package com.pyongjjeom.login.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.pyongjjeom.login.dao.LoginMapper;

/**
 * <pre>
 * com.pyongjjeom.login.service 
 *    |_ MailServiceImpl.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
@Service("mailService")
public class MailServiceImpl implements MailService {

	private Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private LoginMapper loginMapper;

	/**
	 * <pre>
	 * 1. 개요 : 메일인증을 위한 메일 sender service 인터페이스 구현
	 * 2. 처리내용 : 인증코드 메일을 전송한다.
	 * </pre>
	 * 
	 * @Method Name : sendMail
	 * @date : 2014. 6. 24.
	 * @author : Forrest
	 * @history :
	 *          ------------------------------------------------------------------
	 *          ----- 변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2014. 6. 24. Forrest 최초 작성
	 *          ------------------------------------------------------------------
	 *          -----
	 * 
	 * @see com.pyongjjeom.login.service.MailService#sendMail(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String[])
	 * @param subject
	 *          메일 제목
	 * @param text
	 *          메일내용
	 * @param fromUser
	 *          보내는 사람
	 * @param toUser
	 *          받는 사람
	 * @param toCC
	 *          받는 사람 참조 배열
	 */
	@Override
	public void sendMail(String subject, String text, String fromUser,
			String toUser) {
		// TODO Auto-generated method stub

		MimeMessage message = mailSender.createMimeMessage();

		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true,
					"UTF-8");
			messageHelper.setSubject(subject);
			messageHelper.setTo(toUser);
			messageHelper.setFrom(fromUser);
			messageHelper.setText(text, true);
			mailSender.send(message);

		} catch (MessagingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
