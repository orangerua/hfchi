/**
 * Project Name:hfchi
 * File Name:RecordAction.java
 * Package Name:com.jlkj.chw.action
 * Date:2017年11月7日下午9:35:55
 * @author 桔子
 *
 */
package com.jlkj.chw.action;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jlkj.chw.entity.Record;
import com.jlkj.chw.entity.User;
import com.jlkj.chw.service.RecordService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class RecordAction extends ActionSupport{
	public Record record;
	public User user;
	public RecordService recordService;
	public String jsonstr;
	public List<Record> list;
	public int pagenum;
	public int size;
	
	
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<Record> getList() {
		return list;
	}
	public void setList(List<Record> list) {
		this.list = list;
	}
	public String getJsonstr() {
		return jsonstr;
	}
	public void setJsonstr(String jsonstr) {
		this.jsonstr = jsonstr;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Record getRecord() {
		return record;
	}
	public void setRecord(Record record) {
		this.record = record;
	}
	public RecordService getRecordService() {
		return recordService;
	}
	public void setRecordService(RecordService recordService) {
		this.recordService = recordService;
	}
	public String getLoginRecord(){

		list=recordService.selectRecordByUser(user);
		System.out.println(list.size());
		JSONArray json=JSONArray.fromObject(list);
		jsonstr=json.toString();
		System.out.println(jsonstr);
		return "json";	
	}
	public String getRecordDetail(){
	size=5;
	pagenum=1;
		PageHelper.startPage(pagenum,size);
		list=recordService.selectRecordByIp(record);
		PageInfo<Record> page=new PageInfo<Record>(list,size);
		JSONObject json=JSONObject.fromObject(page);
		jsonstr=json.toString();
		System.out.println(jsonstr);
		return "json";
		
	}
	

}
