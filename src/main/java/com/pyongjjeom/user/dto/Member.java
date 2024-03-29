/**
 * 
 */

package com.pyongjjeom.user.dto;

import java.util.Date;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * <pre>
 * com.pyongjjeom.user.dto 
 *    |_ Member.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
public class Member {

	/**
	 * <PRE>
	 * 간략 : .
	 * 상세 : .
	 * </PRE>
	 * 
	 * Constructor of Member.java class 생성자
	 * 
	 * @param email2
	 * @param passwd2
	 */

	public Member() {

	}

	public Member(String email, String passwd) {
		this.email = email;
		this.passwd = passwd;
	}

	private String memCD = "";
	private String email = "";
	private String memKind = "";
	private String memNm = "";
	private String birth = "";
	private String passwd = "";
	private char emailAuthYn = 'n';
	private String emailAuthCD = "";
	private char memValid = 'n';
	private String fbId = "";
	private char fbYn = 'n';
	private String imgPath = "";

	private String imgNm = "";
	private Date regiDate = null;
	private Date updateDate = null;

	private String commOpenChk = "";

	private String fileName;
	private CommonsMultipartFile fileData;

	public String getMemCD() {
		return memCD;
	}

	public void setMemCD(String memCD) {
		this.memCD = memCD;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMemKind() {
		return memKind;
	}

	public void setMemKind(String memKind) {
		this.memKind = memKind;
	}

	public String getMemNm() {
		return memNm;
	}

	public void setMemNm(String memNm) {
		this.memNm = memNm;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public char getEmailAuthYn() {
		return emailAuthYn;
	}

	public void setEmailAuthYn(char emailAuthYn) {
		this.emailAuthYn = emailAuthYn;
	}

	public String getEmailAuthCD() {
		return emailAuthCD;
	}

	public void setEmailAuthCD(String emailAuthCD) {
		this.emailAuthCD = emailAuthCD;
	}

	public char getMemValid() {
		return memValid;
	}

	public void setMemValid(char memValid) {
		this.memValid = memValid;
	}

	public String getFbId() {
		return fbId;
	}

	public void setFbId(String fbId) {
		this.fbId = fbId;
	}

	public char getFbYn() {
		return fbYn;
	}

	public void setFbYn(char fbYn) {
		this.fbYn = fbYn;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getImgNm() {
		return imgNm;
	}

	public void setImgNm(String imgNm) {
		this.imgNm = imgNm;
	}

	public Date getRegiDate() {
		return regiDate;
	}

	public void setRegiDate(Date regiDate) {
		this.regiDate = regiDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getCommOpenChk() {
		return commOpenChk;
	}

	public void setCommOpenChk(String commOpenChk) {
		this.commOpenChk = commOpenChk;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public CommonsMultipartFile getFileData() {
		return fileData;
	}

	public void setFileData(CommonsMultipartFile fileData) {
		this.fileData = fileData;
	}

	@Override
	public String toString() {
		return "Member [memCD=" + memCD + ", email=" + email + ", memKind=" + memKind + ", memNm=" + memNm + ", birth="
				+ birth + ", passwd=" + passwd + ", emailAuthYn=" + emailAuthYn + ", emailAuthCD=" + emailAuthCD
				+ ", memValid=" + memValid + ", fbId=" + fbId + ", fbYn=" + fbYn + ", imgPath=" + imgPath + ", imgNm=" + imgNm
				+ ", regiDate=" + regiDate + ", updateDate=" + updateDate + ", commOpenChk=" + commOpenChk + ", fileName="
				+ fileName + ", fileData=" + fileData + "]";
	}

}
