/**
 * 
 */

package com.pyongjjeom.postandreply.service;

import java.util.List;

import com.pyongjjeom.common.NaverBook;
import com.pyongjjeom.notice.dto.Notice;
import com.pyongjjeom.postandreply.dto.Post;

/**
 * <pre>
 * com.pyongjjeom.postandreply.service 
 *    |_ PostAndReplyService.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
public interface PostAndReplyService {

	public List<Post> getPost(String memCD);

	public List<Post> getReply(String memCD, String conCD);

	public Post updatePost(String postCD);
	
	public void editPost (Post post);

	public int deletePost(String postCD);

	public void insertBookPost(Post post);

	
}
