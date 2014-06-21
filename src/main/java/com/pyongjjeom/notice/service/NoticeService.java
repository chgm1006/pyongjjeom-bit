/**
 * 
 */

package com.pyongjjeom.notice.service;

import java.util.List;

import com.pyongjjeom.notice.dto.Notice;

/**
 * <pre>
 * com.pyongjjeom.notice.service 
 *    |_ NoticeService.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
public interface NoticeService {

	public List<Notice> getAllNotices();

	public Notice getNotice(String notCD);

	public int updateNotice(String notCD);

	public int deleteNotice(String notCD);
}
