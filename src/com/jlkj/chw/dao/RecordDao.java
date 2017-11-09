/**
 * Project Name:hfchi
 * File Name:RecordDao.java
 * Package Name:com.jlkj.chw.dao
 * Date:2017年11月7日下午8:56:09
 * @author 桔子
 *
 */
package com.jlkj.chw.dao;

import java.util.List;

import com.jlkj.chw.entity.Record;
import com.jlkj.chw.entity.User;

public interface RecordDao {
	public int insertRecord(Record record); 
	public List<Record> selectRecord(User user);
	public List<Record> selectRecordByIp(Record record);
}
