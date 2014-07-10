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

	public Member getEmail(String email);

	public int insertMember(Member user);

	public String getMemCD(String email);

	public String getMemCDbyFBID(String fbId);

	public int updateEmailAuthCD(Member member);

	public int updateEmailAuthCDCheck(Member member);

	public String getEmailAuthCD(String email);

	public Member login(Member member);

	public String login(String email, String passwd);

	public int regiesterFBMember(Member member);

	public int updateFBMember(Member member);

	


	public Member getMemberInfoByFBID(String fbId);

}
