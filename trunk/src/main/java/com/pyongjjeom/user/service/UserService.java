/**
 * 
 */

package com.pyongjjeom.user.service;

import com.pyongjjeom.user.dto.Member;

/**
 * <pre>
 * com.pyongjjeom.user.service 
 *    |_ UserService.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
public interface UserService {
	public Member getMemberInfo();

	public Member checkMemberID();

	public int updateMemberInfo();

	public int deleteMember();
}
