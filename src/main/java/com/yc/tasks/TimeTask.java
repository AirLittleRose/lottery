package com.yc.tasks;

import java.text.SimpleDateFormat;
import java.util.Date;

//@Component
public class TimeTask {
	
	public void test1() {
		System.out.println("job 开始执行" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}
	
}
