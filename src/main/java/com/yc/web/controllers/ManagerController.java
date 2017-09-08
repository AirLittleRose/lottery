package com.yc.web.controllers;

import java.io.IOException;
import java.sql.Date;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.yc.users.bean.Annos;
import com.yc.users.bean.Manager;
import com.yc.users.bean.Users;
import com.yc.users.biz.UsersBiz;
import com.yc.web.model.JsonModel;

@RestController 
public class ManagerController {
	@Resource(name = "usersBizImpl")
	private UsersBiz usersBiz;	
	
		//管理员登录
		@RequestMapping("/mana_login.action")
		public JsonModel manalogin(Manager manager,HttpServletRequest request,HttpSession session){
			JsonModel jsonModel = new JsonModel();
				try {
					manager = usersBiz.manaLogin(manager);
					if(manager!=null){
						session.setAttribute("manager", manager);
						jsonModel.setCode(1);
						manager.setPwd(null); //设为空后,密码就不会传到
						jsonModel.setObj(manager);
					}else{
						jsonModel.setCode(0);
						jsonModel.setMsg("管理员名或密码错误");
					}
				} catch (Exception e) {
					e.printStackTrace();
					jsonModel.setCode(0);
					jsonModel.setMsg(e.getMessage());
				}		
			return jsonModel;
		}
		
	
		//管理员登录跳转页面
		@RequestMapping("/managemain.action")
		public void toManage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			request.getRequestDispatcher("/WEB-INF/pages/managemain.jsp").forward(request, response);
		}
		
		@RequestMapping("/addNews.action")
		public void toAddNews(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			request.getRequestDispatcher("/WEB-INF/pages/addNews.jsp").forward(request, response);
		}
		
		//上传图片
		@RequestMapping("/uploadSinglePic.action")
		public void toUploadImage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			request.getRequestDispatcher("/user/uploadSinglePic.jsp").forward(request, response);
		}
		
		//
		@RequestMapping("/showAnnos.action")
		public JsonModel toAnnos(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			JsonModel jm = new JsonModel();			
			String sign =request.getParameter("sign");			
			Annos annos = new Annos();
			annos.setSign(sign);
			Annos as = usersBiz.isAnnosExist(annos);
			session.setAttribute("as", as);
			if(as!=null){
				jm.setCode(1);				
			}else{
				jm.setCode(0);
			}	
			return jm;
		}
		
		//添加公告
		@RequestMapping("/newsAdd.action")
		public JsonModel doAddNews(Manager manager,Annos annos,HttpSession session,HttpServletRequest request){
			JsonModel jsonModel = new JsonModel();
			try {
				//这个request 是jspsmartupload组件的request 对象，而不是j2ee的HttpServletRequest
				//spsmartupload组件的request对象是继承HttpServletRequest
				String title=request.getParameter("title");	
				String content = request.getParameter("content");
				String auth=((Manager)request.getSession().getAttribute("manager")).getMname();			
				Date adate = new java.sql.Date(new java.util.Date().getTime());
								
				annos.setTitle("<a onclick='earnVal(this)'>"+title+"</a>");
				annos.setContent(content);
				annos.setAuth(auth);
				annos.setAdate(adate);
				annos.setSign(title);
				
				usersBiz.saveAnno(annos);				
				jsonModel.setCode(1);
			} catch (Exception e) {
				e.printStackTrace();
				jsonModel.setCode(0);
				jsonModel.setMsg(e.getMessage());
			}	
			return jsonModel;
		}

}
