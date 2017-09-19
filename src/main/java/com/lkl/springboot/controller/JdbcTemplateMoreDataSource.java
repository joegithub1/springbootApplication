package com.lkl.springboot.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lkl.springboot.po.Department;

/**
* Title: JdbcTemplateMoreDataSource
* Description: JdbcTemplate多数据源测试
* @author HuangJian
* @date 2017年9月19日
*
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JdbcTemplateMoreDataSource {

	/*@Autowired
	@Qualifier("primaryJdbcTemplate")
	private JdbcTemplate jdbcTemplatePrimary;*/
	/**
	 * primaryJdbcTemplate 名称要与DataSourceConfig.java的@bean方法名称一样
	 * 如果不一样则加Qualifier(这里的名称与DataSourceConfig.java的@bean方法名称一样)
	 * 
	 * 
	 */
	//数据源一 imooc
	@Autowired
	private JdbcTemplate primaryJdbcTemplate;
	
	//数据源二 imooc2
	@Autowired
	@Qualifier("secondaryJdbcTemplate")
	private JdbcTemplate jdbcTemplateSecondary;
	
	/**
	* Title: JdbcTemplateMoreDataSource.java
	* Description: jdbcTemplate多数据源
	* @author HuangJian
	* @date 2017年9月19日
	*/
	@Test
	public void test(){
		
		System.out.println(primaryJdbcTemplate);
		
		System.out.println(jdbcTemplateSecondary);
		
		String sql="insert into t_department(depa_name,depa_no,depa_status) values(?,?,?)";
		Department department = new Department(null,"测试部门", 10009, 0);
		int s1 = primaryJdbcTemplate.update(sql, department.getDepaName(),department.getDepaNo(),department.getStatus());
		
		
		int s2 = jdbcTemplateSecondary.update(sql, department.getDepaName(),department.getDepaNo(),department.getStatus());
		
		System.out.println("数据源一结果："+s1+"\n"+"数据源二结果："+s2);
		
	}
	
	
}
