package com.yc.tasks;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.yc.ssq.jsonModel.SsqJson;

public class SsqTask {

	/**
	 * 1.创建httpClient
	 * 2.创建请求方式HttpPost/HttpGet 放入请求的URL
	 * 3.如果是POST方式,创建参数List,添加参数
	 * 4.将List参数列表转化为HttpEntity
	 * 5.将HttpEntity作为参数设置到POST请求参数中
	 * 6.httpclient发出请求  (execute方法)
	 * 7.获取响应HttpResponse对象,取到响应正文HttpEntity,使用EntityUtil将其转为String
	 * 8.关流(切记)
	 */
	public SsqJson ssq_httpClient(String date) {
		// 1.创建默认的httpClient实例.
		CloseableHttpClient httpclient = HttpClients.createDefault();
		
		// 2.创建httppost httpGet
		HttpPost httppost = new HttpPost("http://apis.haoservice.com/lifeservice/lottery/query");		
		
		// 3.创建参数队列
		List formparams = new ArrayList();

		formparams.add(new BasicNameValuePair("key", "65cea716ff9a491088b4f2f43f3ae421"));
		formparams.add(new BasicNameValuePair("id", "1"));
		formparams.add(new BasicNameValuePair("date", date));
		
		SsqJson sj = null;
		//4.创建参数对象,将参数队列存入对象中
		UrlEncodedFormEntity uefEntity;
		try {
			uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
			
			// 5.Post请求方式的设置参数
			httppost.setEntity(uefEntity);
			
			
			System.out.println("executing request " + httppost.getURI());
			
			//6.发出请求,得到HttpResponse对象
			CloseableHttpResponse response = httpclient.execute(httppost);
			
			try {
				//7.获取正文信息
				HttpEntity entity = response.getEntity();
				
				if (entity != null) {
					//使用EntityUtil将其转为字符串
					String info = EntityUtils.toString(entity, "UTF-8");
					System.out.println("--------------------------------------");
					System.out.println("Response content: " + info);
					
					Gson gson = new Gson();
					sj = gson.fromJson(info, SsqJson.class);
					System.out.println("--------------------------------------");
					System.out.println(sj.toString());
				}
			} finally {
				
				//8.关流
				response.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭连接,释放资源
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sj;
	}
	
	public SsqJson ssq_history(String year) {
		// 1.创建默认的httpClient实例.
		CloseableHttpClient httpclient = HttpClients.createDefault();
		
		// 2.创建httppost httpGet
		HttpPost httppost = new HttpPost("http://apis.haoservice.com/lifeservice/lottery/history");
		
		
		
		// 3.创建参数队列
		List formparams = new ArrayList();

		formparams.add(new BasicNameValuePair("key", "65cea716ff9a491088b4f2f43f3ae421"));
		formparams.add(new BasicNameValuePair("id", "1"));
		formparams.add(new BasicNameValuePair("year", year));
		
		SsqJson sj = null;
		
		//4.创建参数对象,将参数队列存入对象中
		UrlEncodedFormEntity uefEntity;
		try {
			uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
			
			// 5.Post请求方式的设置参数
			httppost.setEntity(uefEntity);
			
			
			System.out.println("executing request " + httppost.getURI());
			
			//6.发出请求,得到HttpResponse对象
			CloseableHttpResponse response = httpclient.execute(httppost);


			try {
				//7.获取正文信息
				HttpEntity entity = response.getEntity();
				
				if (entity != null) {
					//使用EntityUtil将其转为字符串
					String info = EntityUtils.toString(entity, "UTF-8");
					System.out.println("--------------------------------------");
					System.out.println("Response content: " + info);
					
					Gson gson = new Gson();
					sj = gson.fromJson(info, SsqJson.class);
					System.out.println("--------------------------------------");
					System.out.println(sj.toString());
				}
			} finally {
				
				//8.关流
				response.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭连接,释放资源
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sj;
	}
}
