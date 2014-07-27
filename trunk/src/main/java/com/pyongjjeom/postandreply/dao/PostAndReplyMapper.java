/**
 * 
 */

package com.pyongjjeom.postandreply.dao;

import java.util.List;

import com.pyongjjeom.postandreply.dto.Comment;
import com.pyongjjeom.postandreply.dto.Post;
import com.pyongjjeom.postandreply.dto.PostAndContents;
import com.pyongjjeom.postandreply.dto.Reply;

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

	public List<PostAndContents> getPost(String memCD);

	public List<Post> getReply(String memCD, String conCD);

	public Post updatePost(String postCD);

	public void deletePost(String postCD);

	public void updatePost(Post post);

	public void insertPost(Post post);

	public List<Comment> getComent(String conCD);

	public String getPjGrade(String conCD);

	public Comment getMyComent(Post post);

	public List<Reply> getReplyList(String postCD);

	public void insertReply(Reply reply);

	public void updateReply(Reply reply);

	public void deleteReply(String replyCD);

	public void deleteReplyList(String postCD);

}
