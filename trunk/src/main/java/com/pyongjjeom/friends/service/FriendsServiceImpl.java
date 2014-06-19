/**
 * 
 */

package com.pyongjjeom.friends.service; 

import java.util.List;

import org.apache.log4j.Logger;

import com.pyongjjeom.friends.dto.Friends;

/**
 * <pre>
 * com.pyongjjeom.friends.service 
 *    |_ FriendsServiceImpl.java
 * 
 * </pre>
 * @version : 
 * @author : Forrest
 */
public class FriendsServiceImpl implements FriendsService {

	private Logger log = Logger.getLogger(this.getClass());

	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : getFriendList
	 * @date : 2014. 6. 18.
	 * @author : Forrest
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2014. 6. 18.		Forrest				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @see com.pyongjjeom.friends.service.FriendsService#getFriendList(java.lang.String)
	 * @param memCD
	 * @return
	 */
	@Override
	public List<Friends> getFriendList(String memCD) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : addFriendToMemberList
	 * @date : 2014. 6. 18.
	 * @author : Forrest
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2014. 6. 18.		Forrest				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @see com.pyongjjeom.friends.service.FriendsService#addFriendToMemberList(java.lang.String, java.lang.String)
	 * @param memCD
	 * @param friendCD
	 * @return
	 */
	@Override
	public int addFriendToMemberList(String memCD, String friendCD) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : deleteFriend
	 * @date : 2014. 6. 18.
	 * @author : Forrest
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2014. 6. 18.		Forrest				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @see com.pyongjjeom.friends.service.FriendsService#deleteFriend(java.lang.String)
	 * @param memCD
	 * @return
	 */
	@Override
	public int deleteFriend(String memCD) {
		// TODO Auto-generated method stub
		return 0;
	}

}
