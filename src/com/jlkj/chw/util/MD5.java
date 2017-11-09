/**
 * Project Name:hfchi
 * File Name:MD5.java
 * Package Name:com.jlkj.chw.util
 * Date:2017年11月6日上午11:30:38
 * @author 桔子
 *
 */
package com.jlkj.chw.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class MD5 {
	public static String from(String password) {
		String sec = "";
		MessageDigest msg;
		try {
			msg = MessageDigest.getInstance("md5");
			byte[] md5 = msg.digest(password.getBytes());
			BASE64Encoder encoder = new BASE64Encoder();
			sec = encoder.encode(md5);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return sec;
	}
}
