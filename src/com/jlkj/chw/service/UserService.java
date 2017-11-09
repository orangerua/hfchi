/**
 * Project Name:hfchi
 * File Name:UserService.java
 * Package Name:com.jlkj.chw.service
 * Date:2017年11月6日上午10:04:21
 * @author 桔子
 *
 */
package com.jlkj.chw.service;

import com.jlkj.chw.entity.User;

public interface UserService {
	public boolean checkUserName(User user);
	public boolean register(User user);
	public User login(User user);
	public boolean updateHead(User user);
}
