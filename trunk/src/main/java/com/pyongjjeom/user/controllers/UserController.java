/**
 * 
 */

package com.pyongjjeom.user.controllers;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.catalina.tribes.membership.MemberImpl;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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

	@RequestMapping(value = "deleteMember.do", method = RequestMethod.GET)
  public String deleteMember(@Valid HttpServletRequest request) {
     HttpSession session = request.getSession();
     System.out.println(request.getSession());
     
     
     Member member = new Member();
     member = (Member)session.getAttribute("member");
     System.out.println(member);
     
     String memCD = member.getMemCD();
     System.out.println(member.getMemKind());

     userService.deleteMember(memCD);
     session.setAttribute("member", member);
     System.out.println(member);
     
     session.removeAttribute("member");
     return "myRoom/deleteSuccess";
  }

	
	
	
	@RequestMapping(value = "mySet.do", method = RequestMethod.GET)
	public String mySet(Model model, HttpServletRequest request){
		
		Member member = new Member();
		HttpSession session = request.getSession();
		member = (Member) session.getAttribute("member");
		model.addAttribute("commOpenChk", member.getCommOpenChk());
		model.addAttribute("commReplyChk", member.getCommReplyChk());
		System.out.println("라디오버튼체크값" + member.getCommOpenChk() + member.getCommReplyChk());


		return "myRoom/mySet";
	}
	
	@RequestMapping(value = "upDateMySet.do", method = RequestMethod.POST)
	public String updateMemberInfo(Member member, Model model, HttpServletRequest request){
		MultipartFile uploadFile = member.getFileData();
		System.out.println(uploadFile.getOriginalFilename());
		System.out.println(member.getMemCD());
		System.out.println(member.getEmail());
		System.out.println(member.getMemNm());
		System.out.println(member.getPasswd());
		System.out.println(member.getBirth());

		System.out.println(request.getSession().getServletContext().getRealPath("/"));
		if(uploadFile != null){
			String fileName = uploadFile.getOriginalFilename();
			member.setImgNm(fileName);
			
			try {
				String filePath = "D:/02. Java/01. tools/eclipse-jee-kepler-SR2-Java8-win32/workspace/pyongjjeom/src/main/webapp/resources/userImages";
				System.out.println("filePath = " + filePath + fileName);
				File file = new File("userImages"); 
				if(!file.exists()){
//					System.out.println("디렉토리 생성 실패");
					file.mkdir();
				}
				uploadFile.transferTo(file);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("upDateMySet.do Exception 발생....");
				e.printStackTrace();
			}
		}
		
		System.out.println("11111");
		System.out.println(member);
		
		userService.upDateData(member);
		System.out.println(member.getCommOpenChk() + member.getCommReplyChk());
		System.out.println("22222222");
		System.out.println(member.toString());

		
		
		HttpSession session = request.getSession();
		session.setAttribute("member", member);

		return "myRoom/myRoom";
	}
	
	
}
