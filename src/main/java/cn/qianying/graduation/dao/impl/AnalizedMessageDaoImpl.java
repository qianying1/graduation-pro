package cn.qianying.graduation.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.qianying.graduation.dao.AnalizedMessageDao;
import cn.qianying.graduation.domain.AnalizedMessage;
@Repository("analizedMessageDaoImpl")
public class AnalizedMessageDaoImpl extends CommonDaoImpl<AnalizedMessage> implements AnalizedMessageDao {

	@Override
	public List<AnalizedMessage> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

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
