package com.yc.users.biz;

import com.yc.users.bean.Users;

public interface UsersBiz {
	
	/**
	 * 用戶登録
	 * @param users
	 * @return
	 */
	public Users login(Users users);
	
	/**
	 * 用户注册判断用户名是否存在
	 * @param users
	 * @return
	 */
	public Users isUsernameExist(Users users);

	/**
	 * 用户注册
	 * @param users
	 */
	public void saveUser(Users users);
	
	/**
	 * 用户忘记密码,向用户发送重置密码文件
	 * @param users
	 * @return
	 */
	public Users forgetPassword(Users users);
	
	/**
	 * 插入用于生成邮件url所需的数据
	 * @param users
	 * @return
	 */
	public boolean updateForMess(Users users);
	
	/**
	 * 用户修改密码
	 * @param users
	 * @return
	 */
	public boolean updateForPass(Users users);

}	
