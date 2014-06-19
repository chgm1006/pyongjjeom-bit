/**
 * 
 */

package com.pyongjjeom.common.dto;

import java.util.Date;

import org.apache.log4j.Logger;

/**
 * <pre>
 * com.pyongjjeom.common.dto 
 *    |_ Imgtb.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
public class Imgtb {

	private Logger log = Logger.getLogger(this.getClass());
	private String imgCd = "";
	private String imgContentCd = "";
	private String imgMemCd = "";
	private String imgPath = "";
	private String imgNm = "";
	private char useYn = 'n';
	private String imgType = "";
	private Date regiDate = null;
	private Date updateDate = null;

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	public String getImgCd() {
		return imgCd;
	}

	public void setImgCd(String imgCd) {
		this.imgCd = imgCd;
	}

	public String getImgContentCd() {
		return imgContentCd;
	}

	public void setImgContentCd(String imgContentCd) {
		this.imgContentCd = imgContentCd;
	}

	public String getImgMemCd() {
		return imgMemCd;
	}

	public void setImgMemCd(String imgMemCd) {
		this.imgMemCd = imgMemCd;
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

	public char getUseYn() {
		return useYn;
	}

	public void setUseYn(char useYn) {
		this.useYn = useYn;
	}

	public String getImgType() {
		return imgType;
	}

	public void setImgType(String imgType) {
		this.imgType = imgType;
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

}
