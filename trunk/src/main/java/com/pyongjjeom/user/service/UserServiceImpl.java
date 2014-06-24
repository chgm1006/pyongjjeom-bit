/**
 * 
 */

package com.pyongjjeom.user.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.pyongjjeom.user.dao.UserMapper;
import com.pyongjjeom.user.dto.Member;
import com.pyongjjeom.user.service.UserService;

/**
 * <pre>
 * com.pyongjjeom.user.service 
 *    |_ UserServiceImpl.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	private Logger log = Logger.getLogger(this.getClass());
	private UserMapper userMapper;

	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : getMemberInfo
	 * @date : 2014. 6. 19.
	 * @author : Forrest
	 * @history :
	 *          ------------------------------------------------------------------
	 *          ----- 변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2014. 6. 19. Forrest 최초 작성
	 *          ------------------------------------------------------------------
	 *          -----
	 * 
	 * @see com.pyongjjeom.user.service.UserService#getMemberInfo()
	 * @return
	 */
	@Override
	public Member getMemberInfo(String memCd) {
		// TODO Auto-generated method stub
		return userMapper.getMemberInfo(memCd);
	}

	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : checkMemberID
	 * @date : 2014. 6. 19.
	 * @author : Forrest
	 * @history :
	 *          ------------------------------------------------------------------
	 *          ----- 변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2014. 6. 19. Forrest 최초 작성
	 *          ------------------------------------------------------------------
	 *          -----
	 * 
	 * @see com.pyongjjeom.user.service.UserService#checkMemberID()
	 * @return
	 */
	@Override
	public Member checkMemberID(String memCd) {
		// TODO Auto-generated method stub
		return userMapper.checkMemberID(memCd);
	}

	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : updateMemberInfo
	 * @date : 2014. 6. 19.
	 * @author : Forrest
	 * @history :
	 *          ------------------------------------------------------------------
	 *          ----- 변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2014. 6. 19. Forrest 최초 작성
	 *          ------------------------------------------------------------------
	 *          -----
	 * 
	 * @see com.pyongjjeom.user.service.UserService#updateMemberInfo()
	 * @return
	 */
	@Override
	public int updateMemberInfo() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : deleteMember
	 * @date : 2014. 6. 19.
	 * @author : Forrest
	 * @history :
	 *          ------------------------------------------------------------------
	 *          ----- 변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2014. 6. 19. Forrest 최초 작성
	 *          ------------------------------------------------------------------
	 *          -----
	 * 
	 * @see com.pyongjjeom.user.service.UserService#deleteMember()
	 * @return
	 */
	@Override
	public int deleteMember() {
		// TODO Auto-generated method stub
		return 0;
	}

}