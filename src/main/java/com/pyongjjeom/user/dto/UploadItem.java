/**
 * 0. Project  : XXXX 프로젝트
 *
 * 1. FileName : UploadItem.java
 * 2. Package : com.pyongjjeom.user.dto
 * 3. Comment : 
 * 4. 작성자  : Kimyt
 * 5. 작성일  : 2014. 7. 15. 
 * 6. 변경이력 : 
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    Kimyt : 2014. 7. 15. :            : 신규 개발.
 */

/*
 * Copyright yysvip.tistory.com.,LTD.
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information
 * of yysvip.tistory.com.,LTD. ("Confidential Information").
 */
package com.pyongjjeom.user.dto;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * <pre>
 * com.pyongjjeom.user.dto 
 *    |_ UploadItem.java
 * 
 * </pre>
 * @date : 2014. 7. 15. 오후 9:23:42
 * @version : 
 * @author : Kimyt
 */
/**
 * <pre>
 * 간략 : 
 * 상세 : 
 * com.pyongjjeom.user.dto
 *   |_ UploadItem.java
 * </pre>
 * 
 * @author : Kimyt
 * @version : 1.0
 */

public class UploadItem {

	private String fileName;
	private MultipartFile fileData;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public MultipartFile getFileData() {
		return fileData;
	}

	public void setFileData(MultipartFile fileData) {
		this.fileData = fileData;
	}

}
