package com.lkl.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lkl.springboot.dao.DepartmentRepository;
import com.lkl.springboot.po.Department;
import com.lkl.springboot.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Long saveDepa(Department department) {
		department = departmentRepository.save(department);
		return department.getDepaId();
	}

}
