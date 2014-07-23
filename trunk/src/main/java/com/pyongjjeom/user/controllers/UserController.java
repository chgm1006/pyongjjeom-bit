/**
 * 
 */

package com.pyongjjeom.user.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.pyongjjeom.postandreply.dto.PostAndContents;
import com.pyongjjeom.postandreply.service.PostAndReplyService;
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

	@Autowired
	private PostAndReplyService parService;

	@Value("#{common['urlPath']}")
	private String urlPath;

	@RequestMapping(value = "deleteMember.do", method = RequestMethod.GET)
	public String deleteMember(@Valid HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println(request.getSession());

		Member member = new Member();
		member = (Member) session.getAttribute("member");
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
	public String mySet(Model model, HttpServletRequest request) {

		Member member = new Member();
		HttpSession session = request.getSession();
		member = (Member) session.getAttribute("member");
		model.addAttribute("commOpenChk", member.getCommOpenChk());
		model.addAttribute("commReplyChk", member.getCommReplyChk());
		System.out.println("라디오버튼체크값" + member.getCommOpenChk()
				+ member.getCommReplyChk());

		return "myRoom/mySet";
	}

	@RequestMapping(value = "upDateMySet.do", method = RequestMethod.POST)
	public String updateMemberInfo(Member member, Model model,
			HttpServletRequest request, HttpSession session) {
		MultipartFile uploadFile = member.getFileData();
		String imgPath = ((Member) session.getAttribute("member")).getImgPath();
		System.out.println(uploadFile.getOriginalFilename());
		System.out.println(member.getMemCD());
		System.out.println(member.getEmail());
		System.out.println(member.getMemNm());
		System.out.println(member.getPasswd());
		System.out.println(member.getBirth());
		System.out.println(imgPath);

		String originFile = "";
		String callingFile = "";
		System.out.println("getServerName = " + request.getServerName());
		urlPath = request.getServerName().equals("localhost") ? "http://localhost:8080/pyongjjeom"
				+ "/resources/userImages/"
				: "/resources/userImages/";

		System.out.println("urlPath11111 = " + request.getServerName().equals("localhost"));
		System.out.println("urlPath = " + urlPath);

		try {
			MultipartFile file = member.getFileData();
			String filePath = null;
			InputStream inputStream = null;
			OutputStream outputStream = null;

			// 파일 확장자 구하기
			int index = file.getOriginalFilename().equals("") ? imgPath
					.lastIndexOf(".") : file.getOriginalFilename().lastIndexOf(".");
			String fileExt = file.getOriginalFilename().equals("") ? imgPath
					.substring(index + 1) : file.getOriginalFilename().substring(
					index + 1);

			if (file.getSize() > 0) {
				inputStream = file.getInputStream();

				int fileSize = 10 * 1024 * 1024;
				if (file.getSize() > fileSize) {
					System.out.println("File Size:::" + file.getSize());
					session.setAttribute("fileErrMsg", "파일용량이 10M를 초과하였습니다.");
					return "myRoom/mySet";
				}

				filePath = request.getSession().getServletContext()
						.getRealPath("/resources/userImages/").replace("\\", "/");

				// "/resources/userImages/" 디렉토리가 없으면 디렉토리 생성
				File f = new File(filePath);
				if (!f.isFile()) {
					if (!f.isDirectory()) {
						f.mkdir();
						System.out.println("디렉토리 생성완료");
					}
				}

				// "jpg", "jpeg", "png", "gif"만 업로드 가능
				if (!isFileExtOK(fileExt)) {
					session.setAttribute("fileErrMsg", "파일 확장자가 맞지 않습니다.");
					return "myRoom/mySet";
				}

				outputStream = new FileOutputStream(filePath + "/"
						+ file.getOriginalFilename());

				System.out.println("filePath:" + filePath);
				System.out.println("fileName:" + file.getOriginalFilename());

				int readBytes = 0;
				byte[] buffer = new byte[10000];
				while ((readBytes = inputStream.read(buffer, 0, 10000)) != -1) {
					outputStream.write(buffer, 0, readBytes);
				}
				outputStream.close();
				inputStream.close();
				System.out.println("파일 업로드 완료");
			}

			originFile = filePath + "/" + file.getOriginalFilename();
			callingFile = filePath + "/" + member.getMemCD() + "." + fileExt;
			File originFileNM = new File(originFile);
			File renameFileNM = new File(callingFile);

			System.out.println("originFileNM = " + originFile);
			System.out.println("callingFileNM = " + callingFile);

			File f = new File(callingFile);

			// memCD로 변경한 이미지 파일이 이미 존재한다면, 삭제한다.
			if (f.exists()) {
				f.delete();
				System.out.println((member.getMemCD() + "." + fileExt) + "이 삭제 되었습니다.");
			}

			// 파일명을 user가 하나의 파일만 올릴수 있도록 memCD로 변경
			if (!(originFileNM.renameTo(renameFileNM))) {
				System.out.println("파일명 변경 에러 = " + originFileNM);
			} else {
				System.out.println("파일명 변경.");
			}

			// 유저가 업로드한 파일을 삭제하기 위해 File 객체를 다시 생성.
			f = new File(originFile);
			if (f.exists()) {
				f.delete();
				System.out.println(file.getOriginalFilename() + "이 삭제되었습니다.");
			} else {
				System.out.println(file.getOriginalFilename() + "파일이 존재하지 않습니다.");
			}

			member.setImgPath(urlPath + member.getMemCD() + "." + fileExt);
			// ..........................................
		} catch (Exception e) {
			System.out.println("upDateMySet.do Exception 발생....");
			e.printStackTrace();
		}

		System.out.println("11111");
		System.out.println(member);

		userService.upDateData(member);
		System.out.println(member.getCommOpenChk() + member.getCommReplyChk());
		System.out.println("22222222");
		System.out.println(member.toString());

		List<PostAndContents> postList = parService.getPost(member.getMemCD());
		for (PostAndContents post : postList) {
			post.setMemGradeInt((int) post.getMemGrade());
		}

		session.setAttribute("postList", postList);
		session.setAttribute("member", member);

		return "redirect:myRoom.do";
	}

	/**
	 * <PRE>
	 * 간략 : 
	 * 상세 :
	 * </PRE>
	 * 
	 * @param fileExt
	 * @return
	 */
	private boolean isFileExtOK(String fileExt) {
		return (fileExt.equalsIgnoreCase("jpg") || fileExt.equalsIgnoreCase("jpeg")
				|| fileExt.equalsIgnoreCase("png") || fileExt.equalsIgnoreCase("gif"));
	}
}
