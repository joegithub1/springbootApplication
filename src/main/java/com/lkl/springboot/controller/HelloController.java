package com.lkl.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lkl.springboot.po.User;

@RestController
public class HelloController {

	@Autowired
	public User user;
	
	@RequestMapping("/index")
	public String index(){
		
		return "index";
	}
	@RequestMapping("/user/{name}")
	public String userInfo(@PathVariable("name") String name){
		if(user!= null){
			System.out.println(user.toString());
		}else{
			System.out.println("user obj null");
		}
		
		
		return user.toString();
	}
}
