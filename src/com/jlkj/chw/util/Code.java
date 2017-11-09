/**
 * Project Name:hfchi
 * File Name:Code.java
 * Package Name:com.jlkj.chw.util
 * Date:2017年11月6日上午10:18:56
 * @author 桔子
 *
 */
package com.jlkj.chw.util;

import java.util.Random;

public class Code {
	public static String get() {
		String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			sb.append(base.charAt(random.nextInt(base.length())));
		}
		return new String(sb);
	}
}
