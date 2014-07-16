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
		System.out.println("개행 전 "+post.getComment());
		post=reviewDbToView(post);
		System.out.println("개행 후"+post.getComment());
		parService.insertPost(post);
		return null;
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
