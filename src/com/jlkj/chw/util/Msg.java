/**
 * Project Name:hfchi
 * File Name:Msg.java
 * Package Name:com.jlkj.chw.util
 * Date:2017年11月6日下午4:30:56
 * @author 桔子
 *
 */
package com.jlkj.chw.util;

import net.sf.json.JSONObject;

public class Msg {
	public static String toJson(String msg) {
		JSONObject json = new JSONObject();
		json.put("msg", msg);
		return json.toString();
	}
}
