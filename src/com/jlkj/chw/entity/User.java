/**
 * Project Name:hfchi
 * File Name:User.java
 * Package Name:com.jlkj.chw.entity
 * Date:2017年11月6日上午10:02:13
 * @author 桔子
 *
 */
package com.jlkj.chw.entity;

public class User {
	public int userId;
	public String userName;
	public String password;
	public String head;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	
}
