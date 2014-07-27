/**
 * 
 */

package com.pyongjjeom.contents.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.pyongjjeom.common.NaverBook;
import com.pyongjjeom.common.NaverMovie;
import com.pyongjjeom.contents.parsing.common.BookGrades;
import com.pyongjjeom.contents.parsing.common.ContentsValue;
import com.pyongjjeom.contents.parsing.common.MovieGrades;

/**
 * <pre>
 * com.pyongjjeom.contents.service 
 *    |_ ContentsService.java
 * 
 * </pre>
 * 
 * @date : 2014. 6. 17. 오후 9:03:59
 * @version :
 * @author : Forrest
 */
public interface ContentService {
	Logger logger = (Logger) Logger.getLogger(ContentService.class);

	void movieTitleInsert(List<ContentsValue> Values);

	void bookTitleInsert(List<ContentsValue> values);

	void gradeUpdate(List<ContentsValue> Values, String str);

	MovieGrades movieGradeSelect(String concd);

	BookGrades bookGradeSelect(String concd);

	void movieInfoInsert(NaverMovie movie);

	void bookInfoInsert(NaverBook book);
}
