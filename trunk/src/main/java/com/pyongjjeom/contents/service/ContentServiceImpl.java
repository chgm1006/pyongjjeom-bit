/**
 * 
 */

package com.pyongjjeom.contents.service; 

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pyongjjeom.contents.dao.ContentsMapper;
import com.pyongjjeom.contents.dto.Content;

/**
 * <pre>
 * com.pyongjjeom.contents.service 
 *    |_ ContentServiceImpl.java
 * 
 * </pre>
 * @version : 
 * @author : Forrest
 */
@Service("contentService")
public class ContentServiceImpl implements ContentService {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private ContentsMapper contentsMapper;
	

	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : getContents
	 * @date : 2014. 6. 18.
	 * @author : Forrest
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2014. 6. 18.		Forrest				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @see com.pyongjjeom.contents.service.ContentService#getContents()
	 * @return
	 */
	@Override
	public Content getContents() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : getContentDetail
	 * @date : 2014. 6. 18.
	 * @author : Forrest
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2014. 6. 18.		Forrest				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @see com.pyongjjeom.contents.service.ContentService#getContentDetail(java.lang.String)
	 * @param conCD
	 * @return
	 */
	@Override
	public List<Content> getContentDetail(String conCD) {
		// TODO Auto-generated method stub
		return null;
	}

}
