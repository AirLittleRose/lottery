package com.yc.utils;


import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.yc.users.bean.Users;



public class MailUtil {


    public static void sendMail(Users users) throws Exception{  
        JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();  
  
        // 设定mail 邮箱服务器地址  
        senderImpl.setHost("smtp.163.com");  
        senderImpl.setPort(25);   // 默认情况下没有开启SSL协议，所以端口默认为25，可以不设置
  
        // 建立邮件消息,发送简单邮件和html邮件的区别   
        //org.springframework.mail.javamail.MimeMessageHelper是处理JavaMail比较顺手的组件之一，可以让你摆脱繁复的JavaMail API
        ///这是通过senderImp得到邮箱的信息
        MimeMessage mailMessage = senderImpl.createMimeMessage();  
        
      //封装mimeMessage
        MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage);  
  
        // 设置收件人，寄件人  
        messageHelper.setTo(users.getEmail());  
        messageHelper.setFrom("renrenlecp@163.com");  
        messageHelper.setSubject("测试HTML邮件！");  
        // true 表示启动HTML格式的邮件  
        messageHelper  
                .setText(  
                        "<html><head></head><body><h5>hello!!spring html Mail</h5></body></html>",  
                        true);  
  
        senderImpl.setUsername("renrenlecp@163.com"); // 根据自己的情况,设置username 
        // 163邮箱必须要用授权码进行校验    
        senderImpl.setPassword("renrenlecp123"); // 根据自己的情况, 设置password  
        
        Properties prop = new Properties();  
        prop.put("mail.smtp.auth", "true"); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确  
        prop.put("mail.smtp.timeout", "25000"); 
        prop.put("mail.debug", "true");
        senderImpl.setJavaMailProperties(prop);  
        // 发送邮件  
        senderImpl.send(mailMessage);  
  
        System.out.println("邮件发送成功..");  
    }  


	}



