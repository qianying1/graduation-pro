package cn.qianying.graduation.service;

import java.io.IOException;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface GrabingService{

	public String grabAWebPage(String url);

	@Transactional(propagation=Propagation.REQUIRED)
	public void grabAWebPageAndGetMsg(String webName,String webUrl) throws IOException;

	void grabWeb(String webName, String webUrl) throws IOException;


}
