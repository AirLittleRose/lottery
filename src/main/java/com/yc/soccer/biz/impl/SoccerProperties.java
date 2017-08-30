package com.yc.soccer.biz.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.yc.utils.LogUtil;


/**
 * 继承自Properties的自定义的键值对类.
 * 它的功能是负责读取  db.properties文件，将这个文件的内容存放到内存中去. 
 * 要求:  1. 对于这样的配置文件，只需读取一次  ->  单例
 *      2.  db.properties如何读取   ?   
 *      	->  MyProperties继承自 Properties, Properties中有load( InputStream  )
 *         	-> Inputstream要指定  要读取  db.properties的位置: 
 *                   C:\Documents and Settings\Administrator\桌面\testjdbc\bin\db.properties
 *         	->问题: 如何保证这个文件的位置是相对的呢   -> 反射.
 *
 */
public class SoccerProperties extends Properties {
	private static SoccerProperties instance = new SoccerProperties();
     
	private SoccerProperties(){
		//因为构造方法至少会执行一次，所以在这里应该完成读取  db.properties文件的代码
		//InputStream iis=new FileInputStream(    "C:\Documents and Settings\Administrator\桌面\testjdbc\bin\db.properties"    );
		InputStream iis= SoccerProperties.class.getClassLoader().getResourceAsStream("soccerAPI.properties");  
		try {
			load(    iis     );   //load是继承自  Properties
		} catch (IOException e) {
			LogUtil.error(e );
		}finally{
			try {
				iis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static SoccerProperties getInstance(){
		return instance;
	}
	
	public static void main(String[] args){
		SoccerProperties mp=SoccerProperties.getInstance();
		System.out.println(   mp.get("key")   );   // get也是继承自Properties
	}
}
