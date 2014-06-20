/**
 * 
 */

package com.pyongjjeom.common.code;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.log4j.Logger;

/**
 * <pre>
 * com.pyongjjeom.common 
 *    |_ DBCode.java
 * 
 * DB 코드를 생성하는 클래스.
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
public class DBCode {

	private Logger log = Logger.getLogger(this.getClass());

	private long date = System.currentTimeMillis();

	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	private String nowDate = dateFormat.format(date);

	/**
	 * <pre>
	 * 1. 개요 : Content 코드를 생성한다.
	 * 2. 처리내용 : Content 코드 생성.<br>
	 * 
	 * </pre>
	 * 
	 * @Method Name : getMovieContentCD
	 * @date : 2014. 6. 20.
	 * @author : Forrest
	 * @history :
	 *          ------------------------------------------------------------------
	 *          ----- 변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2014. 6. 20. Forrest 최초 작성
	 *          ------------------------------------------------------------------
	 *          -----
	 * 
	 * @param cd
	 *          "M"은 영화, "B"는 도서, "C"는 공연.
	 * @return Content 코드를 반환.
	 */
	public String getContentCD(String cd) {
		int cnt = 0;
		if (cd.toUpperCase().equals("M")) {
			cnt = StaticField.MOVIE_CNT++;
		} else if (cd.toUpperCase().equals("B")) {
			cnt = StaticField.BOOK_CNT++;
		} else if (cd.toUpperCase().equals("C")) {
			cnt = StaticField.CONCERT_CNT++;
		} else {
			System.err.println("등록되지 않은 코드입니다.");
			return null;
		}
		String cntFormat = String.format("%03d", cnt);
		String conStr = cd.toUpperCase() + nowDate + cntFormat;
		System.out.println(conStr);
		return conStr;
	}

	/**
	 * <pre>
	 * 1. 개요 : 댓글 코드를 생성한다.
	 * 2. 처리내용 : 댓글 코드를 생성
	 * </pre>
	 * 
	 * @Method Name : getReplyCD
	 * @date : 2014. 6. 20.
	 * @author : Forrest
	 * @history :
	 *          ------------------------------------------------------------------
	 *          ----- 변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2014. 6. 20. Forrest 최초 작성
	 *          ------------------------------------------------------------------
	 *          -----
	 * 
	 * @param cd
	 *          "R"은 댓글
	 * @return 댓글코드를 반환.
	 */
	public String getReplyCD(String cd) {
		int cnt = 0;
		if (cd.toUpperCase().equals("R")) {
			cnt = StaticField.REPLY_CNT++;
		} else {
			System.err.println("등록되지 않은 코드입니다.");
			return null;
		}
		String cntFormat = String.format("%05d", cnt);
		String replyStr = cd.toUpperCase() + nowDate + cntFormat;
		System.out.println(replyStr);
		return replyStr;
	}

	/**
	 * <pre>
	 * 1. 개요 : 공지사항 코드를 생선한다.
	 * 2. 처리내용 : 공지사항 코드 생성.
	 * </pre>
	 * 
	 * @Method Name : getNoticeCD
	 * @date : 2014. 6. 20.
	 * @author : Forrest
	 * @history :
	 *          ------------------------------------------------------------------
	 *          ----- 변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2014. 6. 20. Forrest 최초 작성
	 *          ------------------------------------------------------------------
	 *          -----
	 * 
	 * @param cd
	 *          "NO"는 공지사항, "SM"은 시스템 관리, "EV"는 이벤트
	 * @return 공지사항 코드를 반환.
	 */
	public String getNoticeCD(String cd) {
		int cnt = StaticField.NOTICE_CNT++;
		if (!(cd.toUpperCase().equals("NO") || cd.toUpperCase().equals("SM") || cd
				.toUpperCase().equals("EV"))) {
			System.err.println("등록되지 않은 코드입니다.");
			return null;
		}
		String cntFormat = String.format("%03d", cnt);
		String noticeStr = cd.toUpperCase() + nowDate + cntFormat;
		System.out.println(noticeStr);
		return noticeStr;
	}

	/**
	 * <pre>
	 * 1. 개요 : Post 코드를 생성한다.
	 * 2. 처리내용 : Post 코드 생성.
	 * </pre>
	 * 
	 * @Method Name : getPostCD
	 * @date : 2014. 6. 20.
	 * @author : Forrest
	 * @history :
	 *          ------------------------------------------------------------------
	 *          ----- 변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2014. 6. 20. Forrest 최초 작성
	 *          ------------------------------------------------------------------
	 *          -----
	 * 
	 * @param cd
	 *          "PM"은 영화 포스트, "PB"는 도서 포스트, "PC"는 공연 포스트
	 * @return 포스트코드를 반환.
	 */
	public String getPostCD(String cd) {
		int cnt = 0;
		if (cd.toUpperCase().equals("PM")) {
			cnt = StaticField.PM_CNT++;
		} else if (cd.toUpperCase().equals("PB")) {
			cnt = StaticField.PB_CNT++;
		} else if (cd.toUpperCase().equals("PC")) {
			cnt = StaticField.PC_CNT++;
		} else {
			System.err.println("등록되지 않은 코드입니다.");
			return null;
		}
		String cntFormat = String.format("%05d", cnt);
		String postStr = cd.toUpperCase() + nowDate + cntFormat;
		System.out.println(postStr);
		return postStr;
	}

	/**
	 * <pre>
	 * 1. 개요 : 회원 코드를 생성한다.
	 * 2. 처리내용 : 회원코드 생성.
	 * </pre>
	 * 
	 * @Method Name : getMemberCD
	 * @date : 2014. 6. 20.
	 * @author : Forrest
	 * @history :
	 *          ------------------------------------------------------------------
	 *          ----- 변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2014. 6. 20. Forrest 최초 작성
	 *          ------------------------------------------------------------------
	 *          -----
	 * 
	 * @param cd
	 *          "F"는 페이스북 회원, "G"는 일반회원
	 * @return 회원코드를 반환.
	 */
	public String getMemberCD(String cd) {
		int cnt = 0;
		if (cd.toUpperCase().equals("F")) {
			cnt = StaticField.F_CNT++;
		} else if (cd.toUpperCase().equals("G")) {
			cnt = StaticField.G_CNT++;
		} else {
			System.err.println("등록되지 않은 코드입니다.");
			return null;
		}
		String cntFormat = String.format("%05d", cnt);
		String memStr = cd.toUpperCase() + nowDate + cntFormat;
		System.out.println(memStr);
		return memStr;
	}

	/**
	 * <pre>
	 * 1. 개요 : Email인증 코드를 생성한다.
	 * 2. 처리내용 : Email 인증코드 생성.
	 * </pre>
	 * 
	 * @Method Name : getEmailAuthCD
	 * @date : 2014. 6. 20.
	 * @author : Forrest
	 * @history :
	 *          ------------------------------------------------------------------
	 *          ----- 변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2014. 6. 20. Forrest 최초 작성
	 *          ------------------------------------------------------------------
	 *          -----
	 * 
	 * @return Email 인증코드를 반환.
	 */
	public String getEmailAuthCD() {
		int length = 5;
		StringBuffer buffer = new StringBuffer();
		Random random = new Random();

		String chars[] = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,1,2,3,4,5,6,7,8,9,0"
				.split(",");
		for (int i = 0; i < length; i++) {
			buffer.append(chars[random.nextInt(chars.length)]);
		}
		System.out.println(buffer);
		return buffer.toString();
	}

	/**
	 * <pre>
	 * 1. 개요 : 이미지 코드를 생성한다.
	 * 2. 처리내용 : 이미지 코드를 반환.
	 * </pre>
	 * 
	 * @Method Name : getIMGCD
	 * @date : 2014. 6. 20.
	 * @author : Forrest
	 * @history :
	 *          ------------------------------------------------------------------
	 *          ----- 변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2014. 6. 20. Forrest 최초 작성
	 *          ------------------------------------------------------------------
	 *          -----
	 * 
	 * @param cd
	 *          "PIMG"는 포스트이미지, "CIMG"는 컨텐트 이미지.
	 * @return 이미지 코드를 반환.
	 */
	public String getIMGCD(String cd) {
		int cnt = 0;
		if (cd.toUpperCase().equals("PIMG")) {
			cnt = StaticField.PIMG_CNT++;
		} else if (cd.toUpperCase().equals("CIMG")) {
			cnt = StaticField.CIMG_CNT++;
		} else {
			System.err.println("등록되지 않은 코드입니다.");
			return null;
		}
		String cntFormat = String.format("%05d", cnt);
		String imgStr = cd.toUpperCase() + nowDate + cntFormat;
		System.out.println(imgStr);
		return imgStr;
	}

	public static void main(String[] args) {
		DBCode dc = new DBCode();
		dc.getIMGCD("pimg");
		dc.getIMGCD("pImg");
		dc.getIMGCD("Pimg");
		dc.getIMGCD("Cimg");
		dc.getIMGCD("cimg");
		dc.getIMGCD("cimg");
	}
}
