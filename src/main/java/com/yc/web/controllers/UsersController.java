package com.yc.web.controllers;


import java.io.IOException;
import java.sql.Timestamp;
import java.util.UUID;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yc.users.bean.Users;
import com.yc.users.biz.NewsBiz;
import com.yc.users.biz.UsersBiz;
import com.yc.utils.Encrypt;
import com.yc.web.model.JsonModel;


@RestController //类注解,同时使用@Controller 和 @ResponseBody
public class UsersController {
	@Resource(name = "usersBizImpl")
	private UsersBiz usersBiz;		
	
	//@Resource(name = "javaMailSenderImpl")
	private JavaMailSenderImpl mailSender;		
	
	@RequestMapping("/users_login.action")
	public JsonModel login(Users users,HttpServletRequest request,HttpSession session){
		JsonModel jsonModel = new JsonModel();
			try {
				users = usersBiz.login(users);
				if(users!=null){
					session.setAttribute("users", users);
					jsonModel.setCode(1);
					users.setPassword(null);;  //设为空后,密码就不会传到
					jsonModel.setObj(users);
				}else{
					jsonModel.setCode(0);
					jsonModel.setMsg("用户名或密码错误");
				}
			} catch (Exception e) {
				e.printStackTrace();
				jsonModel.setCode(0);
				jsonModel.setMsg(e.getMessage());
			}
		
		return jsonModel;
	}

	@RequestMapping("/users_getLoginUser.action")
	public JsonModel users_getLoginUser(HttpSession session){
		JsonModel jm = new JsonModel();
		
		if(session.getAttribute("users")!=null){
			jm.setCode(1);
			Users us =  (Users) session.getAttribute("users");
			us.setPassword(null);
			jm.setObj(us);
		}else{
			jm.setCode(0);
			jm.setMsg("用户还没有登录");
		}
		return jm;
	}
	
	@RequestMapping("users_logout.action")
	public void logout(HttpSession session,HttpServletResponse response){
		session.removeAttribute("users");
		try {
			response.sendRedirect("index.action");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//注册↓
	//注册时判断用户名是否存在
	@RequestMapping("/user_isUsernameExist.action")
	public JsonModel isUsernameExist(Users users){
		 JsonModel jsonModel = new JsonModel();
		 try {
			Users us = usersBiz.isUsernameExist(users);
			 if(us==null){
				 jsonModel.setCode(1);
			 }else{
				 jsonModel.setCode(0);
			 }
		} catch (Exception e) {
			e.printStackTrace();
			jsonModel.setCode(0);
			jsonModel.setMsg(e.getMessage());
		}
		 return jsonModel;
	}
	
	//添加新用户
	@RequestMapping("/user_register.action")
	public JsonModel register(Users users,HttpServletRequest request,HttpSession session){
		JsonModel jsonModel = new JsonModel();			
		try {
			usersBiz.saveUser(users);  
			jsonModel.setCode(1);
		} catch (Exception e) {
			e.printStackTrace();
			jsonModel.setCode(0);
			jsonModel.setMsg(e.getMessage());
		}
		return jsonModel;
	}
	
	//忘记密码↓发送邮件	
	@RequestMapping("/user_forpass.action")
	public JsonModel user_forpass(Users users,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws Exception{
		JsonModel jm = new JsonModel();				
		users = usersBiz.forgetPassword(users);
		if(users!=null){
			session.setAttribute("users", users);			
			MimeMessage message = mailSender.createMimeMessage();
			 try {
				MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");		 
				
				String secretKey = UUID.randomUUID().toString();  //密钥
				Timestamp outDate = new Timestamp(System.currentTimeMillis()+10*60*1000);//10分钟后过期
				long date = outDate.getTime()/1000*1000;                  //忽略毫秒数
				
				users.setValidataCode(secretKey);
				users.setOutDate(outDate);					
				usersBiz.updateForMess(users);  //存入数据库
				
				String key = users.getUsername()+"$"+date+"$"+secretKey;
				String digitalSignature = Encrypt.md5(key);  //加密后的数字签名,uid
								
				Users us = (Users) session.getAttribute("users");
				//设置发件人/收件人信息
				helper.setFrom(mailSender.getUsername());
				helper.setTo(us.getEmail());		        
				helper.setSubject("人人乐彩票提醒您:设置新密码!"); 
				
				String path = request.getContextPath();
				String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
				String resetPassHref =  basePath+"user_reset_password.action?uid="+digitalSignature+"&username="+us.getUsername();
				// true 表示启动HTML格式的邮件  
				helper.setText("请勿回复本邮件.点击下面的链接,重设密码<br/><a href="+resetPassHref +" >点击我重新设置密码</a>" +
	                    "<br/>注意:本邮件超过10分钟,链接将会失效，需要重新申请<br/>"+"<br/>链接无法打开,可将此地址复制到地址栏内尝试一次:<br/><a href="+resetPassHref +">"+resetPassHref
						,true);  
				mailSender.send(message);				
				jm.setCode(1);
				jm.setObj(users);	
			} catch (Exception e) {
				e.printStackTrace();
			}		        
		}else{
			jm.setCode(0);
			jm.setMsg("邮件发送失败");
		}
		return jm;
	}
	
	//以下为链接检验代码，验证通过 跳转到修改密码界面,否则跳转到失败界面
	@RequestMapping(value="/user_reset_password.action",method=RequestMethod.GET)
	public void checkResetLink(		 @RequestParam("uid") String uid, 
									 @RequestParam("username") String username,
									 HttpServletRequest req,
									 HttpServletResponse resp,
									 HttpSession session
									 ) throws ServletException, IOException {
		JsonModel jm = new JsonModel();	
		if(uid.equals("") || username.equals("")){
	           jm.setCode(0);
	           jm.setMsg("链接不完整,请重新生成");
		}
		Users us = new Users();
		us.setUsername(username);
		Users users = usersBiz.isUsernameExist(us);  //根据get方法发来的参数去数据库查询,url的数据
		if(users == null){
	           jm.setCode(0);
	           jm.setMsg("链接错误,无法找到匹配用户,请重新申请找回密码。");
	     }
		 Timestamp outDate = users.getOutDate();
		 if(outDate.getTime() <= System.currentTimeMillis()){ //过期了
			 jm.setCode(0);
	         jm.setMsg("链接已经过期,请重新申请找回密码。");
		 }
		 String key = users.getUsername()+"$"+outDate.getTime()/1000*1000+"$"+users.getValidataCode();
		 String digitalSignature = Encrypt.md5(key);  //加密后的数字签名 uid
		 if(!digitalSignature.equals(uid)){
			 jm.setCode(0);
	         jm.setMsg("链接不正确,是否已经过期了?重新申请吧。");
		 }
		 jm.setCode(1);
		 jm.setMsg("跳转页面");				
		 req.getRequestDispatcher("/WEB-INF/pages/resetPass.jsp").forward(req, resp);
		 return;	 
	}
	
	//修改密码操作
	@RequestMapping("user_updatePass.action")
	public JsonModel updatePass(Users users,HttpSession session,HttpServletRequest request){
		JsonModel jm = new JsonModel();
		if(users!=null){
			usersBiz.updateForPass(users);
			jm.setCode(1);
			jm.setMsg("密码修改成功");
		}else{
			jm.setCode(0);
			jm.setMsg("密码修改失败");
		}
		return jm;
	}

	
}
