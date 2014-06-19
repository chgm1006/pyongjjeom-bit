/**
 * 
 */

package com.pyongjjeom.postandreply.service;

import java.util.List;

import org.apache.log4j.Logger;

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

	public List<Post> getPost(String memCD, String conCD);

	public List<Post> getReply(String memCD, String conCD);

	public int updatePost(String postCD);

	public int deletePost(String postCD);
}
