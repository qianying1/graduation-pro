package cn.qianying.graduation.dao;

import cn.qianying.graduation.domain.AnalizedMessage;

public interface GrabMessageDao {

	public int addRecord(AnalizedMessage analizedMessage);

	public int saveOrUpdate(AnalizedMessage analizedMessage);

	public AnalizedMessage getDetail(String id);
}
