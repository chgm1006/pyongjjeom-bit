/**
 * 
 */

package com.pyongjjeom.postandreply.service;

import java.util.List;

import com.pyongjjeom.postandreply.dto.Comment;
import com.pyongjjeom.postandreply.dto.Post;
import com.pyongjjeom.postandreply.dto.PostAndContents;
import com.pyongjjeom.postandreply.dto.Reply;

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

	public void updatePost(Post post);

	public void deletePost(String postCD);

	public void insertPost(Post post);

	public List<Comment> getComent(String conCD);

	public String getPjGrade(String conCD);

	public Comment getMyComent(String conCD, String memCD);

	public List<Reply> getReplyList(String postCD);

	public void insertReply(Reply reply);

	public void updateReply(Reply reply);

	public void deleteReply(String replyCD);

}
