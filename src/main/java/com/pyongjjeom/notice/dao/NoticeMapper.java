/**
 * 0. Project  : XXXX 프로젝트
 *
 * 1. FileName : NoticeDao.java
 * 2. Package : com.pyongjjeom.test.dao
 * 3. Comment : 
 * 4. 작성자  : Kimyt
 * 5. 작성일  : 2014. 6. 20. 
 * 6. 변경이력 : 
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    Kimyt : 2014. 6. 20. :            : 신규 개발.
 */

/*
 * Copyright yysvip.tistory.com.,LTD.
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information
 * of yysvip.tistory.com.,LTD. ("Confidential Information").
 */
package com.pyongjjeom.notice.dao; 

import java.util.List;

import com.pyongjjeom.notice.dto.Notice;


public interface NoticeMapper {
	
	void insertData(Notice notice);
	
	List <Notice> applyData();
	
}