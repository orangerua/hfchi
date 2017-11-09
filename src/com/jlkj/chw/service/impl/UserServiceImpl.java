/**
 * Project Name:hfchi
 * File Name:UserServiceImpl.java
 * Package Name:com.jlkj.chw.service.impl
 * Date:2017年11月6日上午10:07:13
 * @author 桔子
 *
 */
package com.jlkj.chw.service.impl;

import com.jlkj.chw.dao.UserDao;
import com.jlkj.chw.entity.User;
import com.jlkj.chw.service.UserService;

public class UserServiceImpl implements UserService {
	public UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public boolean register(User user) {
		int count=userDao.insertUser(user);
		return count>0?true:false;
	}
	@Override
	public boolean checkUserName(User user) {
		int count=userDao.selectUserByUserName(user);
		return count>0?false:true;
	}
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.selectUser(user);
	}
	@Override
	public boolean updateHead(User user) {
		// TODO Auto-generated method stub
		int count=userDao.updateHead(user);
		return count>0?true:false;
	}

	
	

}
