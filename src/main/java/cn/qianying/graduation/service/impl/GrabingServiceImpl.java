package cn.qianying.graduation.service.impl;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qianying.graduation.domain.AnalizedMessage;
import cn.qianying.graduation.dao.AnalizedMessageDao;
import cn.qianying.graduation.dao.GrabMessageDao;
import cn.qianying.graduation.service.GrabingService;
import cn.qianying.graduation.util.GrabWebsiteUtil;

@Service("grabingServiceImpl")
public class GrabingServiceImpl implements GrabingService {

	@Autowired
	AnalizedMessageDao analizedMessageDaoImpl;
	@Autowired
	GrabMessageDao grabMessageDaoImpl;

	@Override
	public List<AnalizedMessage> listAll() {
		return analizedMessageDaoImpl.listAll();
	}

	@Override
	public int addRecord(AnalizedMessage analizedMessage) {
		return analizedMessageDaoImpl.addRecord(analizedMessage);
	}

	@Override
	public int saveOrUpdate(AnalizedMessage analizedMessage) {
		return analizedMessageDaoImpl.saveOrUpdate(analizedMessage);
	}

	@Override
	public AnalizedMessage getDetail(String id) {
		return analizedMessageDaoImpl.getDetail(id);
	}

	@Override
	public String grabAWebPage(String url) {

		String webpageContent = null;
		GrabWebsiteUtil grabWebsiteUtil = new GrabWebsiteUtil(url);
		try {
			webpageContent = grabWebsiteUtil.getWebpage();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return webpageContent;
	}

	@Override
	public void grabAWebPageAndGetMsg(String webName,String webUrl) throws IOException {
		
		Document doc=Jsoup.connect(webUrl).timeout(5000).get();
		Element body=doc.body();
		String docTxt=body.text();
		
		
		
		Elements ahrefEls=doc.select("a");
		
		for(Element ahrefEl:ahrefEls){
			
			System.out.println(ahrefEl.attr("abs:href")+"\n"+ahrefEl.text());
		}
		
	}

}
