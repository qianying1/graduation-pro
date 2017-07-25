package cn.qianying.graduation.mapper;

import cn.qianying.graduation.domain.AnalizedMessage;

public interface GrabLibMapper {

	public int addRecord(AnalizedMessage analizedMessage);

	public int saveOrUpdate(AnalizedMessage analizedMessage);

	public AnalizedMessage getDetail(String id);
}
