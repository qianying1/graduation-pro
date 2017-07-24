package cn.qianying.graduation.service;

import java.util.List;

import cn.qianying.graduation.domain.AnalizedMessage;

public interface GrabingService {

	public String grabAWebPage(String url);

	public List<AnalizedMessage> listAll();

	public int addRecord(AnalizedMessage analizedMessage);

	public int saveOrUpdate(AnalizedMessage analizedMessage);

	public AnalizedMessage getDetail(String id);

}
