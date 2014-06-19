/**
 * 
 */

package com.pyongjjeom.friends.dao;

import java.util.List;

import com.pyongjjeom.friends.dto.Friends;

/**
 * <pre>
 * com.pyongjjeom.friends.dao 
 *    |_ FriendsMapper.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
public interface FriendsMapper {
	public List<Friends> getFriendList(String memCD);

	public int addFriendToMemberList(String memCD, String friendCD);

	public int deleteFriend(String memCD);
}
