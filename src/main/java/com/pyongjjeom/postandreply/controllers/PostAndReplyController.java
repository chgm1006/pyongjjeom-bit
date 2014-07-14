/**
 * 
 */

package com.pyongjjeom.postandreply.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pyongjjeom.common.NaverBook;
import com.pyongjjeom.common.NaverMovie;
import com.pyongjjeom.common.code.DBCode;
import com.pyongjjeom.contents.dto.Content;
import com.pyongjjeom.contents.service.ContentService;
import com.pyongjjeom.friends.service.FriendsService;
import com.pyongjjeom.notice.dto.Notice;
import com.pyongjjeom.postandreply.dto.Post;
import com.pyongjjeom.postandreply.dto.Reply;
import com.pyongjjeom.postandreply.service.PostAndReplyService;
import com.pyongjjeom.user.dto.Member;
import com.pyongjjeom.user.service.UserService;

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

	@RequestMapping(value = "postingInsertJson.do", method = RequestMethod.POST)
	public Map postingInsert( @RequestBody Map paramMap,HttpServletRequest request) {

		
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
		reviewDbToView(post);
		System.out.println(post);
		parService.insertPost(post);
		return null;
		/*
		 * httpSession = request.getSession(); String conCD = null; String nCode =
		 * null; // String category = (String) httpSession.getAttribute("category");
		 * String category = request.getParameter("category");
		 * 
		 * if (category.equals("movie")) { if (!content.getImage().isEmpty()) {
		 * nCode = content.getImage().replace("A", "1").replace("B", "2")
		 * .replace("C", "3").replace("D", "4").replace("E", "5") .replace("F",
		 * "6"); if (nCode.contains("_")) { nCode =
		 * nCode.substring(nCode.lastIndexOf("/") + 1, nCode.indexOf("_")); } else
		 * nCode = nCode.substring(nCode.lastIndexOf("/") + 1, nCode.indexOf("-"));
		 * } conCD = "M" + nCode; } else if (category.equals("book")) { if
		 * (!content.getImage().isEmpty()) { nCode = content.getImage().substring(
		 * content.getImage().lastIndexOf("/0") + 2,
		 * content.getImage().indexOf(".jpg")); } conCD = "B" + nCode; }
		 * reviewDbToView(post); post.setPostCD(code.getPostCD("PB"));
		 * post.setConCD(conCD); content.setConCD(conCD);
		 * content.setActor(content.getActor().replace("|", " "));
		 * content.setDirector(content.getDirector().replace("|", " "));
		 * parService.insertPost(post); contentService.contentsInfoInsert(content);
		 * return "postandreply/contentsPostingResult";
		 */
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getPost(String memCD, String conCD) {
		return null;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getReply(String memCD, String conCD) {
		return null;
	}

	@RequestMapping(value = "updatePost.do", method = RequestMethod.GET)
	public String updatePost(@Valid Post post, Model model,
			HttpServletRequest request) {
		System.out.println(request.getParameter("postCD"));

		Post newPost = parService.updatePost(request.getParameter("postCD"));

		System.out.println(newPost);

		model.addAttribute("np", newPost);

		reviewUpdateDbtoView(newPost);

		System.out.println(post.toString());

		return "postandreply/updatePost";
	}

	@RequestMapping(value = "updatePostOk.do", method = RequestMethod.POST)
	public String updatePostOk(Post post, Model model, HttpServletRequest request)

	{

		reviewDbToView(post);

		System.out.println(request.getParameter("postCD"));
		System.out.println(request.getParameter("memGrade"));
		parService.editPost(post);

		request.getParameter("postCD");

		System.out.println(post.toString());

		return "postandreply/updatePost_ok";
	}

	@RequestMapping(value = "deletePost.do", method = RequestMethod.GET)
	public String deletePost(@Valid Post post, Model model,
			HttpServletRequest request) {

		request.getParameter("postCD");

		parService.deletePost(request.getParameter("postCD"));

		return "postandreply/deletePost_ok";
	}

	/*
	 * 맨처음 포스팅을 쓸때 체크해주는 것
	 */public Post reviewViewToDb(Post post) { // DB에서 View로

		String viewReview = post.getComment();
		viewReview = viewReview.replaceAll("'", "`");
		post.setReview(viewReview);

		return post;
	}

	/*
	 * view에서 DB로 넘어갈때 체크해주는 것
	 */public Post reviewDbToView(Post post) {
		String dbReview = post.getComment();
		dbReview = dbReview.replaceAll("`", "'").replaceAll("\r\n", "<br>")
				.replaceAll("\u0020", "&nbsp;");
		post.setReview(dbReview);
		return post;
	}

	/*
	 * 수정하기를 클릭햇을때 DB에서 view로 넘어올경우 br이 그대로넘어오므로 바꿔줘야함
	 */public Post reviewUpdateDbtoView(Post newPost) {

		String viewPost = newPost.getComment();
		viewPost = viewPost.replaceAll("<br>", "\r\n");
		newPost.setReview(viewPost);

		return newPost;
	}

}
