/**
 * 
 */

package com.pyongjjeom.login.service;

import java.util.Map;

import com.pyongjjeom.user.dto.Member;

/**
 * <pre>
 * com.pyongjjeom.login.service 
 *    |_ LoginService.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
public interface LoginService {

	public int checkMemberLogin(String email);

	public int createMember(Member user);

	public String getMemCD(String email);

	public int updateEmailAuthCD(Member member);

	public int updateEmailAuthCDCheck(Member member);

	public String getEmailAuthCD(String email);
}
