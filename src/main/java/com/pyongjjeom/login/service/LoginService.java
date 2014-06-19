/**
 * 
 */

package com.pyongjjeom.login.service;

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
}
