/**
 * 
 */

package com.pyongjjeom.notice.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pyongjjeom.notice.service.NoticeService;
import com.pyongjjeom.user.service.UserService;

/**
 * <pre>
 * com.pyongjjeom.notice.controllers 
 *    |_ NoticeController.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
@Controller
public class NoticeController {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private UserService userService;

	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getAllNotices() {
		return null;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getNotice(String notCD) {
		return null;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String updateNotice(String notCD) {
		return null;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String deleteNotice(String notCD) {
		return null;
	}
}
