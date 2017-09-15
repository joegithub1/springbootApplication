package com.lkl.springboot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@RequestMapping("/{name}")
	public String sayHello(@PathVariable("name") String name){
		System.out.println("method:sayHello()");
		
		return "Hello :"+name;
	}
}
