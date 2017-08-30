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
import com.yc.soccer.jsonModel.MatchInfo;
import com.yc.soccer.jsonModel.GameJson;
import com.yc.soccer.jsonModel.TeamJson;

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
	public int getGamesCount(Game game) {
		return (int) baseDao.getFunc(game, "getGamesCount");
	}

	@Override
	public void savaGame() {
		baseDao.save(new Game(), "savaGame");
	}

	
	
//	
//	
//	/**
//	 * 获取比赛列表
//	 * @param league_id
//	 * @return
//	 */
//	private List<Game> getGames(int league_id) {
//		Reader reader = null;
//		try {
//			File file = this.getInfoFile(league_id);
//			List<Game> list = new ArrayList<Game>();
//			reader = new FileReader(file);
//			Gson gson = new Gson();
//			GameJson tj = gson.fromJson(reader, GameJson.class);
//			for (Game game : tj.getResult()) {
//				list.add(game);
//			}
//			return list;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//	
//	/**
//	 * (POST)请求数据前的参数配置
//	 */
//	private String getAPIInfo(int league_id) {
//		String info = "";
//		// 1.创建默认的httpClient实例.
//		CloseableHttpClient httpclient = HttpClients.createDefault();
//
//		// 2.创建httppost httpGet
//		HttpPost httppost = new HttpPost("http://v.juhe.cn/football/query_schedule.php");
//
//		// 3.创建参数队列
//		List formparams = new ArrayList();
//
//		formparams.add(new BasicNameValuePair("key", SoccerProperties.getInstance().getProperty("key")));
//		formparams.add(new BasicNameValuePair("league_id", String.valueOf(league_id)));
//		formparams.add(new BasicNameValuePair("season_id", new SimpleDateFormat("yyyy").format(new Date())));
//		// 4.创建参数对象,将参数队列存入对象中
//		UrlEncodedFormEntity uefEntity;
//		try {
//			uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
//			// 5.Post请求方式的设置参数
//			httppost.setEntity(uefEntity);
//			// 6.发出请求,得到HttpResponse对象
//			CloseableHttpResponse response = httpclient.execute(httppost);
//			try {
//				// 7.获取正文信息
//				HttpEntity entity = response.getEntity();
//
//				if (entity != null) {
//					// 使用EntityUtil将其转为字符串
//					info = EntityUtils.toString(entity, "UTF-8");
//				}
//			} finally {
//				// 8.关流
//				response.close();
//			}
//		} catch (ClientProtocolException e) {
//			e.printStackTrace();
//		} catch (UnsupportedEncodingException e1) {
//			e1.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			// 关闭连接,释放资源
//			try {
//				httpclient.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		return info;
//	}
//	
//	/**
//	 * 获取信息文件
//	 * @param league_id
//	 * @return
//	 */
//	private File getInfoFile(int league_id){
//		File file = new File("soccerInfo", "gameInfo_" + league_id + ".txt");
//		if(!file.getParentFile().exists()) {
//			file.getParentFile().mkdirs();
//		}
//		if(!file.exists()) {
//			try {
//				file.createNewFile();
//				String info = this.getAPIInfo(league_id);
//				file = this.saveInfo(league_id, info);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		return file;
//	}
//	
//	/**
//	 * 保存信息
//	 * @param league_id
//	 * @param info
//	 * @return
//	 */
//	private File saveInfo(int league_id, String info) {
//		File file = new File("soccerInfo", "gameInfo_" + league_id + ".txt");
//		Writer writer = null;
//		try {
//			writer = new FileWriter(file);
//			writer.write(info);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				writer.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		return file;
//	}
//
//


}
