package com.lkl.springboot.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lkl.springboot.dao.DepartmentRepository;
import com.lkl.springboot.po.Department;
import com.lkl.springboot.service.DepartmentService;

import junit.framework.Assert;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTestsController {

	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private DepartmentRepository departmentRepository;
	/**
	* Title: ApplicationTestsController.java
	* Description: 测试的时候就不调用业务层了，
	* @author HuangJian
	* @date 2017年9月16日
	*/
	@Test
	public void test(){
		
		/*Integer d1 = departmentService.saveDepa(new Department("事业部",1003));
		System.out.println(d1);
		
		departmentRepository.save(new Department("安全部", 1002));
		*/
		
		Department department =null;
		department =  departmentRepository.findByDepaName("事业部");
		System.out.println(department.toString());
		
		department = departmentRepository.findByDepaNameAndDepaNo("财务部", 1007);
		if(null != department){
			System.out.println(department.toString());
		}
		
		int updRes = departmentRepository.updateByDepaId("财务部update", 1007, 1);
		System.out.println("修改后："+updRes);
		department = departmentRepository.getByDepaId(1);
		System.out.println(department.toString());
		
	}
}
