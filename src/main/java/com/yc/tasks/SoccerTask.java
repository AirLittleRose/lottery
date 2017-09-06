package com.yc.tasks;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.yc.dao.BaseDao;
import com.yc.soccer.bean.Game;
import com.yc.soccer.bean.Jczq_result;
import com.yc.soccer.bean.League;
import com.yc.soccer.bean.Team;
import com.yc.soccer.bean.XMLBean;
import com.yc.soccer.biz.GameBiz;
import com.yc.soccer.biz.Jczq_resultBiz;
import com.yc.soccer.biz.LeagueBiz;
import com.yc.soccer.biz.TeamBiz;

@Component
public class SoccerTask {
	
	@Resource(name="baseDao")
	private BaseDao baseDao; 
	
	@Resource(name = "gameBizImpl")
	private GameBiz gameBiz;
	
	@Resource(name="leagueBizImpl")
	private LeagueBiz leagueBiz;
	
	@Resource(name="teamBizImpl")
	private TeamBiz teamBiz;

	@Resource(name="jczq_resultBizImpl")
	private Jczq_resultBiz jb;
	
	private List<XMLBean> xmls = new ArrayList<XMLBean>();	
	
	//爬到数据,解析对象List,插入数据库(有冗余数据)
	public void addInfo() {
		this.parse();
		this.baseDao.save(XMLBean.class, "addInfo", xmls);
	}
	
	//通过插入的信息Info,更新"联赛"信息表
	public void saveLeague() {
		this.leagueBiz.saveLeague();
	}
	
	//通过插入的信息Info,更新"球队"信息表
	public void saveTeam() {
		this.teamBiz.addTeams();
	}
	
	//通过插入的信息Info,更新"比赛"信息表
	public void savaGame() {
		this.gameBiz.savaGame();
	}

	//保存开奖结果
	public void saveResult() {
		List<Jczq_result> list = this.paser2Result();
		jb.addResult(list);
	}
	
	//开奖,匹配中奖的注
	public void openJczqLottery() {
		this.jb.openJczqLottery();
	}
	/**
	 * 获取信息,遍历,解析成list
	 */
	private void parse() {
        try {
        	//获取信息
        	 SAXReader reader = new SAXReader();                
             Document document = reader.read(this.getInfo());
			//获取根结点元素对象
			Element root = document.getRootElement();  
			//遍历结点
			this.listNodes(root);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 遍历
	 * @param node
	 */
	private void listNodes(Element node){ 
        if("row".equals(node.getName())) {
        	List<Attribute> list = node.attributes();
        	XMLBean xml = new XMLBean();
        	for(Attribute attribute : list){  
        		if("xid".equals(attribute.getName())) {
        			xml.setXid(attribute.getText());
        		}
        		if("oddsmid".equals(attribute.getName())) {
        			xml.setOddsmid(attribute.getText());
        		}
        		if("oh".equals(attribute.getName())) {
        			xml.setOh(attribute.getText());
        		}
        		if("od".equals(attribute.getName())) {
        			xml.setOd(attribute.getText());
        		}
        		if("oa".equals(attribute.getName())) {
        			xml.setOa(attribute.getText());
        		}
        		if("lid".equals(attribute.getName())) {
        			xml.setLid(attribute.getText());
        		}
        		if("ln".equals(attribute.getName())) {
        			xml.setLn(attribute.getText());
        		}
        		if("sid".equals(attribute.getName())) {
        			xml.setSid(attribute.getText());
        		}
        		if("htid".equals(attribute.getName())) {
        			xml.setHtid(Integer.parseInt(attribute.getText()));
        		}
        		if("hn".equals(attribute.getName())) {
        			xml.setHn(attribute.getText());
        		}
        		if("gtid".equals(attribute.getName())) {
        			xml.setGtid(Integer.parseInt(attribute.getText()));
        		}
        		if("gn".equals(attribute.getName())) {
        			xml.setGn(attribute.getText());
        		}
        		if("mtime".equals(attribute.getName())) {
        			xml.setMtime(attribute.getText());
        		}
        		if("cl".equals(attribute.getName())) {
        			xml.setCl(attribute.getText());
        		}
        		
        	}  
        	xmls.add(xml);
        }
        //同时迭代当前节点下面的所有子节点  
        //使用递归  
        Iterator<Element> iterator = node.elementIterator();  
        while(iterator.hasNext()){  
            Element e = iterator.next();  
            listNodes(e);  
        }  
    }
	
	// 获取信息String
	public File getInfo() {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String uri = "http://yjcp.com/data/sp/jczq/odds.xml";
		HttpGet get = new HttpGet(uri);
		UrlEncodedFormEntity uefEntity;
		File file = null;
		try {
			CloseableHttpResponse response = httpclient.execute(get);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					String info = EntityUtils.toString(entity, "GBK");
					file = this.saveInfo(info);
				}
			} finally {
				response.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}

	
	private File saveInfo(String info) {
		
		File file = new File("info.xml");
		Writer writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"GBK"));
			writer.write(info);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}

	
	private List<Jczq_result> paser2Result() {
		List<Jczq_result> list = new ArrayList<Jczq_result>();
		long yesterday = new Date().getTime()-24*60*60*1000;
		String date = new SimpleDateFormat("yyyy-MM-dd").format(yesterday);
		String prev = date.substring(2, 4)+date.substring(5, 7)+date.substring(8, 10);
		try {
			org.jsoup.nodes.Document doc = Jsoup.connect("http://live.caipiao.163.com/jcbf/?date=" + date).get();
			org.jsoup.select.Elements gameList = doc.getElementById("gameList").children();
			for(int i=0; i<gameList.size(); i++) {
				//比分
				String[] score = gameList.get(i).attr("score").split(":");
				//结果
				int result = 0;
				if(Integer.parseInt(score[0]) > Integer.parseInt(score[1])) {
					result = 0;
				}else if(Integer.parseInt(score[0]) == Integer.parseInt(score[1])) {
					result = 1;
				}else {
					result = 2;
				}
				String game_id = "";
				if(i<10) {
					game_id = "00"+(i+1);
				}else if(i >= 10 && i<100) {
					game_id = "0"+(i+1);
				}else {
					game_id = (i+1)+"";
				}
				Jczq_result jr = new Jczq_result();
				jr.setGame_id(prev + game_id);
				jr.setHome_score(Integer.parseInt(score[0]));
				jr.setAway_score(Integer.parseInt(score[1]));
				jr.setResult(result);
				list.add(jr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
