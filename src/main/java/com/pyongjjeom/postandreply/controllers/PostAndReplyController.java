/**
 * 
 */

package com.pyongjjeom.postandreply.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pyongjjeom.contents.dto.Content;
import com.pyongjjeom.contents.service.ContentService;
import com.pyongjjeom.friends.service.FriendsService;
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
	private UserService userService;

	@Autowired
	private PostAndReplyService parService;

	@Autowired
	private ContentService contentService;

	@Autowired
	private FriendsService friendsService;

	private Post post;
	private Reply reply;
	private Member mem;
	private Content content;

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
