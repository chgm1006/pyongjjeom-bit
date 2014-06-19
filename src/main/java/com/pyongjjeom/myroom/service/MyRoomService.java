/**
 * 
 */

package com.pyongjjeom.myroom.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.pyongjjeom.postandreply.dto.Post;

/**
 * <pre>
 * com.pyongjjeom.myroom.service 
 *    |_ MyRoomService.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
public interface MyRoomService {

	public List<Post> getMyPost(String memCD);

	public List<Post> getFriendsComments(String memCD, String friendCD);

	public List<Post> getFriendsReply(String memCD, String friendCD);
}
