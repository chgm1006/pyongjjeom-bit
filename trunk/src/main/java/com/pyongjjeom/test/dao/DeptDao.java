package com.pyongjjeom.test.dao;

import java.util.List;

import com.pyongjjeom.test.dto.Dept;

public interface DeptDao {

	List<Dept> getAllDepts();

	Dept getDept(int deptno);
}
