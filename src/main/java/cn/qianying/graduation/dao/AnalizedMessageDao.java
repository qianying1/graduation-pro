package cn.qianying.graduation.dao;

import java.util.List;

import cn.qianying.graduation.domain.AnalizedMessage;

public interface AnalizedMessageDao extends CommonDao<AnalizedMessage>{

public List<AnalizedMessage> listAll();
	
	public int addRecord(AnalizedMessage analizedMessage);
	
	public int saveOrUpdate(AnalizedMessage analizedMessage);
	
	public AnalizedMessage getDetail(String id);
}
