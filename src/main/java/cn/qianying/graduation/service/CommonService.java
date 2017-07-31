package cn.qianying.graduation.service;

import cn.qianying.graduation.support.WebPageNode;

public interface CommonService {

	/**
	 * 广度优先遍历
	 * @param node
	 * 			搜索的入口节点
	 */
	public void searchTraversing(WebPageNode node);

	void bfWebSearching();
}
