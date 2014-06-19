/**
 * 
 */

package com.pyongjjeom.notice.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.pyongjjeom.notice.dto.Notice;
import com.pyongjjeom.user.dto.Member;

/**
 * <pre>
 * com.pyongjjeom.notice.service 
 *    |_ NoticeServiceImpl.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
public class NoticeServiceImpl implements NoticeService {

	private Logger log = Logger.getLogger(this.getClass());
	private NoticeService notice;
	private Member member = new Member();

	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : getAllNotices
	 * @date : 2014. 6. 18.
	 * @author : Forrest
	 * @history :
	 *          ------------------------------------------------------------------
	 *          ----- 변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2014. 6. 18. Forrest 최초 작성
	 *          ------------------------------------------------------------------
	 *          -----
	 * 
	 * @see com.pyongjjeom.notice.service.NoticeService#getAllNotices()
	 * @return
	 */
	@Override
	public List<Notice> getAllNotices() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : getNotice
	 * @date : 2014. 6. 18.
	 * @author : Forrest
	 * @history :
	 *          ------------------------------------------------------------------
	 *          ----- 변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2014. 6. 18. Forrest 최초 작성
	 *          ------------------------------------------------------------------
	 *          -----
	 * 
	 * @see com.pyongjjeom.notice.service.NoticeService#getNotice(java.lang.String)
	 * @param notCD
	 * @return
	 */
	@Override
	public Notice getNotice(String notCD) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : updateNotice
	 * @date : 2014. 6. 18.
	 * @author : Forrest
	 * @history :
	 *          ------------------------------------------------------------------
	 *          ----- 변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2014. 6. 18. Forrest 최초 작성
	 *          ------------------------------------------------------------------
	 *          -----
	 * 
	 * @see com.pyongjjeom.notice.service.NoticeService#updateNotice(java.lang.String)
	 * @param notCD
	 * @return
	 */
	@Override
	public int updateNotice(String notCD) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : deleteNotice
	 * @date : 2014. 6. 18.
	 * @author : Forrest
	 * @history :
	 *          ------------------------------------------------------------------
	 *          ----- 변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2014. 6. 18. Forrest 최초 작성
	 *          ------------------------------------------------------------------
	 *          -----
	 * 
	 * @see com.pyongjjeom.notice.service.NoticeService#deleteNotice(java.lang.String)
	 * @param notCD
	 * @return
	 */
	@Override
	public int deleteNotice(String notCD) {
		// TODO Auto-generated method stub
		return 0;
	}

}
