package com.yc.tasks;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
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
import org.springframework.stereotype.Component;

import com.yc.dao.BaseDao;
import com.yc.soccer.bean.Game;
import com.yc.soccer.bean.League;
import com.yc.soccer.bean.Team;
import com.yc.soccer.bean.XMLBean;
import com.yc.soccer.biz.GameBiz;
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

	private List<XMLBean> xmls = new ArrayList<XMLBean>();	
	
	
	public void addInfo() {
		this.parse();
		this.baseDao.save(XMLBean.class, "addInfo", xmls);
	}
	
	public void saveLeague() {
		this.leagueBiz.saveLeague();
	}
	
	public void saveTeam() {
		this.teamBiz.addTeams();
	}
	
	public void savaGame() {
		this.gameBiz.savaGame();
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
	private File getInfo() {
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
					String info = EntityUtils.toString(entity, "gb2312");
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
			writer = new FileWriter(file);
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
}
