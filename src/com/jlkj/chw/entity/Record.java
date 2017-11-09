/**
 * Project Name:hfchi
 * File Name:Record.java
 * Package Name:com.jlkj.chw.entity
 * Date:2017年11月7日下午8:49:16
 * @author 桔子
 *
 */
package com.jlkj.chw.entity;

import java.util.Date;

public class Record {
	public int recordId;
	public User user;
	public String ip;
	public String address;
	public Date loginDate;
	public int status;
	public int getRecordId() {
		return recordId;
	}
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
