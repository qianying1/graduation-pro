package cn.qianying.graduation.dao;

import cn.qianying.graduation.domain.AnalizedMessage;
import cn.qianying.graduation.domain.GrabMessage;

public interface GrabMessageDao extends CommonDao<GrabMessage>{

	public int addRecord(AnalizedMessage analizedMessage);

	public int saveOrUpdate(AnalizedMessage analizedMessage);

	public AnalizedMessage getDetail(String id);
}
