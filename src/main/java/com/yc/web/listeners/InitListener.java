package com.yc.web.listeners;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.yc.ssq.bean.LotteryResult;
import com.yc.ssq.bean.UserSsq;
import com.yc.ssq.biz.UserSsqBiz;
import com.yc.users.biz.NewsBiz;
import com.yc.users.biz.UsersBiz;
import com.yc.web.model.JsonModel;


/**
 * 当servlet容器一启动就会加载这个类,
 *
 */
public class InitListener implements ServletContextListener {
	private ApplicationContext ac;

	public InitListener() {
	}

	public void contextInitialized(ServletContextEvent sce) {
		// 取application
		ServletContext application = sce.getServletContext();
		// 工具类: tomcat启动时-> ContextLoaderListener -> 读取 contextConfigLocation指定的
		// beans.xml -> 加载整个应用程序中的bean ioc, -> di -> context -> 存到application
		// 利用spring提代的 WebApplicationContextUtils类来获取 spring 容器
		ac = WebApplicationContextUtils.getWebApplicationContext(application);

		UserSsqBiz userSsqBiz = (UserSsqBiz) ac.getBean("userSsqBizImpl");
//		try {
//			List<UserSsq> lists = userSsqBiz.findSsqIssue();
//			application.setAttribute("ssqIssueList", lists);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		try {
			List<LotteryResult> list = userSsqBiz.findLottery();
			if(list!=null){
				LotteryResult lr = list.get(0);
				String red = lr.getRedball();
				String r1=red.substring(0, 2);
				String r2=red.substring(3, 5);
				String r3=red.substring(6, 8);
				String r4=red.substring(9, 11);
				String r5=red.substring(12, 14);
				String r6=red.substring(15, 17);
				application.setAttribute("LotteryResultList", list);
				application.setAttribute("RecentLotteryResult", list.get(0));
				application.setAttribute("r1", r1);
				application.setAttribute("r2", r2);
				application.setAttribute("r3", r3);
				application.setAttribute("r4", r4);
				application.setAttribute("r5", r5);
				application.setAttribute("r6", r6);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		//加载资讯
		NewsBiz newsBiz = (NewsBiz) ac.getBean("newsBizImpl");
		try {
			JsonModel jsonModel = newsBiz.searchNews();
			if(jsonModel.getRows().size()==0){			
					newsBiz.putData();						
			}else{				
			}
			JsonModel jm = newsBiz.searchNews();
			application.setAttribute("jsonModel", jm);
			application.setAttribute("list", jm.getRows());
		} catch (IOException e) {
			e.printStackTrace();
		
		}
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}

}
