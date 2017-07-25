package cn.qianying.graduation.service.impl;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import cn.qianying.graduation.domain.AnalizedMessage;
import cn.qianying.graduation.mapper.AnalizedMessageMapper;
import cn.qianying.graduation.mapper.GrabMessageMapper;
import cn.qianying.graduation.service.GrabingService;
import cn.qianying.graduation.util.GrabWebsiteUtil;

@Service("grabingServiceImpl")
public class GrabingServiceImpl implements GrabingService {

	@Resource
	AnalizedMessageMapper analizedMessageMapper;
	@Resource
	GrabMessageMapper grabMessageMapper;

	@Override
	public List<AnalizedMessage> listAll() {
		return analizedMessageMapper.listAll();
	}

	@Override
	public int addRecord(AnalizedMessage analizedMessage) {
		return analizedMessageMapper.addRecord(analizedMessage);
	}

	@Override
	public int saveOrUpdate(AnalizedMessage analizedMessage) {
		return analizedMessageMapper.saveOrUpdate(analizedMessage);
	}

	@Override
	public AnalizedMessage getDetail(String id) {
		return analizedMessageMapper.getDetail(id);
	}

	@Override
	public String grabAWebPage(String url) {

		String webpageContent = null;
		GrabWebsiteUtil grabWebsiteUtil = new GrabWebsiteUtil(url);
		try {
			webpageContent = grabWebsiteUtil.getWebpage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return webpageContent;
	}

	@Override
	public void grabAWebPageAndGetMsg(String webName,String webUrl) throws IOException {
		
		Document doc=Jsoup.connect(webUrl).timeout(5000).get();
		Element body=doc.body();
		
		Elements ahrefEls=doc.select("a");
		
		for(Element ahrefEl:ahrefEls){
			
			System.out.println(ahrefEl.attr("abs:href"));
		}
		
	}

}
