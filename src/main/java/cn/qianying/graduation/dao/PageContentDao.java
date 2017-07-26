package cn.qianying.graduation.dao;

import cn.qianying.graduation.domain.PageContent;

public interface PageContentDao<T> extends CommonDao<PageContent>{

	void insert(String docTxt);

}
