/**
 * 
 */

package com.pyongjjeom.postandreply.controllers;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pyongjjeom.common.NaverBook;
import com.pyongjjeom.common.NaverMovie;
import com.pyongjjeom.common.code.DBCode;
import com.pyongjjeom.contents.service.ContentService;
import com.pyongjjeom.postandreply.dto.Post;
import com.pyongjjeom.postandreply.dto.Reply;
import com.pyongjjeom.postandreply.service.PostAndReplyService;
import com.pyongjjeom.user.dto.Member;

/**
 * <pre>
 * com.pyongjjeom.postandreply.controllers 
 *    |_ PostAndReplyController.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
@Controller
public class PostAndReplyController {

	@Autowired
	private PostAndReplyService parService;

	@Autowired
	private ContentService contentService;

	private HttpSession httpSession;

	/*
	 * @Autowired private UserService userService;
	 * 
	 * 
	 * 
	 * 
	 * @Autowired private FriendsService friendsService;
	 */

	private Reply reply;
	private Member mem;

	DBCode code = new DBCode();

	@ResponseBody
	@RequestMapping(value = "postingInsertJson.do", method = RequestMethod.POST)
	public Map postingInsert(@RequestBody Map paramMap, HttpServletRequest request) {
		Post post = new Post();
		double memGrade = Double.parseDouble((String) paramMap.get("name"));
		String coment = (String) paramMap.get("data");
		System.out.println(memGrade + " ////" + coment);
		httpSession = request.getSession();
		String category = (String) httpSession.getAttribute("category");
		if (category.equals("movie")) {
			NaverMovie movie = (NaverMovie) httpSession.getAttribute("movie");
			movie.setActor(movie.getActor().replace("|", " "));
			movie.setDirector(movie.getDirector().replace("|", " "));
			contentService.movieInfoInsert(movie);
			post.setConCD(movie.getConCD());
			System.out.println(movie);
		}
		if (category.equals("book")) {
			NaverBook book = (NaverBook) httpSession.getAttribute("book");
			book.setAuthor(book.getAuthor().replace("|", " "));
			contentService.bookInfoInsert(book);
			post.setConCD(book.getConCD());
		}
		Member member = (Member) httpSession.getAttribute("member");
		post.setPmemCD(member.getMemCD());
		post.setPostCD(code.getPostCD("PB"));
		post.setMemGrade(memGrade);
		post.setComment(coment);
		System.out.println("개행 전 " + post.getComment());
		post = reviewDbToView(post);
		System.out.println("개행 후" + post.getComment());
		parService.insertPost(post);
		return paramMap;
	}

	@ResponseBody
	@RequestMapping(value = "postingDeleteJson.do", method = RequestMethod.POST)
	public Map postingDelete(@RequestBody Map paramMap, HttpServletRequest request) {
		String postCD = (String) paramMap.get("name");
		parService.deletePost(postCD);
		return paramMap;
	}

	// Post CD , comment, memGrade 필요
	@ResponseBody
	@RequestMapping(value = "postingUpdateJson.do", method = RequestMethod.POST)
	public Map postingUpdate(@RequestBody Map paramMap, HttpServletRequest request) {
		String postCD = (String) paramMap.get("name");
		String coment = (String) paramMap.get("data");
		String memGrade = (String) paramMap.get("data");

		Post post = new Post();
		System.out.println(request.getParameter("postCD"));
		System.out.println(request.getParameter("memGrade"));

		post.setPostCD(postCD);
		post.setMemGrade(Double.parseDouble(memGrade));
		post.setComment(coment);
		reviewDbToView(post);
		parService.updatePost(post);
		System.out.println(post.toString());
		return paramMap;
	}

	// ////// reply insert / update / delete

	// post CD,reply 받기 memCD - session 에서 추출
	@ResponseBody
	@RequestMapping(value = "replyInsertJson.do", method = RequestMethod.POST)
	public Map replyInsert(@RequestBody Map paramMap, HttpServletRequest request, HttpSession session) {

		String postCD = (String) paramMap.get("name");
		String replyStr = (String) paramMap.get("data");

		Reply reply = new Reply();
		// 개행 적용
		replyStr = replyStr.replaceAll("`", "'").replaceAll("\n", "<br>")
				.replaceAll("\u0020", "&nbsp;");
		System.out.println(postCD + " ////" + replyStr);

		Member member = (Member) session.getAttribute("member");
		reply.setMemCD(member.getMemCD());
		reply.setReplyCD(code.getReplyCD("R"));
		reply.setReply(replyStr);
		reply.setPostCD(postCD);
		parService.insertReply(reply);

		List<Reply> replyList =parService.getReplyList(postCD);
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (Reply reply2 : replyList) {
			reply2.setFormatUpdateDate(df2.format(reply2.getUpdateDate()));
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("replyList", replyList);
		return map;
	}

	// reply Code ,reply 필요
	@ResponseBody
	@RequestMapping(value = "replyUpdateJson.do", method = RequestMethod.POST)
	public Map replyUpdate(@RequestBody Map paramMap, HttpServletRequest request) {
		String replyCD = (String) paramMap.get("name");
		String replyStr = (String) paramMap.get("data");

		Reply reply = new Reply();

		replyStr = replyStr.replaceAll("`", "'").replaceAll("\n", "<br>")
				.replaceAll("\u0020", "&nbsp;");

		reply.setReplyCD(replyCD);
		reply.setReply(replyStr);

		parService.updateReply(reply);
		return paramMap;
	}

	// reply Code 필요
	@ResponseBody
	@RequestMapping(value = "replyDeleteJson.do", method = RequestMethod.POST)
	public Map replyDelete(@RequestBody Map paramMap, HttpServletRequest request) {
		String replyCD = (String) paramMap.get("name");

		parService.deleteReply(replyCD);
		return paramMap;
	}

	/*
	 * @RequestMapping(value = "updatePost.do", method = RequestMethod.GET) public
	 * String updatePost(@Valid Post post, Model model, HttpServletRequest
	 * request) { System.out.println(request.getParameter("postCD")); Post newPost
	 * = parService.updatePost(request.getParameter("postCD"));
	 * System.out.println(newPost); model.addAttribute("np", newPost);
	 * reviewUpdateDbtoView(newPost); System.out.println(post.toString()); return
	 * "postandreply/updatePost"; }
	 * 
	 * @RequestMapping(value = "updatePostOk.do", method = RequestMethod.POST)
	 * public String updatePostOk(Post post, Model model, HttpServletRequest
	 * request) { reviewDbToView(post);
	 * System.out.println(request.getParameter("postCD"));
	 * System.out.println(request.getParameter("memGrade"));
	 * parService.editPost(post); request.getParameter("postCD");
	 * System.out.println(post.toString()); return "postandreply/updatePost_ok"; }
	 * 
	 * @RequestMapping(value = "deletePost.do", method = RequestMethod.GET) public
	 * String deletePost(@Valid Post post, Model model, HttpServletRequest
	 * request) { request.getParameter("postCD");
	 * parService.deletePost(request.getParameter("postCD")); return
	 * "postandreply/deletePost_ok"; }
	 */
	/*
	 * 맨처음 포스팅을 쓸때 체크해주는 것
	 */public Post reviewViewToDb(Post post) { // DB에서 View로
		String viewReview = post.getComment();
		viewReview = viewReview.replaceAll("'", "`");
		post.setComment(viewReview);
		return post;
	}

	/*
	 * view에서 DB로 넘어갈때 체크해주는 것
	 */public Post reviewDbToView(Post post) {
		String dbReview = post.getComment();
		dbReview = dbReview.replaceAll("`", "'").replaceAll("\n", "<br>")
				.replaceAll("\u0020", "&nbsp;");
		post.setComment(dbReview);
		return post;
	}

	/*
	 * 수정하기를 클릭햇을때 DB에서 view로 넘어올경우 br이 그대로넘어오므로 바꿔줘야함
	 */public Post reviewUpdateDbtoView(Post newPost) {
		String viewPost = newPost.getComment();
		viewPost = viewPost.replaceAll("<br>", "\r\n");
		newPost.setComment(viewPost);
		return newPost;
	}

}
