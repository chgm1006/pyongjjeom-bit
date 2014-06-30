/**
 * 
 */

package com.pyongjjeom.login.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pyongjjeom.login.dao.LoginMapper;
import com.pyongjjeom.user.dao.UserMapper;
import com.pyongjjeom.user.dto.Member;

/**
 * <pre>
 * com.pyongjjeom.login.service 
 *    |_ LoginServiceImpl.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private LoginMapper loginMapper;

	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : checkMemberLogin
	 * @date : 2014. 6. 18.
	 * @author : Forrest
	 * @history :
	 *          ------------------------------------------------------------------
	 *          ----- 변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2014. 6. 18. Forrest 최초 작성
	 *          ------------------------------------------------------------------
	 *          -----
	 * 
	 * @see com.pyongjjeom.login.service.LoginService#checkMemberLogin(java.lang.String)
	 * @param email
	 * @return
	 */
	@Override
	public int checkMemberLogin(String email) {
		Map<String, String> loginMap = new HashMap<String, String>();
		loginMap.put("email", email);
		System.out.println((String) loginMap.get("email"));
		return loginMapper.checkMemberLogin(loginMap);
	}

	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : getMemCD
	 * @date : 2014. 6. 24.
	 * @author : Forrest
	 * @history :
	 *          ------------------------------------------------------------------
	 *          ----- 변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2014. 6. 24. Forrest 최초 작성
	 *          ------------------------------------------------------------------
	 *          -----
	 * 
	 * @see com.pyongjjeom.login.service.LoginService#getMemCD(java.lang.String)
	 * @param email
	 * @return
	 */
	@Override
	public String getMemCD(String email) {
		return loginMapper.getMemCD(email);
	}

	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : updateEmailAuthCD
	 * @date : 2014. 6. 24.
	 * @author : Forrest
	 * @history :
	 *          ------------------------------------------------------------------
	 *          ----- 변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2014. 6. 24. Forrest 최초 작성
	 *          ------------------------------------------------------------------
	 *          -----
	 * 
	 * @see com.pyongjjeom.login.service.LoginService#updateEmailAuthCD(java.lang.String)
	 * @param authCD
	 * @return
	 */
	@Override
	public int updateEmailAuthCD(Member member) {
		return loginMapper.updateEmailAuthCD(member);
	}

	@Override
	public int updateEmailAuthCDCheck(Member member) {
		return loginMapper.updateEmailAuthCDCheck(member);
	}

	@Override
	public String getEmailAuthCD(String email) {
		return loginMapper.getEmailAuthCD(email);
	}

	/**
	 * <PRE>
	 * 간략 : 
	 * 상세 : 
	 * </PRE>
	 * @see com.pyongjjeom.login.service.LoginService#insertMember(com.pyongjjeom.user.dto.Member)
	 */
	@Override
	public int insertMember(Member user) {
		// TODO Auto-generated method stub
		return loginMapper.insertMember(user);
	}

	/**
	 * <PRE>
	 * 간략 : 
	 * 상세 : 
	 * </PRE>
	 * @see com.pyongjjeom.login.service.LoginService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public String login(String email, String passwd) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * <PRE>
	 * 간략 : 
	 * 상세 : 
	 * </PRE>
	 * @see com.pyongjjeom.login.service.LoginService#login(com.pyongjjeom.user.dto.Member)
	 */
	@Override
	public Member login(Member member) {
		// TODO Auto-generated method stub
		return loginMapper.login(member);
	}

}
