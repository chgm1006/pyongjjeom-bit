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
package com.pyongjjeom.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;









import com.pyongjjeom.notice.dao.NoticeMapper;
import com.pyongjjeom.notice.dto.Notice;
import com.pyongjjeom.notice.dto.NoticeCode;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeMapper noticeMapper;

	/**
	 * <PRE>
	 * 간략 : 
	 * 상세 :
	 * </PRE>
	 * 
	 * @see com.pyongjjeom.notice.service.NoticeService#insertData(com.pyongjjeom.notice.dto.Notice)
	 */
	@Override
	public void insertData(Notice notice) {
		// TODO Auto-generated method stub
		noticeMapper.insertData(notice);

	}

	/**
	 * <PRE>
	 * 간략 : 입력하기
	 * 상세 : 
	 * </PRE>
	 * @see com.pyongjjeom.notice.service.NoticeService#getAllNoticeDatas()
	 */
	@Override
	public List<Notice> getAllNoticeDatas() {
		// TODO Auto-generated method stub
		
		return noticeMapper.getAllNoticeDatas();
	}

	/**
	 * <PRE>
	 * 간략 : 이벤트데이터를 List 형식으로 불러오기 
	 * 상세 : 
	 * </PRE>
	 * @see com.pyongjjeom.notice.service.NoticeService#deleteData(com.pyongjjeom.notice.dto.Notice)
	 */
	@Override
	public void deleteData(String notCD) {
		// TODO Auto-generated method stub
		
		noticeMapper.deleteData(notCD);
		
		
		
	}

	/**
	 * <PRE>
	 * 간략 : 삭제하기 (notCD에 해당하는 데이터 삭제)
	 * 상세 : 
	 * </PRE>
	 * @see com.pyongjjeom.notice.service.NoticeService#getCode()
	 */
	@Override
	public List<NoticeCode> getCode() {
		// TODO Auto-generated method stub
		List<NoticeCode> code = noticeMapper.getCode();
		
		return code;
	}

	/**
	 * <PRE>
	 * 간략 : 코드값을 가지고오기
	 * 상세 : 셀렉트박스인 이벤트 / 행사를 구분하기위해서   공통코드인 code, codenm을 불러오기위해 사용
	 * </PRE>
	 * @see com.pyongjjeom.notice.service.NoticeService#editData(com.pyongjjeom.notice.dto.Notice)
	 */
	@Override
	public void editData(Notice notice) {
		// TODO Auto-generated method stub
		
		noticeMapper.editData(notice);
		
	}

	/**
	 * <PRE>
	 * 간략 : 수정하기
	 * 상세 : 
	 * </PRE>
	 * @see com.pyongjjeom.notice.service.NoticeService#updateData(java.lang.String)
	 */
	@Override
	public Notice updateData(String notCD) {
		// TODO Auto-generated method stub
		return noticeMapper.updateData(notCD);
	}

	/**
	 * <PRE>
	 * 간략 : notCD 값 가지고오기
	 * 상세 : 수정하기를 클릭시 그에 해당하는 데이터를 불러오기 위해서는 notCD가 필요
	 *       그래서 그값을 불러오기위해 사용
	 * </PRE>
	 * @see com.pyongjjeom.notice.service.NoticeService#getSystemNoticeDatas()
	 */
	@Override
	public List<Notice> getSystemNoticeDatas() {
		// TODO Auto-generated method stub
		return noticeMapper.getSystemNoticeDatas();
	}

	/**
	 * <PRE>
	 * 간략 : 시스템데이터를 List 형식으로 불러오기
	 * 상세 : 
	 * </PRE>
	 * @see com.pyongjjeom.notice.service.NoticeService#getEventNoticeDatas()
	 */
	@Override
	public List<Notice> getEventNoticeDatas() {
		// TODO Auto-generated method stub
		return noticeMapper.getEventNoticeDatas();
	}

	/**
	 * <PRE>
	 * 간략 : 이벤트데이터를 List 형식으로 불러오기
	 * 상세 : 
	 * </PRE>
	 * @see com.pyongjjeom.notice.service.NoticeService#getDeleteNoticeDatas()
	 */
	@Override
	public List<Notice> getDeleteNoticeDatas() {
		// TODO Auto-generated method stub
		return noticeMapper.getDeleteNoticeDatas();
	}

	/**
	 * <PRE>
	 * 간략 : 
	 * 상세 : 
	 * </PRE>
	 * @see com.pyongjjeom.notice.service.NoticeService#paging()
	 */
	@Override
	public String paging() {
		// TODO Auto-generated method stub
		return noticeMapper.paging();
	}

	

	/**
	 * <PRE>
	 * 간략 : 삭제된데이터를 List 형식으로 불러오기
	 * 상세 : 
	 * </PRE>
	 * @see com.pyongjjeom.notice.service.NoticeService#getData(com.pyongjjeom.notice.dto.Notice)
	 */




}