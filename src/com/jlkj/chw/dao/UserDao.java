/**
 * Project Name:hfchi
 * File Name:UserDao.java
 * Package Name:com.jlkj.chw.dao
 * Date:2017年11月6日上午10:02:59
 * @author 桔子
 *
 */
package com.jlkj.chw.dao;

import com.jlkj.chw.entity.User;

public interface UserDao {
	public int selectUserByUserName(User user);
	public User selectUser(User user);
	public int insertUser(User user);
	public int updateHead(User user);
}
