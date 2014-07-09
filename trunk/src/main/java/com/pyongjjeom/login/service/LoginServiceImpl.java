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
	 * 
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
	 * 
	 * @see com.pyongjjeom.login.service.LoginService#login(java.lang.String,
	 *      java.lang.String)
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
	 * 
	 * @see com.pyongjjeom.login.service.LoginService#login(com.pyongjjeom.user.dto.Member)
	 */
	@Override
	public Member login(Member member) {
		// TODO Auto-generated method stub
		return loginMapper.login(member);
	}

	/**
	 * <pre>
	 * 1. 개요 : FaceBook 회원 정보 가입.
	 * 2. 처리내용 : FaceBook 회원 정보 가입하기.
	 * </pre>
	 * 
	 * @Method Name : regiesterFBMember
	 * @date : 2014. 7. 9.
	 * @author : Forrest
	 * @history :
	 *          ------------------------------------------------------------------
	 *          ----- 변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2014. 7. 9. Forrest 최초 작성
	 *          ------------------------------------------------------------------
	 *          -----
	 * 
	 * @see com.pyongjjeom.login.service.LoginService#regiesterFBMember(com.pyongjjeom.user.dto.Member)
	 * @param member
	 *          Facebook에서 전달받은 데이터.
	 * @return 저장된 데이터의 갯수
	 */
	@Override
	public int regiesterFBMember(Member member) {
		// TODO Auto-generated method stub
		return loginMapper.regiesterFBMember(member);
	}

	/**
	 * <pre>
	 * 1. 개요 : Facebook 회원 정보 업데이터.
	 * 2. 처리내용 : Facebook 회원 정보 업데이터.
	 * </pre>
	 * 
	 * @Method Name : updateFBMember
	 * @date : 2014. 7. 9.
	 * @author : Forrest
	 * @history :
	 *          ------------------------------------------------------------------
	 *          ----- 변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2014. 7. 9. Forrest 최초 작성
	 *          ------------------------------------------------------------------
	 *          -----
	 * 
	 * @see com.pyongjjeom.login.service.LoginService#updateFBMember(com.pyongjjeom.user.dto.Member)
	 * @param member
	 *          Facebook 에서 전달받은 변경된 회원 정보.
	 * @return 업데이트 된 회원 갯수.
	 */
	@Override
	public int updateFBMember(Member member) {
		// TODO Auto-generated method stub
		return loginMapper.updateFBMember(member);
	}

}
