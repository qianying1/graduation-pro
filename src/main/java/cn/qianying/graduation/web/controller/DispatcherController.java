package cn.qianying.graduation.web.controller;

import java.util.ArrayList;
import java.util.List;
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
	public String goUserIndex(Map<String, Object> params){
		
		List<String> param=new ArrayList<String>();
		param.add("helloworld!");
		param.add("textjewk");
		param.add("djfjskjf");
		param.add("hrdsrdsgr");
		params.put("testMap",param);
		params.put("webpage", grabingServiceImpl.grabAWebPage("http://www.youku.com/"));
		return PageMapper.SHOW_ANALIZE;
	}
}
