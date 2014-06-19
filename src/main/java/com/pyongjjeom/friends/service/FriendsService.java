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
 *    |_ FriendsService.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
public interface FriendsService {
	public List<Friends> getFriendList(String memCD);

	public int addFriendToMemberList(String memCD, String friendCD);

	public int deleteFriend(String memCD);
}
