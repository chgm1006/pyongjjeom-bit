/**
 * 0. Project  : XXXX 프로젝트
 *
 * 1. FileName : UploadController.java
 * 2. Package : com.pyongjjeom.login.controllers
 * 3. Comment :
 * 4. 작성자  : Kimyt
 * 5. 작성일  : 2014. 7. 15.
 * 6. 변경이력 :
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    Kimyt : 2014. 7. 15. :            : 신규 개발.
 */

/* * Copyright yysvip.tistory.com.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of yysvip.tistory.com.,LTD. ("Confidential Information").
 */
package com.pyongjjeom.myroom.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.net.SecureNioChannel.ApplicationBufferHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pyongjjeom.myroom.service.MyRoomService;
import com.pyongjjeom.user.dto.Member;
import com.pyongjjeom.user.dto.UploadItem;

/**
 * <pre>
 * 간략 :
 * 상세 :
 * com.pyongjjeom.login.controllers
 *   |_ UploadController.java
 * </pre>
 *
 * @author : Kimyt
 * @version : 1.0
 */

@Controller
@RequestMapping(value = "uploadFile.do")
public class UploadController {
	@Autowired
	MyRoomService myRoomService;

	@Value("#{common['urlPath']}")
	private String urlPath;

	/*
	 * @Autowired private FileSystemResource fsResource; // 파일다운로드
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String getUploadForm(Model model) {

		System.out.println("첫번째 model 부분 실행?");
		model.addAttribute(new UploadItem()); // name ,fileData 를 끌고 오겟다.

		return "myRoom/uploadCheck";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String create(UploadItem uploadItem, BindingResult result,
			HttpServletRequest request) {
		System.out.println("create가 되냐??????????");

		String path = request.getSession().getServletContext().getRealPath("/");
		// //어느서버에서든 getRealPath를 이용하면 그경로가 나타남
		// String path =
		// "C:\\Eclipse downLoad\\eclipse-jee-kepler-SR2-Java8-win32-x86_64\\eclipse\\workspace\\pyongjjeom\\src\\main\\webapp";
		// // 어느서버에서든
		// getRealPath를
		// 이용하면
		// 그경로가
		// 나타남

		String path2 = System.getProperty("user.dir");
		System.out.println("path : " + path);
		System.out.println("path2 : " + path2);

		// String path2 = path.substring(path.length()-11);
		Member member;
		HttpSession session = request.getSession();

		member = (Member) session.getAttribute("member");

		if (result.hasErrors()) // 에러체크
		{
			for (ObjectError error : result.getAllErrors()) {
				System.err.println("Error: " + error.getCode() + " - "
						+ error.getDefaultMessage());
			}
			return "myRoom/uploadCheck";
		}

		if (!uploadItem.getFileData().isEmpty()) {

			String filename = uploadItem.getFileData().getOriginalFilename(); // 파일의
																																				// 실제명을
																																				// 가지고온다.

			String imgExt = filename.substring(filename.lastIndexOf(".") + 1,
					filename.length());

			System.out.println(filename);
			System.out.println(imgExt);

			// lastIndexof는끝에서부터 읽어들임
			// imgExt = 파일명을 읽어들임

			// upload 가능한 파일 타입 지정
			if (imgExt.equalsIgnoreCase("JPG") || imgExt.equalsIgnoreCase("JPEG")
					|| imgExt.equalsIgnoreCase("GIF") || imgExt.equalsIgnoreCase("PNG")) {
				byte[] bytes = null;

				System.out.println(bytes); //

				try {
					bytes = uploadItem.getFileData().getBytes();
					File lOutFile = new File(path + "/resources/userImages/" + filename);
					System.out.println(lOutFile); // 이미지 경로

					/* String lOutFile2 = lOutFile.toString().replace("\\", "/"); */

					System.out.println(lOutFile);

					FileOutputStream lFileOutputStream = new FileOutputStream(lOutFile);

					System.out.println(lFileOutputStream); // 이미지 경로
					System.out.println("urlPath =" + urlPath); // 이미지 경로

					urlPath = urlPath.equals(request.getServerName()) ? urlPath
							: "http://localhost:8080/pyongjjeom/";
					String realImgPath = urlPath + "/resources/userImages/" + filename;
					member.setImgPath(realImgPath.toString());

					lFileOutputStream.write(bytes);
					lFileOutputStream.close();
				} catch (IOException ie) {
					// Exception 처리
					ie.printStackTrace(); // 어떤문제인지 알려줌

					System.err.println("File writing error! ");

				}

				System.err.println("File upload success! ");

				System.out.println("member.imgPath = " + member.getImgPath());
				myRoomService.insertImage(member);

			} else {
				System.err.println("File type error! ");
			}
		}

		// Some type of file processing...
		System.err.println("-------------------------------------------");
		System.err.println("Test upload: " + uploadItem.getFileName());
		System.err.println("Test upload: "
				+ uploadItem.getFileData().getOriginalFilename());
		System.err.println("-------------------------------------------");

		return "myRoom/uploadCheck";
	}
}
