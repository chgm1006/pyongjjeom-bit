/**
 * 
 */

package com.pyongjjeom.postandreply.dao;

import java.util.List;

import com.pyongjjeom.postandreply.dto.Post;

/**
 * <pre>
 * com.pyongjjeom.postandreply.dao 
 *    |_ PostAndReplyMapper.java
 * 
 * </pre>
 * @date : 2014. 6. 19. 오후 12:32:43
 * @version : 
 * @author : Forrest
 */
/**
 * <pre>
 * com.pyongjjeom.postandreply.dao 
 *    |_ PostAndReplyMapper.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
public interface PostAndReplyMapper {

	public List<Post> getPost(String memCD, String conCD);

	public List<Post> getReply(String memCD, String conCD);

	public int updatePost(String postCD);

	public int deletePost(String postCD);
}
