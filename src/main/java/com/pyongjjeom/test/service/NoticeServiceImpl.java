/**
 * 0. Project  : XXXX 프로젝트
 *
 * 1. FileName : NoticeServiceImpl.java
 * 2. Package : com.pyongjjeom.test.service
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
package com.pyongjjeom.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pyongjjeom.test.dao.NoticeDao;
import com.pyongjjeom.test.dao.NoticeMapper;
import com.pyongjjeom.test.dto.Notice;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeMapper noticeMapper;

	@Autowired
	private NoticeDao noticeDao;

	/**
	 * <PRE>
	 * 간략 : 
	 * 상세 :
	 * </PRE>
	 * 
	 * @see com.pyongjjeom.test.service.NoticeService#insertData(com.pyongjjeom.test.dto.Notice)
	 */
	@Override
	public void insertData(Notice notice) {
		// TODO Auto-generated method stub
		noticeMapper.insertData(notice);

	}

}