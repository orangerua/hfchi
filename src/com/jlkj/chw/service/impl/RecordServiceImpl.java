/**
 * Project Name:hfchi
 * File Name:RecordServiceImpl.java
 * Package Name:com.jlkj.chw.service.impl
 * Date:2017年11月7日下午9:03:24
 * @author 桔子
 *
 */
package com.jlkj.chw.service.impl;

import java.util.List;

import com.jlkj.chw.dao.RecordDao;
import com.jlkj.chw.entity.Record;
import com.jlkj.chw.entity.User;
import com.jlkj.chw.service.RecordService;

public class RecordServiceImpl implements RecordService {
	public RecordDao recordDao;
	
	public RecordDao getRecordDao() {
		return recordDao;
	}

	public void setRecordDao(RecordDao recordDao) {
		this.recordDao = recordDao;
	}

	@Override
	public boolean recordLogin(Record record) {
		int count=recordDao.insertRecord(record);
		return count>0?true:false;
	}

	@Override
	public List<Record> selectRecordByUser(User user) {
		return recordDao.selectRecord(user);
	}

	@Override
	public List<Record> selectRecordByIp(Record record) {
		// TODO Auto-generated method stub
		return recordDao.selectRecordByIp(record);
	}

}
