/**
 * 
 */

package com.pyongjjeom.contents.service; 

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pyongjjeom.contents.dao.ContentsMapper;
import com.pyongjjeom.contents.parsing.common.BookGrades;
import com.pyongjjeom.contents.parsing.common.ContentsValue;
import com.pyongjjeom.contents.parsing.common.MovieGrades;

/**
 * <pre>
 * com.pyongjjeom.contents.service 
 *    |_ ContentServiceImpl.java
 * 
 * </pre>
 * @version : 
 * @author : Forrest
 */
@Service("contentService")
public class ContentServiceImpl implements ContentService {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private ContentsMapper contentsMapper;
	

	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : getContents
	 * @date : 2014. 6. 18.
	 * @author : Forrest
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2014. 6. 18.		Forrest				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @see com.pyongjjeom.contents.service.ContentService#getContents()
	 * @return
	 */

	
	@Override
	public void movieTitleInsert(List<ContentsValue> Values) {
		for (ContentsValue value : Values)
			contentsMapper.movieTitleInsert(value);
	}

	@Override
	public void gradeUpdate(List<ContentsValue> values, String str) {
		for (ContentsValue value : values) {
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
		for (ContentsValue value : values)
			contentsMapper.bookTitleInsert(value);
	}

	@Override
	public MovieGrades movieGradeSelect(String title) {
		return contentsMapper.movieGradeSelect(title);
	}

	@Override
	public BookGrades bookGradeSelect(String title) {
		return contentsMapper.bookGradeSelect(title);
	}
}
