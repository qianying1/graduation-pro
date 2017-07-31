package cn.qianying.graduation.support;

import java.util.ArrayList;
import java.util.List;

public class WebPageNode {

	// 设置一个遍历节点,以url地址为边
	private List<UrlEdge> edgeList = null;

	private boolean isVisited = false;
	private String docContent;
	private String webName;

	private String label;

	public WebPageNode() {

		super();
	}

	public WebPageNode(String label, boolean isVisited) {
		this.label = label;
		this.isVisited = isVisited;
	}

	/**
	 * 给当前节点添加一条边 WebPageNode
	 * 
	 * @param urlEdge
	 */
	public void addEdgeList(UrlEdge urlEdge) {
		getEdgeList().add(urlEdge);
	}

	public String getLabel() {

		return label;
	}

	public List<UrlEdge> getEdgeList() {
		if (getEdgeList() == null) {
			setEdgeList(new ArrayList<UrlEdge>());
		}
		return edgeList;
	}

	public void setEdgeList(List<UrlEdge> edgeList) {
		this.edgeList = edgeList;
	}

	public String getDocContent() {
		return docContent;
	}

	public void setDocContent(String docContent) {
		this.docContent = docContent;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public String getWebName() {
		return webName;
	}

	public void setWebName(String webName) {
		this.webName = webName;
	}
}
