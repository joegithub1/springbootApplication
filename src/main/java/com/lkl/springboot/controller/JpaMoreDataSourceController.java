package com.lkl.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lkl.springboot.dao.TeacherRepository;
import com.lkl.springboot.dao.UserRepository;
import com.lkl.springboot.entity.Message;
import com.lkl.springboot.po.Teacher;
import com.lkl.springboot.repository.MessageRepository;

/**
* Title: JpaMoreDataSourceController
* Description: jpa多数据源测试
* @author HuangJian
* @date 2017年9月20日
*
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JpaMoreDataSourceController {

	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired
	private MessageRepository messageRepository;
	/**
	* Title: JpaMoreDataSourceController.java
	* Description: 
	* 数据源一： dao , po
	* 数据源二：repositor,entity
	* 
	* @author HuangJian
	* @date 2017年9月20日
	*/
	@Test
	public void test(){
		List<Teacher> teachers = new ArrayList<Teacher>();
		teachers.add(new Teacher(null,"zhangsan",18));
		teachers.add(new Teacher(null,"lisi",28));
		//teacherRepository.save(teachers);
		System.out.println("教师总数："+teacherRepository.findAll().size());
		Teacher t = teacherRepository.findOne(10L);
		if(null != t){
			System.out.println("findOne:"+t.toString());
		}
		
		List<Message> messages = new ArrayList<Message>();
		messages.add(new Message(null,"新闻1","中国新闻1"));
		messages.add(new Message(null,"新闻2","中国新闻2"));
		messages.add(new Message(null,"新闻3","中国新闻3"));
		//messageRepository.save(messages);
		System.out.println("信息总数："+messageRepository.findAll().size());
		//报错需要懒加载
		//Message m  = messageRepository.getOne(1L);
		//System.out.println("getOne:"+m.toString());
		
	}
}
