/**
 * Project Name:hfchi
 * File Name:RecordService.java
 * Package Name:com.jlkj.chw.service
 * Date:2017年11月7日下午9:02:05
 * @author 桔子
 *
 */
package com.jlkj.chw.service;

import java.util.List;

import com.jlkj.chw.entity.Record;
import com.jlkj.chw.entity.User;

public interface RecordService {
	public boolean recordLogin(Record record);
	public List<Record> selectRecordByUser(User user);
	public List<Record> selectRecordByIp(Record record);
}
