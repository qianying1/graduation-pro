package cn.qianying.graduation.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.qianying.graduation.service.GrabingService;
import cn.qianying.graduation.util.PageMapper;

@RequestMapping(value = "/dispatcher")
@Controller
public class DispatcherController {

	@Autowired
	private GrabingService grabingServiceImpl;
	private String webSiteResource = "/websites.properties";

	@RequestMapping(value = "/userIndex")
	public String goUserIndex() {

		return PageMapper.INDEX;
	}

	@RequestMapping(value = "/beginningGrab")
	public void doGrabWebsites(Map<String, Object> params,HttpServletResponse response) throws IOException {

		Properties properties = new Properties();
		InputStream in = this.getClass().getResourceAsStream(webSiteResource);

		properties.load(in);
		Set<String> webs = properties.stringPropertyNames();
		Object[] webStrs = webs.toArray();
		for (Object webName1 : webStrs) {

			String webName=(String) webName1;
			String webUrl = properties.getProperty(webName);
			grabingServiceImpl.grabAWebPageAndGetMsg(webName, webUrl);
		}
		
		
	}
}
