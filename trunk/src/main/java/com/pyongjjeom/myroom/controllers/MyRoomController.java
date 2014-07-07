/**
 * 
 */

package com.pyongjjeom.myroom.controllers;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pyongjjeom.friends.dto.Friends;
import com.pyongjjeom.myroom.service.MyRoomService;
import com.pyongjjeom.notice.dto.Notice;
import com.pyongjjeom.notice.dto.NoticeCode;
import com.pyongjjeom.postandreply.dto.Post;
import com.pyongjjeom.postandreply.dto.Reply;
import com.pyongjjeom.postandreply.service.PostAndReplyService;
import com.pyongjjeom.user.dao.UserMapper;
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

	
	private HttpSession httpSession;
	private Friends frn;
	private Member mem;
	private Post post;
	private Reply reply;


	@RequestMapping(value = "myRoom.do")
	public String listDo(	Model model, HttpServletRequest request) {

		httpSession =request.getSession();
		Member member=(Member) httpSession.getAttribute("member");
    List<Post> postList= parService.getPost(member.getMemCD());
		System.out.println(postList);
		httpSession.setAttribute("postList",postList);
		return "myRoom/myRoom";
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getMyPost(String memCD) {
		return null;
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
