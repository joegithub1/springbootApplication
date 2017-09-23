package com.lkl.springboot.controller;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lkl.springboot.dao.StudentRepository;
import com.lkl.springboot.po.Student;

/**
* Title: JapTransactionalController
* Description: 测试事物
* @author HuangJian
* @date 2017年9月22日
*
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JapTransactionalController {

	@Autowired
	private StudentRepository  studentRepository;
	
	/**
	* Title: JapTransactionalController.java
	* Description: 测试不使用事物
	* 其中一条报错 CCCCCCCCCCCCCCCCCC，DDD没有插入
	* 
	* @author HuangJian
	* @date 2017年9月22日
	*/
	//@Test
	public void test(){
		
		studentRepository.save(new Student("AAA", 10));
		studentRepository.save(new Student("BBB", 20));
		studentRepository.save(new Student("CCCCCCCCCCCCCCCCCC", 30));
		studentRepository.save(new Student("DDD", 40));
		
	}
	
	
	
	/**
	* Title: JapTransactionalController.java
	* Description: 测试事物
	* @author HuangJian
	* @date 2017年9月22日
	*/
	@Test
	//@Transactional
	public void testTran(){
		studentRepository.save(new Student("AAA", 10));
		studentRepository.save(new Student("BBB", 20));
		//都回滚
		//studentRepository.save(new Student("CCCCCCCCCCCCCCCCCC", 30));
		//正常都插入
		studentRepository.save(new Student("CCC", 30));
		studentRepository.save(new Student("DDD", 40));
	}
	
}
