package cn.qianying.graduation.support;

import java.util.ArrayList;
import java.util.List;

/**
 * 边和节点组合成的一个图结构
 * 
 * @author qianying
 *
 */
public class WebGraph {

	private List<WebPageNode> nodes = null;

	public void initGraph(List<GrabingWeb> grabingWebs) {
		
		if (nodes == null) {
			nodes = new ArrayList<WebPageNode>();
		}

		WebPageNode reginNode = new WebPageNode("0", false);
		
		WebPageNode node = null;
		for (int i = 1; i <= grabingWebs.size(); i++) {
			
			node = new WebPageNode(String.valueOf(i), false);
			node.setWebName(grabingWebs.get(i-1).getWebName());
			
			UrlEdge urlEdge = new UrlEdge(reginNode, node, grabingWebs.get(i - 1).getUrl());
			reginNode.getEdgeList().add(urlEdge);
			nodes.add(node);
		}
		nodes.add(reginNode);
	}

	public WebGraph(List<GrabingWeb> grabingWebs) {

		initGraph(grabingWebs);
	}

	public List<WebPageNode> getGraphNodes() {
		return nodes;
	}

}
