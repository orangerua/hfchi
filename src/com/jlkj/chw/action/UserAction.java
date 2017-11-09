/**
 * Project Name:hfchi
 * File Name:UserAction.java
 * Package Name:com.jlkj.chw.action
 * Date:2017年11月6日上午10:11:37
 * @author 桔子
 *
 */
package com.jlkj.chw.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.jlkj.chw.entity.Record;
import com.jlkj.chw.entity.User;
import com.jlkj.chw.service.RecordService;
import com.jlkj.chw.service.UserService;
import com.jlkj.chw.util.Code;
import com.jlkj.chw.util.Email;
import com.jlkj.chw.util.Msg;
import com.jlkj.chw.util.Phone;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.xml.internal.stream.buffer.sax.SAXBufferProcessor;

public class UserAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	public User user;
	public UserService userService;
	public RecordService recordService;
	public String email;
	public String phone;
	public String code;
	public Record record;
	public String jsonstr;
	//上传头像用的
	private File pic;
	private String picContentType;
	private String picFileName;
	private String savePath;
	

	public File getPic() {
		return pic;
	}
	public void setPic(File pic) {
		this.pic = pic;
	}
	public String getPicContentType() {
		return picContentType;
	}
	public void setPicContentType(String picContentType) {
		this.picContentType = picContentType;
	}
	public String getPicFileName() {
		return picFileName;
	}
	public void setPicFileName(String picFileName) {
		this.picFileName = picFileName;
	}
	public String getSavePath() {
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public String emailCode(){
		String msg="";
		System.out.println(email);
		code=Code.get();
		try {
			Email.send(email, code);
			session.put(email, code);
			msg="发送成功";
		} catch (Exception e) {
			msg="网络故障,发送验证码失败";
			e.printStackTrace();
		}
		jsonstr=Msg.toJson(msg);
		return "msg";
	}
	public String phoneCode(){
		String msg="";
		System.out.println(phone);
		code=Code.get();
		try {
			Phone.sendSms(phone, code);
			session.put(phone, code);
			msg="发送成功";
		} catch (Exception e) {
			msg="网络故障,发送验证码失败";
			e.printStackTrace();
		}
		jsonstr=Msg.toJson(msg);
		return "msg";
	}
	public String checkUserName(){
		String msg="用户名已被注册";
		boolean flag=userService.checkUserName(user);
		if(flag)
		{
			msg="用户名可以使用";
		}
		jsonstr=Msg.toJson(msg);
		return "msg";
	}
	public String emailRegister() {
		if(code.equals(session.get(user.getUserName())))//判断验证码是否正确
		{
			
		}
		
		return "msg";
	}

	public String phoneRegister() {
		System.out.println("st");
		System.out.println(user.getUserName()+"  "+user.getPassword());
		String msg="注册成功";
		if(code.equals(session.get(user.getUserName()))==false)//判断验证码是否正确
		{
			msg="验证码错误";
		}else{
			boolean flag=userService.register(user);
			System.out.println(flag);
			if(!flag){
				msg="注册失败";
			}
		}
		jsonstr=Msg.toJson(msg);
		return "msg";
	}

	public String login() {
		user=userService.login(user);
		if(user!=null){
			session.put("loginUser", user);
			Record a=new Record();
			a.setUser(user);
		
			a.setIp(record.getIp());
			a.setAddress(record.getAddress());
			recordService.recordLogin(a);
			return "loginsuccess";
		}
		return "error";
	}
	public String updatehead(){
		FileOutputStream fos=null;
		FileInputStream fis=null;
		    try {
		    	//文件输出
				fos= new FileOutputStream(this.getSavePath()+"\\"+this.getPicFileName());
			 	fis=new FileInputStream (this.getPic());
				byte[] buffer = new  byte[1024];
				int len  =0;
				while ((len=fis.read(buffer))>0){
					fos.write(buffer,0,len);
				}
				 String filname=picFileName;
				 user.setHead(filname);
				 userService.updateHead(user);
				    
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try{
				fos.close();
				fis.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		return "headsuccess";
	}
	
	/**
	 * 下载流操作
	 * @return
	 */
	public InputStream getInputStream(){
		return ServletActionContext.getServletContext().getResourceAsStream("/upload/"+picFileName);
	}
	public String download(){
		return "headsuccess";
	}
	
	

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getJsonstr() {
		return jsonstr;
	}
	public void setJsonstr(String jsonstr) {
		this.jsonstr = jsonstr;
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
	
}
