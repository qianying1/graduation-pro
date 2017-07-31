package cn.qianying.graduation.service.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import cn.qianying.graduation.service.CommonService;
import cn.qianying.graduation.support.WebPageNode;

public class CommonServiceImpl implements CommonService {

	/**
	 * 广度优先搜索 BFSearch
	 * 
	 * @param node
	 *            搜索的入口节点
	 */
	@Override
	public void searchTraversing(WebPageNode node) {
		List<WebPageNode> visited = new ArrayList<WebPageNode>(); // 已经被访问过的元素
		Queue<WebPageNode> q = new LinkedList<WebPageNode>(); // 用队列存放依次要遍历的元素
		q.offer(node);

		while (!q.isEmpty()) {
			WebPageNode currNode = q.poll();
			if (!visited.contains(currNode)) {
				visited.add(currNode);
				System.out.println("节点：" + currNode.getLabel());
				for (int i = 0; i < currNode.getEdgeList().size(); i++) {
					// q.offer(currNode.getEdgeList().get(i).getNodeRight());
				}
			}
		}
	}

	/**
	 * 广度优先搜索 BFSearch
	 * 
	 * @param node
	 *            搜索的入口节点
	 */
	@Override
	public void bfWebSearching() {

	}

}
