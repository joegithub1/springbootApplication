package com.lkl.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@RequestMapping("/hello")
	public String sayHello(){
		System.out.println("method:sayHello()");
		
		return "Hello xx";
	}
}
