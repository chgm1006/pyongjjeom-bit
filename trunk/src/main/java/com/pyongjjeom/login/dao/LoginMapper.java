/**
 * 
 */

package com.pyongjjeom.login.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

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
	
	public Member getEmail(String email);

	public int insertMember(Member user);

	public String getMemCD(String email);

	public int updateEmailAuthCD(Member member);

	public int updateEmailAuthCDCheck(Member member);

	public String getEmailAuthCD(String email);

	public Member login(Member member);

	public String login(@Param("email") String email,
			@Param("passwd") String passwd);

	public int regiesterFBMember(Member member);

	public int updateFBMember(Member member);
}
