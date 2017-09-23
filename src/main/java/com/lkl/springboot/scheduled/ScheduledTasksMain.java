package com.lkl.springboot.scheduled;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
* Title: ScheduledTasksMain
* Description: 定时任务主函数
* @author HuangJian
* @date 2017年9月22日
*
*/
@SpringBootApplication
@EnableScheduling
public class ScheduledTasksMain {

	public static void main(String[] args) {
		SpringApplication.run(ScheduledTasksMain.class, args);
	}
}
