package cn.qianying.graduation.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
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
	public void doGrabWebsites(Map<String, Object> params, HttpServletResponse response) throws IOException {

		Runnable thread=new Runnable() {
			
			@Override
			public void run() {
				try {
					grabingWeb();
				} catch (IOException e) {
					Logger.getLogger(this.getClass()).log("IOException", null, e.getMessage(), e);
				}
			}
		};
		thread.run();

		response.setContentType("text/html");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		out = response.getWriter();

		out.print("success");
		out.flush();
		out.close();
//		return PageMapper.INDEX;
	}
	
	private void grabingWeb() throws IOException{
		
		Properties properties = new Properties();
		InputStream in = this.getClass().getResourceAsStream(webSiteResource);

		properties.load(in);
		Set<String> webs = properties.stringPropertyNames();
		Object[] webStrs = webs.toArray();
		
		for (Object webName1 : webStrs) {

			String webName = (String) webName1;
			String webUrl = properties.getProperty(webName);
			grabingServiceImpl.grabAWebPageAndGetMsg(webName, webUrl);
		}
	}
	
}
