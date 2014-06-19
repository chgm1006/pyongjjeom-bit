/**
 * 
 */

package com.pyongjjeom.myroom.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pyongjjeom.myroom.service.MyRoomService;
import com.pyongjjeom.postandreply.dto.Post;
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
	private UserService userService;

	@Autowired
	private MyRoomService myroomService;

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
