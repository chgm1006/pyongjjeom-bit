/**
 * 
 */

package com.pyongjjeom.friends.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pyongjjeom.friends.dto.Friends;
import com.pyongjjeom.friends.service.FriendsService;
import com.pyongjjeom.user.service.UserService;

/**
 * <pre>
 * com.pyongjjeom.friends.controllers 
 *    |_ FriendsController.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
@Controller
public class FriendsController {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private FriendsService friendsService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getFriendList(String memCD) {
		return null;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String addFriendToMemberList(String memCD, String friendCD) {
		return null;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String deleteFriend(String memCD) {
		return null;
	}
}
