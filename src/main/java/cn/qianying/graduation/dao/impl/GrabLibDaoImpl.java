package cn.qianying.graduation.dao.impl;

import org.springframework.stereotype.Repository;

import cn.qianying.graduation.dao.GrabLibDao;
import cn.qianying.graduation.domain.AnalizedMessage;
import cn.qianying.graduation.domain.GrabLib;

@Repository("grabLibDaoImpl")
public class GrabLibDaoImpl extends CommonDaoImpl<GrabLib> implements GrabLibDao {

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
