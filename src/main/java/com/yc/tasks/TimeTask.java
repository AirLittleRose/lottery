package com.yc.tasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TimeTask {
	
	 @Scheduled(cron = "0/5 20-40 9 ? * TUE,WED,THU")
	public void test1() {
		System.out.println("job 开始执行" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}
	
}
