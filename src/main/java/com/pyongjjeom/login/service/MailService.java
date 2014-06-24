/**
 * 
 */

package com.pyongjjeom.login.service;

import java.io.Serializable;

/**
 * <pre>
 * com.pyongjjeom.login.service 
 *    |_ MainService.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
public interface MailService extends Serializable {

	void sendMail(String subject, String text, String fromUser, String toUser);
}
