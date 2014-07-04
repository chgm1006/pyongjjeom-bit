/**
 * 
 */

package com.pyongjjeom.user.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pyongjjeom.user.dto.Member;
import com.pyongjjeom.user.service.UserService;

/**
 * <pre>
 * com.pyongjjeom.user.controllers 
 *    |_ UserController.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
@Controller
public class UserController {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private UserService userService;

	private Member mem;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getMemberInfo() {
		return null;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String checkMemberID() {
		return null;

	}


	@RequestMapping(value = "", method = RequestMethod.GET)
	public String deleteMember() {
		return null;
	}
	
	
	
	@RequestMapping(value = "mySet.do", method = RequestMethod.GET)
	public String mySet(Model model, HttpServletRequest request){
		
	


		return "myRoom/mySet";
	}
	
	@RequestMapping(value = "upDateMySet.do", method = RequestMethod.POST)
	public String updateMemberInfo( Member member, Model model, HttpServletRequest request){
		
		/*
		 * if (!session.isNew()) { session = request.getSession(true); }
		 */

		
		System.out.println("11111");
		System.out.println(member);
		userService.upDateData(member);
	
	


		return "myRoom/myRoom";
	}
	
	
}
