package com.pyongjjeom.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pyongjjeom.test.dao.TestDao;
import com.pyongjjeom.test.parsing.contents.ContentsValue;

@Service("TestService")
public class TestServiceImpl implements TestService {
	@Autowired
	private TestDao testDao;

	@Override
	public void movieTitleInsert(List<ContentsValue> Values) {
		for (ContentsValue value : Values)
			testDao.movieTitleInsert(value);
	}

	@Override
	public void gradeUpdate(List<ContentsValue> values, String str) {
		for (ContentsValue value : values) {
			switch (str) {
			case "n":
				testDao.naverBookGradeUpdate(value);
				break;
			case "d":
				testDao.daumGradeUpdate(value);
				break;
			case "c":
				testDao.cgvGradeUpdate(value);
				break;
			case "m":
				testDao.megaBoxGradeUpdate(value);
				break;
			case "l":
				testDao.lotteGradeUpdate(value);
				break;
			case "y":
				testDao.yes24GradeUpdate(value);
				break;
			case "k":
				testDao.kyoboGradeUpdate(value);
				break;
			case "a":
				testDao.aladinGradeUpdate(value);
				break;
			case "b":
				testDao.bandinlunisGradeUpdate(value);
				break;
			case "nb":
				testDao.naverBookGradeUpdate(value);
				break;

			default:
				break;
			}
		}
	}

	@Override
	public void bookTitleInsert(List<ContentsValue> values) {
		for (ContentsValue value : values)
			testDao.bookTitleInsert(value);
	}
}// end EmpServiceImpl
