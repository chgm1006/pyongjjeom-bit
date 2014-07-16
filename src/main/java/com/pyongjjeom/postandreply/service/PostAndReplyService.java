/**
 * 
 */

package com.pyongjjeom.postandreply.service;

import java.util.List;

import com.pyongjjeom.postandreply.dto.Comment;
import com.pyongjjeom.postandreply.dto.Post;
import com.pyongjjeom.postandreply.dto.PostAndContents;

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

	public List<PostAndContents> getPost(String memCD);

	public List<Post> getReply(String memCD, String conCD);

	public Post updatePost(String postCD);
	
	public void editPost (Post post);

	public void deletePost(String postCD);

	public void insertPost(Post post);

	public List<Comment> getComent(String conCD);

	public String getPjGrade(String conCD);

	public Comment getMyComent(String conCD, String memCD);

	
}
