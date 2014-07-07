/**
 * 
 */

package com.pyongjjeom.postandreply.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pyongjjeom.common.NaverBook;
import com.pyongjjeom.common.code.DBCode;
import com.pyongjjeom.contents.dto.Content;
import com.pyongjjeom.contents.service.ContentService;
import com.pyongjjeom.friends.service.FriendsService;
import com.pyongjjeom.notice.dto.Notice;
import com.pyongjjeom.postandreply.dto.Post;
import com.pyongjjeom.postandreply.dto.Reply;
import com.pyongjjeom.postandreply.service.PostAndReplyService;
import com.pyongjjeom.user.dto.Member;
import com.pyongjjeom.user.service.UserService;

/**
 * <pre>
 * com.pyongjjeom.postandreply.controllers 
 *    |_ PostAndReplyController.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
@Controller
public class PostAndReplyController {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private PostAndReplyService parService;
	private HttpSession httpSession;
/*	@Autowired
	private UserService userService;


	@Autowired
	private ContentService contentService;

	@Autowired
	private FriendsService friendsService;*/

	private Reply reply;
	private Member mem;
	private Content content;

	
	@RequestMapping(value = "postingInsert.do", method = RequestMethod.POST)
	public String postingInsert(Post post, HttpServletRequest request) {

		DBCode code= new DBCode();
		post.setPostCD(code.getPostCD("PB"));
		post=reviewToDB(post);
		parService.insertBookPost(post);
		return "contents/contentsPostingResult";
	}

	public Post reviewToDB(Post post) {
		String temp = post.getReview();
		temp = temp.replaceAll("`", "'").replaceAll("\r\n", "<br>")
				.replaceAll("\u0020", "&nbsp;");
		post.setReview(temp);
		return post;
	}
	
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getPost(String memCD, String conCD) {
		return null;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getReply(String memCD, String conCD) {
		return null;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String updatePost(String postCD) {
		return null;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String deletePost(String postCD) {
		return null;
	}
}
