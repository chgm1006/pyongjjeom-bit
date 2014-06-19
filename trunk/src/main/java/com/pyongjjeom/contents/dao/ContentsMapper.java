/**
 * 
 */

package com.pyongjjeom.contents.dao;

import java.util.List;

import com.pyongjjeom.contents.dto.Content;

/**
 * <pre>
 * com.pyongjjeom.contents.dao 
 *    |_ ContentsMapper.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
public interface ContentsMapper {
	public Content getContents();

	public List<Content> getContentDetail(String conCD);
}
