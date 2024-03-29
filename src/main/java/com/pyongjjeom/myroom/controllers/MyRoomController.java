/**
 * 
 */

package com.pyongjjeom.myroom.controllers;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pyongjjeom.myroom.service.MyRoomService;
import com.pyongjjeom.postandreply.dto.PostAndContents;
import com.pyongjjeom.postandreply.dto.Reply;
import com.pyongjjeom.postandreply.service.PostAndReplyService;
import com.pyongjjeom.user.dto.Member;
import com.pyongjjeom.user.service.UserService;

/**
 * <pre>
 * com.pyongjjeom.myroom.controller 
 *    |_ MyRoomController.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
@Controller
public class MyRoomController {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private PostAndReplyService parService;

	@Autowired
	private UserService userService;

	@Autowired
	private MyRoomService myRoomService;

	SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@RequestMapping(value = "myRoom.do")
	public String listDo(Model model, HttpServletRequest request, HttpSession httpSession) {

		Member member = (Member) httpSession.getAttribute("member");
		List<PostAndContents> postList = parService.getPost(member.getMemCD());
		for (PostAndContents post : postList) {
			post.setMemGradeInt((int) post.getMemGrade());
			post.setFormatUpdateDate(df2.format(post.getUpdateDate()));
		}
		if (member.getImgPath() == null || member.getImgPath().equals("")) {
			member.setImgPath("/resources/img/empty.jpg");
		}

		model.addAttribute("user", member);
		boolean myRoom = true;
		model.addAttribute("myRoom", myRoom);
		httpSession.setAttribute("postList", postList);
		return "myRoom/myRoom";
	}

	@RequestMapping(value = "userRoomLink.do", method = RequestMethod.GET)
	private String userRoomLink(Model model, String memCD) {
		List<PostAndContents> postList = parService.getPost(memCD);
		Member user = userService.getMemberInfo(memCD);
		for (PostAndContents post : postList) {
			post.setMemGradeInt((int) post.getMemGrade());
			post.setFormatUpdateDate(df2.format(post.getUpdateDate()));
		}

		if (user.getImgPath() == null || user.getImgPath().equals("")) {
			user.setImgPath("/resources/img/empty.jpg");
		}
		model.addAttribute("user", user);
		model.addAttribute("postList", postList);
		return "myRoom/myRoom";
	}

	@ResponseBody
	@RequestMapping(value = "myRoomJson.do", method = RequestMethod.POST)
	public Map getReplyList(@RequestBody Map paramMap, HttpServletRequest request) {
		String postCD = (String) paramMap.get("name");

		System.out.println("postCD = " + postCD);
		List<Reply> replyList = parService.getReplyList(postCD);

		System.out.println(replyList);
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (Reply reply : replyList) {
			reply.setFormatUpdateDate(df2.format(reply.getUpdateDate()));
			if (reply.getImgPath() == null || reply.getImgPath().equals("")) {
				reply.setImgPath("/resources/img/empty.jpg");
			}
		}
		System.out.println(replyList);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("replyList", replyList);

		return map;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getFriendsComments(String memCD, String friendCD) {
		return null;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getFriendsReply(String memCD, String friendCD) {
		return null;
	}

}
