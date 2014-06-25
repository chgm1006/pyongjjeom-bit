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

import com.pyongjjeom.notice.dto.Notice;
import com.pyongjjeom.notice.service.NoticeService;
import com.pyongjjeom.test.parsing.contents.MovieGrades;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value = "boardList.do")
	public String listDo(@Valid com.pyongjjeom.notice.dto.Notice notice,
			Model model, HttpServletRequest request) {

		System.out.println("왓수?");
		List<Notice> list = noticeService.applyData();
		model.addAttribute("add", list);

		System.out.println("왓수?22222222222222222");
		return "board/boardList";
	}

	@RequestMapping(value = "write.do", method = RequestMethod.GET)
	public String insertData(@Valid Notice notice, Model model,
			HttpServletRequest request) {

		System.out.println("왓수?");
		// noticeService.insertData(notice);

		return "test/write";
	}

	@RequestMapping(value = "write_ok.do", method = RequestMethod.POST)
	public String writeOKDo(@Valid Notice notice, Model model,
			HttpServletRequest request) {

		System.out.println("왓수?");
		noticeService.insertData(notice);

		return "test/write_ok";
	}

}
