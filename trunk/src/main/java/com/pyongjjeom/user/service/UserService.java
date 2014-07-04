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
	public Member getMemberInfo(String memCD);

	public Member checkMemberID(String memCD);

	public int updateMemberInfo();

	public int deleteMember();
	
	void upDateData(Member member);
}
