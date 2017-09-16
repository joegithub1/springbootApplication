package com.lkl.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/html")
public class TemplatesController {

	@RequestMapping(value ="/tl/html",method = RequestMethod.GET)
	public String htmlIndex(ModelMap model){
		//System.out.println("ok");
		model.addAttribute("host", "www.myjian.win");
		return "index";
	}
	@RequestMapping("/herror")
	public String error() throws Exception{
		throw new Exception("发生错误");
	}
	
}
