/**
 * 
 */

package com.pyongjjeom.contents.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pyongjjeom.common.NaverBook;
import com.pyongjjeom.common.NaverMovie;
import com.pyongjjeom.contents.dao.ContentsMapper;
import com.pyongjjeom.contents.dto.Content;
import com.pyongjjeom.contents.parsing.common.BookGrades;
import com.pyongjjeom.contents.parsing.common.ContentsValue;
import com.pyongjjeom.contents.parsing.common.MovieGrades;

/**
 * <pre>
 * com.pyongjjeom.contents.service 
 *    |_ ContentServiceImpl.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
@Service("contentService")
public class ContentServiceImpl implements ContentService {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private ContentsMapper contentsMapper;

	@Override
	public void movieTitleInsert(List<ContentsValue> Values) {
		for (ContentsValue value : Values) {
			value.setTitle(value.getTitle().replace(", "," "));
			contentsMapper.contentsTitleInsert(value);
			contentsMapper.conCDMInsert(value.getConcd());
		}
	}

	@Override
	public void gradeUpdate(List<ContentsValue> values, String str) {
		for (ContentsValue value : values) {
			value.setTitle(value.getTitle().replace(" ","").replace(",","").trim());
			if (value.getTitle().contains("(")) {
				value.setTitle(value.getTitle().substring(0,
						value.getTitle().indexOf("(")));
			}
			switch (str) {
			case "n":
				contentsMapper.naverMovieGradeUpdate(value);
				break;
			case "d":
				contentsMapper.daumGradeUpdate(value);
				break;
			case "c":
				contentsMapper.cgvGradeUpdate(value);
				break;
			case "m":
				contentsMapper.megaBoxGradeUpdate(value);
				break;
			case "l":
				contentsMapper.lotteGradeUpdate(value);
				break;
			case "y":
				contentsMapper.yes24GradeUpdate(value);
				break;
			case "k":
				contentsMapper.kyoboGradeUpdate(value);
				break;
			case "a":
				contentsMapper.aladinGradeUpdate(value);
				break;
			case "b":
				contentsMapper.bandinlunisGradeUpdate(value);
				break;
			case "nb":
				contentsMapper.naverBookGradeUpdate(value);
				break;

			default:
				break;
			}
		}
	}

	@Override
	public void bookTitleInsert(List<ContentsValue> values) {
		for (ContentsValue value : values) {
			value.setTitle(value.getTitle().replace(", "," "));
			contentsMapper.contentsTitleInsert(value);
			contentsMapper.conCDBInsert(value.getConcd());
		}
	}

	@Override
	public MovieGrades movieGradeSelect(String concd) {
		return contentsMapper.movieGradeSelect(concd);
	}

	@Override
	public BookGrades bookGradeSelect(String concd) {
		return contentsMapper.bookGradeSelect(concd);
	}

	@Override
	public void movieInfoInsert(NaverMovie movie) {

		contentsMapper.movieInfoInsert(movie);
	}

	@Override
	public void bookInfoInsert(NaverBook book) {
		contentsMapper.bookInfoInsert(book);
	}
}
