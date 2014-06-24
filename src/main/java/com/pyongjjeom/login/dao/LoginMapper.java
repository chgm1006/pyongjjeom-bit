/**
 * 
 */

package com.pyongjjeom.login.dao;

import java.util.Map;

import com.pyongjjeom.user.dto.Member;

/**
 * <pre>
 * com.pyongjjeom.login.dao 
 *    |_ LoginMapper.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
public interface LoginMapper {

	public int checkMemberLogin(Map<String, String> loginMap);

	public int createMember(Member user);

	public String getMemCD(String email);

	public int updateEmailAuthCD(Member member);

	public String getEmailAuthCD(String email);
}
