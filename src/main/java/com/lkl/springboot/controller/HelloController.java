package com.lkl.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lkl.springboot.po.User;
/**
 * 
* Title: HelloController
* Description: 
* @Controller：修饰class，用来创建处理http请求的对象
@RestController：Spring4之后加入的注解，原来在@Controller中返回json需要@ResponseBody来配合，如果直接用@RestController替代@Controller就不需要再配置@ResponseBody，默认返回json格式。
@RequestMapping：配置url映射
* @author HuangJian
* @date 2017年9月15日
*
 */
@RestController
public class HelloController {

	@Autowired
	public User user;
	
	@RequestMapping("/index")
	public String index(){
		System.out.println("/index method");
		return "abc";
	}
	@RequestMapping("/userinfo/{name}")
	public String userInfo(@PathVariable("name") String name){
		if(user!= null){
			System.out.println(user.toString());
		}else{
			System.out.println("user obj null");
		}
		
		
		return user.toString();
	}
	
	
}
