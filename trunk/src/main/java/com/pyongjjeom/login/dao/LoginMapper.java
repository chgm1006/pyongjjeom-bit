/**
 * 
 */

package com.pyongjjeom.login.dao;

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

	public int checkMemberLogin(String email);

	public int createMember(Member user);
}
