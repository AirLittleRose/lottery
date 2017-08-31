package com.yc.users.biz;

import java.io.IOException;

import com.yc.users.bean.News;
import com.yc.web.model.JsonModel;

public interface NewsBiz {
	
	/**
	 * 向数据库中存入新的新闻
	 * @throws IOException
	 */
	public void putData(News news) throws IOException;
	
	
	/**
	 * 查找新闻
	 * @param news
	 * @return
	 */
	public JsonModel<News> searchNews(News news);
	
	public void cleanNews();

}	
