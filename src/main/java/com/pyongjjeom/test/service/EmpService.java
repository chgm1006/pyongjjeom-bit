package com.pyongjjeom.test.service;

import java.util.List;

import com.pyongjjeom.test.dto.Dept;
import com.pyongjjeom.test.dto.Emp;

public interface EmpService {
	int getAllEmpCount();

	List<Dept> getAllDepts();

	Emp selectEmp(int empno);

	List<Integer> getAllEmpno();

	void insertEmp(Emp emp);

	List<Emp> getAllEmps();

	void updateEmp(Emp emp);

	void deleteEmp(int empno);
}
