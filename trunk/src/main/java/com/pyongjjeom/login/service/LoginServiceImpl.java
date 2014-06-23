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
		// TODO Auto-generated method stub
		Map<String, String> loginMap = new HashMap<String, String>();
		loginMap.put("email", email);
		System.out.println((String)loginMap.get("email"));
		return loginMapper.checkMemberLogin(loginMap);
	}

	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : createMember
	 * @date : 2014. 6. 18.
	 * @author : Forrest
	 * @history :
	 *          ------------------------------------------------------------------
	 *          ----- 변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2014. 6. 18. Forrest 최초 작성
	 *          ------------------------------------------------------------------
	 *          -----
	 * 
	 * @see com.pyongjjeom.login.service.LoginService#createMember(com.pyongjjeom.user.dto.Member)
	 * @param user
	 * @return
	 */
	@Override
	public int createMember(Member user) {
		// TODO Auto-generated method stub
		return loginMapper.createMember(user);
	}

}
