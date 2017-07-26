package cn.qianying.graduation.dao.impl;

import org.springframework.stereotype.Repository;

import cn.qianying.graduation.dao.GrabMessageDao;
import cn.qianying.graduation.domain.AnalizedMessage;
import cn.qianying.graduation.domain.GrabMessage;

@Repository("grabMessageDaoImpl")
public class GrabMessageDaoImpl extends CommonDaoImpl<GrabMessage> implements GrabMessageDao {

	@Override
	public int addRecord(AnalizedMessage analizedMessage) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int saveOrUpdate(AnalizedMessage analizedMessage) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AnalizedMessage getDetail(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
