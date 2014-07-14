/**
 * 
 */

package com.pyongjjeom.postandreply.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pyongjjeom.common.NaverBook;
import com.pyongjjeom.postandreply.dao.PostAndReplyMapper;
import com.pyongjjeom.postandreply.dto.Comment;
import com.pyongjjeom.postandreply.dto.Post;
import com.pyongjjeom.postandreply.dto.PostAndContents;

/**
 * <pre>
 * com.pyongjjeom.postandreply.service 
 *    |_ PostAndReplyServiceImpl.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
@Service("postAndReplyService")
public class PostAndReplyServiceImpl implements PostAndReplyService {

	private Logger log = Logger.getLogger(this.getClass());
@Autowired
	private PostAndReplyMapper parMapper;

	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : getPost
	 * @date : 2014. 6. 18.
	 * @author : Forrest
	 * @history :
	 *          ------------------------------------------------------------------
	 *          ----- 변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2014. 6. 18. Forrest 최초 작성
	 *          ------------------------------------------------------------------
	 *          -----
	 * 
	 * @see com.pyongjjeom.postandreply.service.PostAndReplyService#getPost(java.lang.String,
	 *      java.lang.String)
	 * @param memCD
	 * @param conCD
	 * @return
	 */
	@Override
	public List<PostAndContents> getPost(String memCD) {
		return parMapper.getPost(memCD);
	}

	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : getReply
	 * @date : 2014. 6. 18.
	 * @author : Forrest
	 * @history :
	 *          ------------------------------------------------------------------
	 *          ----- 변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2014. 6. 18. Forrest 최초 작성
	 *          ------------------------------------------------------------------
	 *          -----
	 * 
	 * @see com.pyongjjeom.postandreply.service.PostAndReplyService#getReply(java.lang.String,
	 *      java.lang.String)
	 * @param memCD
	 * @param conCD
	 * @return
	 */
	@Override
	public List<Post> getReply(String memCD, String conCD) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : updatePost
	 * @date : 2014. 6. 18.
	 * @author : Forrest
	 * @history :
	 *          ------------------------------------------------------------------
	 *          ----- 변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2014. 6. 18. Forrest 최초 작성
	 *          ------------------------------------------------------------------
	 *          -----
	 * 
	 * @see com.pyongjjeom.postandreply.service.PostAndReplyService#updatePost(java.lang.String)
	 * @param postCD
	 * @return
	 */
	

	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : deletePost
	 * @date : 2014. 6. 18.
	 * @author : Forrest
	 * @history :
	 *          ------------------------------------------------------------------
	 *          ----- 변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2014. 6. 18. Forrest 최초 작성
	 *          ------------------------------------------------------------------
	 *          -----
	 * 
	 * @see com.pyongjjeom.postandreply.service.PostAndReplyService#deletePost(java.lang.String)
	 * @param postCD
	 * @return
	 */
	@Override
	public void deletePost(String postCD) {
		// TODO Auto-generated method stub
		
		parMapper.deletePost(postCD);
	
	}

	/**
	 * <PRE>
	 * 간략 : 
	 * 상세 : 
	 * </PRE>
	 * @see com.pyongjjeom.postandreply.service.PostAndReplyService#insertBookPost(com.pyongjjeom.common.NaverBook, com.pyongjjeom.postandreply.dto.Post)
	 */
	@Override
	public void insertPost(Post post) {
		
		parMapper.insertPost(post);
	}

	/**
	 * <PRE>
	 * 간략 : 
	 * 상세 : 
	 * </PRE>
	 * @see com.pyongjjeom.postandreply.service.PostAndReplyService#updatePost(java.lang.String)
	 */
	@Override
	public Post updatePost(String postCD) {
		// TODO Auto-generated method stub
		return parMapper.updatePost(postCD);
	}

	/**
	 * <PRE>
	 * 간략 : 
	 * 상세 : 
	 * </PRE>
	 * @see com.pyongjjeom.postandreply.service.PostAndReplyService#editPost(com.pyongjjeom.postandreply.dto.Post)
	 */
	@Override
	public void editPost(Post post) {
		// TODO Auto-generated method stub
		
		parMapper.editPost(post);
		
	}

	/**
	 * <PRE>
	 * 간략 : 
	 * 상세 : 
	 * </PRE>
	 * @see com.pyongjjeom.postandreply.service.PostAndReplyService#getComent(java.lang.String)
	 */
	@Override
	public List<Comment> getComent(String conCD) {
		return parMapper.getComent(conCD);
	}



}
