package com.lkl.springboot.scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	/**
	* Title: ScheduledTasks.java
	* Description: 
	* @Scheduled详解

在上面的入门例子中，使用了@Scheduled(fixedRate = 5000) 注解来定义每过5秒执行的任务，对于@Scheduled的使用可以总结如下几种方式：

@Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行
@Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行
@Scheduled(initialDelay=1000, fixedRate=5000) ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次

	* @author HuangJian
	* @date 2017年9月22日
	*/
	//@Scheduled(cron="*/5 * * * * *") ：通过cron表达式定义规则
	@Scheduled(fixedRate=5000)
	public void reportCurrentTime(){
		
		System.out.println("现在时间："+sdf.format(new Date()));
		
		
		
	}
}
