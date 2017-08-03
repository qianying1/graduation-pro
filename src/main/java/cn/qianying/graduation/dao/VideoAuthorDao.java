package cn.qianying.graduation.dao;

import cn.qianying.graduation.domain.VideoAuthor;

public interface VideoAuthorDao extends CommonDao<VideoAuthor> {

	int insert(VideoAuthor videoAuthor);

}
