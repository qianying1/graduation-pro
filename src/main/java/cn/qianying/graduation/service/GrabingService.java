package cn.qianying.graduation.service;

import java.io.IOException;
import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.qianying.graduation.domain.AnalizedMessage;

public interface GrabingService{

	public String grabAWebPage(String url);

	public List<AnalizedMessage> listAll();

	public int addRecord(AnalizedMessage analizedMessage);

	public int saveOrUpdate(AnalizedMessage analizedMessage);

	public AnalizedMessage getDetail(String id);

	@Transactional(propagation=Propagation.REQUIRED)
	public void grabAWebPageAndGetMsg(String webName,String webUrl) throws IOException;


}
