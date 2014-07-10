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
	
	public Member getEmail1(String email);

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

	
	public Member getEmail(String email);

	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : getMemCDbyFBID
	 * @date : 2014. 7. 10.
	 * @author : Forrest
	 * @history :
	 *          ------------------------------------------------------------------
	 *          ----- 변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2014. 7. 10. Forrest 최초 작성
	 *          ------------------------------------------------------------------
	 *          -----
	 * 
	 * @param fbId
	 * @return
	 */
	public String getMemCDbyFBID(String fbId);

	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : getMemberInfoByFBID
	 * @date : 2014. 7. 10.
	 * @author : Forrest
	 * @history :
	 *          ------------------------------------------------------------------
	 *          ----- 변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2014. 7. 10. Forrest 최초 작성
	 *          ------------------------------------------------------------------
	 *          -----
	 * 
	 * @param fbId
	 * @return
	 */
	public Member getMemberInfoByFBID(String fbId);

}
