package com.lkl.springboot.async;


import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@EnableAsync
public class TaskApplication {

	@Autowired
	private Task task;
	
	/**
	* Title: TaskApplication.java
	* Description: 
	* 同步结果
开始任务一
完成任务一，耗时：3589
开始任务二
完成任务二，耗时：6885
开始任务三
完成任务三，耗时：9530
	* 
	* 
	* @throws InterruptedException
	* @author HuangJian
	* @date 2017年9月23日
	*/
	@Test
	public void test() throws InterruptedException{
		long start =System.currentTimeMillis();
		Future<String> task1= task.doTaskOne();
		Future<String> task2= task.doTaskTow();
		Future<String> task3= task.doTaskThree();
		//System.out.println(task);
		while(true){
			if(task1.isDone()&&task2.isDone()&&task3.isDone()){
				break;
			}
			Thread.sleep(1000);
		}
		
		long end = System.currentTimeMillis();
		
		System.err.println("任务完成总耗时："+(end-start)+"毫秒");
	}
	
}
