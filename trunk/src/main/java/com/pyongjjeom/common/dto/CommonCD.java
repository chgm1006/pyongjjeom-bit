/**
 * 
 */

package com.pyongjjeom.common.dto;

/**
 * <pre>
 * com.pyongjjeom.common.dto 
 *    |_ CommonCD.java
 * 
 * 공통코드 DTO 클래스
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
public class CommonCD {
	private String code = "";
	private String codenm = "";
	private String codevalue = "";
	private String codegrp = "";

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodenm() {
		return codenm;
	}

	public void setCodenm(String codenm) {
		this.codenm = codenm;
	}

	public String getCodevalue() {
		return codevalue;
	}

	public void setCodevalue(String codevalue) {
		this.codevalue = codevalue;
	}

	public String getCodegrp() {
		return codegrp;
	}

	public void setCodegrp(String codegrp) {
		this.codegrp = codegrp;
	}

}
