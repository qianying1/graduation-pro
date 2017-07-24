package cn.qianying.graduation.mapper;

import java.util.List;

import cn.qianying.graduation.domain.AnalizedMessage;

public interface AnalizedMessageMapper {

public List<AnalizedMessage> listAll();
	
	public int addRecord(AnalizedMessage analizedMessage);
	
	public int saveOrUpdate(AnalizedMessage analizedMessage);
	
	public AnalizedMessage getDetail(String id);
}
