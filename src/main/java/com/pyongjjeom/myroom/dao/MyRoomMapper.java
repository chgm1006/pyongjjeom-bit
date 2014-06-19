/**
 * 
 */

package com.pyongjjeom.myroom.dao;

import java.util.List;

import com.pyongjjeom.postandreply.dto.Post;

/**
 * <pre>
 * com.pyongjjeom.myroom.dao 
 *    |_ MyRoomMapper.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
public interface MyRoomMapper {

	public List<Post> getMyPost(String memCD);

	public List<Post> getFriendsComments(String memCD, String friendCD);

	public List<Post> getFriendsReply(String memCD, String friendCD);
}
