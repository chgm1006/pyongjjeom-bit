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
package com.pyongjjeom.login.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.pyongjjeom.user.dto.UploadItem;

/**
 * <pre>
 * com.pyongjjeom.login.controllers 
 *    |_ UploadController.java
 * 
 * </pre>
 * @date : 2014. 7. 15. 오후 9:26:46
 * @version : 
 * @author : Kimyt
 */
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
	private FileSystemResource fsResource; // 파일다운로드

	@RequestMapping(method = RequestMethod.GET)
	public String getUploadForm(Model model) {

		System.out.println("첫번째 model 부분 실행?");
		model.addAttribute(new UploadItem()); // name ,fileData 를 끌고 오겟다.

		return "login/uploadCheck";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String create(UploadItem uploadItem, BindingResult result) {
		System.out.println("create가 되냐??????????");

		if (result.hasErrors()) // 에러체크
		{
			for (ObjectError error : result.getAllErrors()) {
				System.err.println("Error: " + error.getCode() + " - "
						+ error.getDefaultMessage());
			}
			return "login/uploadCheck";
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
					|| imgExt.equalsIgnoreCase("GIF") || imgExt.equalsIgnoreCase("PNG")) 
			{
				byte[] bytes = uploadItem.getFileData().getBytes();
				
				System.out.println(bytes);
				
				try {
					File lOutFile = new File(fsResource.getPath() + "_" + filename);
					System.out.println(lOutFile); // 이미지 경로
	
	/*				String lOutFile2 =		lOutFile.toString().replace("\\", "/");*/
				
					System.out.println(lOutFile);
									
					FileOutputStream lFileOutputStream = new FileOutputStream(lOutFile);
					
					System.out.println(lFileOutputStream); //이미지 경로
					
			    lFileOutputStream.write(bytes);
					lFileOutputStream.close();
				} catch (IOException ie) {
					// Exception 처리
					ie.printStackTrace();
	
					System.err.println("File writing error! ");
				
				}
				
				System.err.println("File upload success! ");
			} else {
				System.err.println("File type error! ");
			}
		}

		// Some type of file processing...
		System.err.println("-------------------------------------------");
		System.err.println("Test upload: " + uploadItem.getName());
		System.err.println("Test upload: "
				+ uploadItem.getFileData().getOriginalFilename());
		System.err.println("-------------------------------------------");

		return "login/uploadCheck";
	}

}
