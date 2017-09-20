package com.lkl.springboot.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.criterion.Example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lkl.springboot.dao.DepartmentRepository;
import com.lkl.springboot.po.Department;
import com.lkl.springboot.service.DepartmentService;

import javassist.runtime.Desc;



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
	* JpaRepository:
	* save(User user) 如果ID存在则update操作
	* save(List<User> users)
	* 
	* delete(User user)
	* delete(Long id)
	* 
	* 
	* 
	* @author HuangJian
	* @date 2017年9月16日
	*/
	//@Test
	public void test(){
		List<Department> data = new ArrayList<Department>();
		data.add(new Department("财务部update",1007));
		data.add(new Department("业务部save", 1001));
		data.add(new Department("事业部", 1003));
		data.add(new Department("安全部", 1002));
		//departmentRepository.save(data);
		
		/*Integer d1 = departmentService.saveDepa(new Department("事业部",1003));
		System.out.println(d1);*/
		
		//departmentRepository.save(new Department("安全防御部", 1006));
		
		
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
		
		/*List<Department> list = departmentRepository.findOrderByDepaId();
		System.out.println(list.toString());*/
		List<Department> list = departmentRepository.findAll(new Sort(Sort.Direction.DESC, "depaId"));
		System.out.println(list.toString());
		
		department =  departmentRepository.save(new Department(2L,"业务部save",1001));
		System.out.println("更新成功:");
		System.out.println(department.toString());
		
		//findOne 不存在对象不为空，属性各个都是是null
		//findOne 不存在对象为null
		//报错，未完成
		/*System.out.println("findOne():");
		department = departmentRepository.findOne(4L);
		
		System.out.println(department.toString());*/
	}
	
	/**
	* Title: ApplicationTestsController.java
	* Description: 分页
	* @author HuangJian
	* @date 2017年9月18日
	*/
	@Test
	public void findPage(){
		List<Department> list = null;
		Department department= null;
		Page<Department> listPage = null;
		Pageable pageable = new PageRequest(0, 3);
		listPage = departmentRepository.findAll(pageable);
		Iterator<Department> iterator =  listPage.iterator();
		while(iterator.hasNext()){
			Department d = iterator.next();
			System.out.println(d.toString());
		}
		System.out.println(listPage.getSize());
		department = departmentRepository.save(new Department(4L,"安全部update", 1002));//updateByDepaId();
		System.out.println("修改结果为："+department.toString());
	}
}
