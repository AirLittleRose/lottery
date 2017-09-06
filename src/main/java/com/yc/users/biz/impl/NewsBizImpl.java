package com.yc.users.biz.impl;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.dao.BaseDao;
import com.yc.users.bean.News;
import com.yc.users.biz.NewsBiz;
import com.yc.web.model.JsonModel;


@Service
@Transactional
public class NewsBizImpl implements NewsBiz{
	
	@Resource(name="baseDao")
	private BaseDao baseDao;
	

	public void putData() throws IOException{
		Document doc = Jsoup.connect("http://cai.163.com/").get();
    	Elements links = doc.select("div.headLine a");
    	Object[] link = links.toArray(new Object[links.size()]);   //把Element转化为Object数组   	
    	News news = new News();
    	
    	for(Object a : link){
    		news.setNews(a.toString());    		
    		this.baseDao.save(news, "saveNews");	    		
    	}
	}

	
	@Override
	public JsonModel<News> searchNews() {
		News news = new News();
		List<News> list = baseDao.findAll(news, "getNews");
		
		JsonModel<News> jsonModel = new JsonModel<News>();
		jsonModel.setRows(list);
		return jsonModel;
	}

	@Scheduled(cron="0 0 */1 * * ?")   //每隔一小时news表清空
	@Override
	public void cleanNews() {
		this.baseDao.update(News.class, "cleanNews");
	}

}
