/**
 * 
 */

package com.pyongjjeom.contents.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.pyongjjeom.contents.dto.Content;

/**
 * <pre>
 * com.pyongjjeom.contents.service 
 *    |_ ContentsService.java
 * 
 * </pre>
 * 
 * @date : 2014. 6. 17. 오후 9:03:59
 * @version :
 * @author : Forrest
 */
public interface ContentService {
	Logger logger = (Logger) Logger.getLogger(ContentService.class);
	
	public Content getContents();
	
	public List<Content> getContentDetail(String conCD);
}
