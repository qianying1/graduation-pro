package cn.qianying.graduation.dao;

import java.util.List;

import cn.qianying.graduation.domain.GrabLib;

public interface GrabLibDao extends CommonDao<GrabLib>{

	public void insert(int contentId, String webName, String ahref, String flag);

	public void inserts(int contentId, String webName, List<String> ahrefList, String flag);

	public boolean isGrabed(String url);
}
