package cn.qianying.graduation.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import cn.qianying.graduation.dao.WebsitesDao;
import cn.qianying.graduation.domain.WebSites;

@Repository("websitesDaoImpl")
public class WebsitesDaoImpl extends CommonDaoImpl<WebSites> implements WebsitesDao {

	@Override
	public boolean acfunIsInserted(String webUrl) {

		SqlSession session = sqlSessionFactory.openSession();
		String webName = session.selectOne("selectOneWebSite", webUrl);
		session.close();
		if (null != webName) {

			return true;
		}
		return false;
	}

}
