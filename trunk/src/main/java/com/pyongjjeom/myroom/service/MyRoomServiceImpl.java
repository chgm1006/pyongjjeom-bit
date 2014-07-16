/**
 * 
 */

package com.pyongjjeom.myroom.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pyongjjeom.myroom.dao.MyRoomMapper;
import com.pyongjjeom.postandreply.dto.Post;
import com.pyongjjeom.user.dto.Member;

/**
 * <pre>
 * com.pyongjjeom.myroom.service 
 *    |_ MyRoomServiceImpl.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
@Service("myRoomService")
public class MyRoomServiceImpl implements MyRoomService {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private MyRoomMapper myRoomMapper;

	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : getMyPost
	 * @date : 2014. 6. 18.
	 * @author : Forrest
	 * @history :
	 *          ------------------------------------------------------------------
	 *          ----- 변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2014. 6. 18. Forrest 최초 작성
	 *          ------------------------------------------------------------------
	 *          -----
	 * 
	 * @see com.pyongjjeom.myroom.service.MyRoomService#getMyPost(java.lang.String)
	 * @param memCD
	 * @return
	 */
	@Override
	public List<Post> getMyPost(String memCD) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : getFriendsComments
	 * @date : 2014. 6. 18.
	 * @author : Forrest
	 * @history :
	 *          ------------------------------------------------------------------
	 *          ----- 변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2014. 6. 18. Forrest 최초 작성
	 *          ------------------------------------------------------------------
	 *          -----
	 * 
	 * @see com.pyongjjeom.myroom.service.MyRoomService#getFriendsComments(java.lang.String,
	 *      java.lang.String)
	 * @param memCD
	 * @param friendCD
	 * @return
	 */
	@Override
	public List<Post> getFriendsComments(String memCD, String friendCD) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : getFriendsReply
	 * @date : 2014. 6. 18.
	 * @author : Forrest
	 * @history :
	 *          ------------------------------------------------------------------
	 *          ----- 변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2014. 6. 18. Forrest 최초 작성
	 *          ------------------------------------------------------------------
	 *          -----
	 * 
	 * @see com.pyongjjeom.myroom.service.MyRoomService#getFriendsReply(java.lang.String,
	 *      java.lang.String)
	 * @param memCD
	 * @param friendCD
	 * @return
	 */
	@Override
	public List<Post> getFriendsReply(String memCD, String friendCD) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * <PRE>
	 * 간략 : 
	 * 상세 : 
	 * </PRE>
	 * @see com.pyongjjeom.myroom.service.MyRoomService#insertImage(com.pyongjjeom.user.dto.Member)
	 */
	@Override
	public void insertImage(Member member) {
		// TODO Auto-generated method stub
		myRoomMapper.insertImage(member);
	}

	/**
	 * <PRE>
	 * 간략 : 
	 * 상세 : 
	 * </PRE>
	 * @see com.pyongjjeom.myroom.service.MyRoomService#updateData(java.lang.String)
	 */
	@Override
	public Member updateImage(String memcd) {
		// TODO Auto-generated method stub
		return myRoomMapper.updateImage(memcd);
	}

}
