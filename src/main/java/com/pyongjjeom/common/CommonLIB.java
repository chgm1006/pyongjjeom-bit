/**
 * 
 */

package com.pyongjjeom.common;

import org.apache.log4j.Logger;

/**
 * <pre>
 * com.pyongjjeom.common 
 *    |_ CommonLIB.java
 * 
 * 공통 라이브러리
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
public class CommonLIB {

	private Logger log = Logger.getLogger(this.getClass());

	/**
	 * <pre>
	 * 1. 개요 : 입력된 문자열이 숫자형인지 검증.
	 * 2. 처리내용 : 입력된 문자열이 숫자형인지 검증한다.
	 * </pre>
	 * 
	 * @Method Name : isNumeric
	 * @date : 2014. 6. 25.
	 * @author : Forrest
	 * @history :
	 *          ------------------------------------------------------------------
	 *          ----- 변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2014. 6. 25. Forrest 최초 작성
	 *          ------------------------------------------------------------------
	 *          -----
	 * 
	 * @param checkStr
	 *          검증할 문자열
	 * @return 정수형으로 변환이 가능하면 true, 변황이 불가능하면 false
	 */
	public static boolean isNumeric(String checkStr) {

		try {
			Double.parseDouble(checkStr);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}
