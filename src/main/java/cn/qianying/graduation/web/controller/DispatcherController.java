package cn.qianying.graduation.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.qianying.graduation.service.GrabingService;
import cn.qianying.graduation.util.PageMapper;

@RequestMapping(value="/dispatcher")
@Controller
public class DispatcherController {

	@Autowired
	private GrabingService grabingServiceImpl;
	@RequestMapping(value="/userIndex")
	public String goUserIndex(){
		
		return PageMapper.INDEX;
	}
	
	@RequestMapping(value="/beginningGrab")
	public String doGrabWebsites(Map<String, Object> params){
		
		params.put("webpage", grabingServiceImpl.grabAWebPage("http://www.youku.com/"));
		return PageMapper.SHOW_ANALIZE;
	}
}
