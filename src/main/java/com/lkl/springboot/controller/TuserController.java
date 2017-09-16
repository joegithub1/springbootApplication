package com.lkl.springboot.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lkl.springboot.po.Tuser;
import com.lkl.springboot.service.UserService;


@Controller
@RequestMapping("/u")
public class TuserController {

	@Autowired
	private UserService userService;
	//去添加页面
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(){
		
		return "/userManager/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String postUser(Tuser user,Model model){
		System.out.println(user.toString());
		Integer res = userService.create(user);
		
		
		return "redirect:/u/list";
	}
	@RequestMapping("/list")
	public String list(Model model){
		Integer userCount = userService.getAllCount();
		List<Tuser> users =  userService.findUser();
		model.addAttribute("users", users);
		model.addAttribute("userCount", userCount);
		
		return "/userManager/list";
	}
	@RequestMapping("/del/{id}")
	public String delete(@PathVariable("id") Integer id){
		System.out.println(id);
		
		return "/userManager/list";
	}
	
}
