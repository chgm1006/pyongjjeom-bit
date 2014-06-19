/**
 * 
 */

package com.pyongjjeom.notice.dao;

import java.util.List;

import org.apache.log4j.Logger;

import com.pyongjjeom.notice.dto.Notice;

/**
 * <pre>
 * com.pyongjjeom.notice.dao 
 *    |_ NoticeMapper.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
public interface NoticeMapper {

	public List<Notice> getAllNotices();

	public Notice getNotice(String notCD);

	public int updateNotice(String notCD);

	public int deleteNotice(String notCD);
}
