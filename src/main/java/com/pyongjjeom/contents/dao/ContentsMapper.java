/**
 * 
 */

package com.pyongjjeom.contents.dao;

import com.pyongjjeom.contents.dto.Content;
import com.pyongjjeom.contents.parsing.common.BookGrades;
import com.pyongjjeom.contents.parsing.common.ContentsValue;
import com.pyongjjeom.contents.parsing.common.MovieGrades;

/**
 * <pre>
 * com.pyongjjeom.contents.dao 
 *    |_ ContentsMapper.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
public interface ContentsMapper {
	
	void conCDMInsert(String  concd);

	void conCDBInsert(String  concd);
	
	
	void contentsTitleInsert(ContentsValue value);

	void cgvGradeUpdate(ContentsValue contentsValue);

	void lotteGradeUpdate(ContentsValue contentsValue);

	void megaBoxGradeUpdate(ContentsValue contentsValue);

	void naverMovieGradeUpdate(ContentsValue value);

	void daumGradeUpdate(ContentsValue value);

	void yes24GradeUpdate(ContentsValue contentsValue);

	void aladinGradeUpdate(ContentsValue contentsValue);

	void kyoboGradeUpdate(ContentsValue contentsValue);

	void naverBookGradeUpdate(ContentsValue value);

	void bandinlunisGradeUpdate(ContentsValue value);

	MovieGrades movieGradeSelect(String concd);

	BookGrades bookGradeSelect(String title);

	void contentsInfoInsert(Content content);
}
