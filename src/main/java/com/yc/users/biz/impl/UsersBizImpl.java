package com.yc.users.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.dao.BaseDao;
import com.yc.users.bean.Manager;
import com.yc.users.bean.Users;
import com.yc.users.biz.UsersBiz;
import com.yc.utils.Encrypt;

@Service
@Transactional
public class UsersBizImpl implements UsersBiz {
	@Resource(name="baseDao")
	private BaseDao baseDao;
	
	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)	
	public Users login(Users users) {
		users.setPassword(Encrypt.md5AndSha(users.getPassword()));
		Users us = (Users) this.baseDao.findOne(users, "getUserByLogin");
		return us;
	}

	/**
	 * 判断用户名是否被占用
	 */
	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public Users isUsernameExist(Users users) {
		Users us = (Users) this.baseDao.findOne(users, "isUsernameExist");
		return us;
	}
	
	/**
	 * 用户注册
	 */
	@Override
	public void saveUser(Users users) {
		users.setPassword(Encrypt.md5AndSha(users.getPassword()));
		this.baseDao.save(users, "saveUser");
	}

	/**
	 * 根据输入的用户名查找用户的所有信息,主要查邮箱
	 */
	@Override
	public Users forgetPassword(Users users) {
		Users us = (Users) this.baseDao.findOne(users, "isUsernameExist");
		return us;
	}
	
	/**
	 * 用户忘记密码时用来生成url的数据插入用户表中
	 */
	public boolean updateForMess(Users users){		
		baseDao.update(users, "addUserForPass");
		return true;
	}
	
	/**
	 * 用户修改密码
	 * @param users
	 * @return
	 */
	public boolean updateForPass(Users users){
		users.setPassword(Encrypt.md5AndSha(users.getPassword()));
		baseDao.update(users, "UserUpdatePass");
		return true;
	}
	
	/**
	 * 管理员登录
	 */
	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)	
	public Manager manaLogin(Manager manager) {
		manager.setPwd(manager.getPwd());
		Manager mg = (Manager) this.baseDao.findOne(manager, "getManager");
		return mg;
	}



}
