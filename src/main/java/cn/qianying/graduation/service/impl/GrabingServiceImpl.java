package cn.qianying.graduation.service.impl;

import java.io.IOException;

import org.springframework.stereotype.Service;

import cn.qianying.graduation.service.GrabingService;
import cn.qianying.graduation.util.GrabWebsiteUtil;

@Service("grabingServiceImpl")
public class GrabingServiceImpl implements GrabingService {

	@Override
	public String grabAWebPage(String url) {
		
		String webpageContent = null;
		GrabWebsiteUtil grabWebsiteUtil=new GrabWebsiteUtil(url);
		try {
			webpageContent=grabWebsiteUtil.getWebpage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return webpageContent;
	}

}
