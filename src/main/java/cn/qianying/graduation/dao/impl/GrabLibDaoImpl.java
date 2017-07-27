package cn.qianying.graduation.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.qianying.graduation.dao.GrabLibDao;
import cn.qianying.graduation.domain.GrabLib;

@Repository("grabLibDaoImpl")
public class GrabLibDaoImpl extends CommonDaoImpl<GrabLib> implements GrabLibDao {

	@Override
	public void insert(int contentId, String webName, String webUrl, String flag) {

		GrabLib grabLib = new GrabLib();
		grabLib.setContentId(contentId);
		grabLib.setWebName(webName);
		grabLib.setWebSiteAddr(webUrl);
		grabLib.setGrabSign(flag);
		save(grabLib);
	}

	@Override
	public void inserts(int contentId, String webName, List<String> ahrefList, String flag) {

		List<GrabLib> grabLibs = new ArrayList<GrabLib>();
		ahrefList = removeTheSameUrl(ahrefList);
		for (String url : ahrefList) {

			if (null == url || url.equals("")) {
				continue;
			}
			GrabLib grabLib = new GrabLib();
			grabLib.setContentId(contentId);
			grabLib.setWebName(webName);
			grabLib.setWebSiteAddr(url);
			grabLib.setGrabSign(flag);
			grabLibs.add(grabLib);
		}
		sqlSessionFactory.openSession().insert("insertGrabLibs", grabLibs);
	}

	private List<String> removeTheSameUrl(List<String> urls) {

		for (int i = 0; i < urls.size() - 1; i++) {
			for (int j = urls.size() - 1; j > i; j--) {
				if (urls.get(j).equals(urls.get(i))) {
					urls.remove(j);
				}
			}
		}
		return urls;
	}

}
