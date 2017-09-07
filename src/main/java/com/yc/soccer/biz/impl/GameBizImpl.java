package com.yc.soccer.biz.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.yc.dao.BaseDao;
import com.yc.soccer.bean.Game;
import com.yc.soccer.bean.Team;
import com.yc.soccer.biz.GameBiz;


@Service
@Transactional
public class GameBizImpl implements GameBiz {
	
	@Resource(name="baseDao")
	private BaseDao baseDao;
	
	@Override
	public List<Game> findGames(Game game) {
		List<Game> list = new ArrayList<Game>();
		list = baseDao.findAll(game, "findGames");
		return list;
	}

	@Override
	public void savaGame() {
		try {
			baseDao.save(new Game(), "savaGame");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	

}
