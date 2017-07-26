package cn.qianying.graduation.dao.impl;

import org.springframework.stereotype.Repository;

import cn.qianying.graduation.dao.PageContentDao;
import cn.qianying.graduation.domain.PageContent;

@Repository("pageContentDaoImpl")
public class PageContentDaoImpl extends CommonDaoImpl<PageContent> implements PageContentDao<PageContent> {

	@Override
	public void insert(String docTxt) {
		
		PageContent pageContent=new PageContent();
		pageContent.setContent(docTxt);
		save(pageContent);
	}

	
}
