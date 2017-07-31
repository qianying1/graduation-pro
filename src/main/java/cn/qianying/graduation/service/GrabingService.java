package cn.qianying.graduation.service;

import java.io.IOException;
import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.qianying.graduation.support.GrabingWeb;

public interface GrabingService{

	public String grabAWebPage(String url);

	@Transactional(propagation=Propagation.REQUIRED)
	public void grabAWebPageAndGetMsg(String webName,String webUrl) throws IOException;

	int grabWeb(String webName, String webUrl) throws IOException;

	void grabWebInBF(List<GrabingWeb> grabingWebs);


}
