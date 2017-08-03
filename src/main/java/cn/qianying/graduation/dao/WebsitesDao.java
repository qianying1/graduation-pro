package cn.qianying.graduation.dao;

import cn.qianying.graduation.domain.WebSites;

public interface WebsitesDao extends CommonDao<WebSites> {

	boolean acfunIsInserted(String webUrl);

}
