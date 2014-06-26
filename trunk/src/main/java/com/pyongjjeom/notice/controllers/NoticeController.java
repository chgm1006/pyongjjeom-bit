/**
 * 0. Project  : XXXX 프로젝트
 *
 * 1. FileName : NoticeController.java
 * 2. Package : com.pyongjjeom.test.controllers
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
package com.pyongjjeom.notice.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mysql.fabric.Response;
import com.pyongjjeom.common.code.DBCode;
import com.pyongjjeom.notice.dto.Notice;
import com.pyongjjeom.notice.dto.NoticeCode;
import com.pyongjjeom.notice.service.NoticeService;
import com.pyongjjeom.test.parsing.contents.MovieGrades;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeService;

	private DBCode dc = new DBCode();                //DBCode 정의

	@RequestMapping(value = "boardList.do")
	public String listDo(@Valid com.pyongjjeom.notice.dto.Notice notice,
			Model model, HttpServletRequest request) {

		System.out.println("왓수?");
		List<Notice> list = noticeService.applyData();
		model.addAttribute("add", list);
	

		System.out.println("왓수?22222222222222222"+list.toString());
		return "notice/boardList";
	}

	
	
	@RequestMapping(value = "write.do", method = RequestMethod.GET)
	public String insertData(@Valid Notice notice, Model model,
			HttpServletRequest request) {

		System.out.println("왓수?");
		// noticeService.insertData(notice);
		List<NoticeCode> code = noticeService.getCode();
		System.out.println(code.size());
		model.addAttribute("code", code);

		return "notice/write";
	}

	@RequestMapping(value = "write_ok.do", method = RequestMethod.POST)
	public String writeOKDo(@Valid Notice notice, Model model,
			HttpServletRequest request) {
		
		String notCD = dc.getNoticeCD("no");   //값이 Static이라 한번 호출할때마다 변함
		notice.setNotCD(notCD);
		
		System.out.println(request.getParameter("code"));
		
		notice.setCategory(request.getParameter("code"));
	
		
		noticeService.insertData(notice);
		System.out.println(notice.toString());

		return "notice/write_ok";
	}

	@RequestMapping(value = "edit.do", method = RequestMethod.GET)
	public String editOkDo(@Valid Notice notice, Model model,HttpServletRequest request)
	{
		System.out.println(request.getParameter("notCD"));
		Notice newNotice = noticeService.updateData(request.getParameter("notCD"));
		System.out.println(newNotice);
		model.addAttribute("nn", newNotice);
		
		
		List<NoticeCode> code = noticeService.getCode();
		System.out.println(code.size());
		model.addAttribute("code", code);
		
		
		
		System.out.println(notice.toString());		
		
		
		return "notice/edit";
		
	}
	
	@RequestMapping(value = "editok.do", method = RequestMethod.POST)
	public String editDo(@Valid Notice notice, Model model,HttpServletRequest request)
	{
		
	
		notice.setCategory(request.getParameter("code"));
	
		System.out.println(notice.toString());
		noticeService.editData(notice);

		System.out.println(notice.toString());
		

		return "notice/edit_ok";
		
	}
	
	
	
	
	@RequestMapping(value = "delete.do", method = RequestMethod.GET)
	public String deleteOKDo(@Valid Notice notice, Model model,HttpServletRequest request) 
	
	{
		
		
		request.getParameter("notCD");

		System.out.println("삭제할거야??");
		
		noticeService.deleteData(request.getParameter("notCD"));

		return "notice/delete_ok";
	}

}
