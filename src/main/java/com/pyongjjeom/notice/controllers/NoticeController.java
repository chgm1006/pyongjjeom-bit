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

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pyongjjeom.common.code.DBCode;
import com.pyongjjeom.notice.dto.Notice;
import com.pyongjjeom.notice.dto.NoticeCode;
import com.pyongjjeom.notice.service.NoticeService;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeService;

	private DBCode dc = new DBCode(); // DBCode 정의
	private SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	int row;

	@RequestMapping(value = "allList.do")
	public String allList(@Valid Notice notice, Model model, HttpServletRequest request) {

		List<Notice> list = noticeService.getAllNoticeDatas();

		for (Notice noti : list) {
			noti.setFormatUpdatedate(df2.format(noti.getUpdatedate()));
		}
		model.addAttribute("add", list);

		row = 0;
		return "notice/boardList";
	}

	@RequestMapping(value = "systemList.do")
	public String systemList(@Valid Notice notice, Model model, HttpServletRequest request) {

		List<Notice> list = noticeService.getSystemNoticeDatas();

		for (Notice noti : list) {
			noti.setFormatUpdatedate(df2.format(noti.getUpdatedate()));
		}

		model.addAttribute("category", "SM");
		model.addAttribute("add", list);
		row = 0;
		return "notice/boardList";
	}

	@RequestMapping(value = "eventList.do")
	public String eventList(@Valid Notice notice, Model model, HttpServletRequest request) {

		List<Notice> list = noticeService.getEventNoticeDatas();

		for (Notice noti : list) {
			noti.setFormatUpdatedate(df2.format(noti.getUpdatedate()));
		}
		model.addAttribute("category", "EV");
		model.addAttribute("add", list);
		row = 0;
		return "notice/boardList";
	}

	@RequestMapping(value = "deleteList.do")
	public String deleteList(@Valid Notice notice, Model model, HttpServletRequest request) {

		List<Notice> list = noticeService.getDeleteNoticeDatas();

		for (Notice noti : list) {
			noti.setFormatUpdatedate(df2.format(noti.getUpdatedate()));
		}

		model.addAttribute("add", list);
		row = 0;
		return "notice/boardList";
	}

	@RequestMapping(value = "boardList.do")
	public String listDo(@Valid com.pyongjjeom.notice.dto.Notice notice, Model model, HttpServletRequest request) {
		row = 0;
		System.out.println("AAAA");
		IssueDbtoView(notice);

		List<Notice> list = noticeService.getAllNoticeDatas();

		for (Notice noti : list) {
			noti.setFormatUpdatedate(df2.format(noti.getUpdatedate()));
		}

		System.out.println();
		model.addAttribute("add", list);

		return "notice/boardList";
	}

	@RequestMapping(value = "write.do", method = RequestMethod.GET)
	public String insertData(@Valid Notice notice, Model model, HttpServletRequest request) {

		issueViewToDb(notice);

		List<NoticeCode> code = noticeService.getCode();
		System.out.println(code.size());
		model.addAttribute("code", code);

		return "notice/write";
	}

	@RequestMapping(value = "write_ok.do", method = RequestMethod.POST)
	public String writeOKDo(@Valid Notice notice, Model model, HttpServletRequest request) {
		String code = (String) request.getParameter("code");

		IssueDbtoView(notice);
		String notCD = dc.getNoticeCD(code); // 값이 Static이라 한번 호출할때마다 변함
		notice.setNotCD(notCD);

		System.out.println(request.getParameter("code"));

		notice.setCategory(request.getParameter("code"));

		noticeService.insertData(notice);
		System.out.println(notice.toString());

		return "redirect:boardList.do";
	}

	@RequestMapping(value = "edit.do", method = RequestMethod.GET)
	public String editDo(@Valid Notice notice, Model model, HttpServletRequest request) {

		System.out.println(request.getParameter("notCD"));

		Notice newNotice = noticeService.updateData(request.getParameter("notCD"));
		issueUpdateDbtoView(newNotice);
		System.out.println(newNotice);

		model.addAttribute("nn", newNotice);

		List<NoticeCode> code = noticeService.getCode();
		System.out.println(code.size());
		model.addAttribute("code", code);

		System.out.println(notice.toString());

		return "notice/edit";

	}

	@RequestMapping(value = "editok.do", method = RequestMethod.POST)
	public String editOKDo(@Valid Notice notice, Model model, HttpServletRequest request) {
		IssueDbtoView(notice);

		notice.setCategory(request.getParameter("code"));

		System.out.println(notice.toString());
		noticeService.editData(notice);

		request.getParameter("notCD");

		System.out.println(notice.toString());

		return "redirect:boardList.do";

	}

	@RequestMapping(value = "delete.do", method = RequestMethod.GET)
	public String deleteOKDo(@Valid Notice notice, Model model, HttpServletRequest request)

	{

		request.getParameter("notCD");

		noticeService.deleteData(request.getParameter("notCD"));

		return "redirect:boardList.do";
	}

	/*
	 * 맨처음 글을쓸때 체크해주는것
	 */
	public Notice issueViewToDb(Notice notice) {

		String dbIssue = notice.getIssue();
		dbIssue = dbIssue.replaceAll("'", "`");
		notice.setIssue(dbIssue);

		return notice;
	}

	/*
	 * view에서 DB로 넘어갈때 체크해주는 것
	 */
	public Notice IssueDbtoView(Notice notice) {
		String viewIssue = notice.getIssue();
		viewIssue = viewIssue.replaceAll("`", "'").replaceAll("\r\n", "<br>").replaceAll("\u0020", "&nbsp;");
		notice.setIssue(viewIssue);

		return notice;
	}

	/*
	 * 수정하기를 클릭햇을때 DB에서 view로 넘어올경우 br이 그대로넘어오므로 바꿔줘야함
	 */
	public Notice issueUpdateDbtoView(Notice newnotice) {

		String viewIssue = newnotice.getIssue();
		viewIssue = viewIssue.replaceAll("<br>", "\r\n");
		newnotice.setIssue(viewIssue);

		return newnotice;
	}

	@RequestMapping("/ajaxVeiw.do")
	public void ajaxView(@RequestParam Map<String, Object> paramMap, Model model) {

	}

	@RequestMapping(value = "listJson.do", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> listJson(ModelMap model, HttpServletRequest request) {
		// requestbody를 못받는다. 그래서 이렇게사용
		String category = (String) request.getParameter("category");
		if (category.equals("book") || category.equals("movie")) {
			System.out.println("aaaaa");
			category = "";
		}
		// 검색을햇을 때 book, movie 일때 는 category가 겹치므로,
		// 이와같은 방법을 사용함 . 임시방편이므로 나중에 고치길 요망함
		System.out.println("name = " + category);

		row = row + 5;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("row", row);
		map.put("category", category);

		System.out.println("33333333333333333333");

		List<Notice> list = noticeService.getMoreNoticeList(map);

		for (Notice noti : list) {
			noti.setFormatUpdatedate(df2.format(noti.getUpdatedate()));
		}
		model.put("notice", list);

		return model;

	}

}// System.out.println("JSON 테스트 결과: " + noticeService.getMoreMoreList(map));
