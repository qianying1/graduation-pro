package cn.qianying.graduation.support;

/**
 * 使用广度优先遍历时使用的url地址边
 * @author qianying
 *
 */
public class UrlEdge {

	private WebPageNode nodeParent;
	
	private WebPageNode nodeChild;
	
	private String url;
	
	/**
	 * 边的父端
	 * @param nodeParent
	 * 边的子端
	 * @param nodeChild
	 */
	public UrlEdge(WebPageNode nodeParent,WebPageNode nodeChild,String url){
		this.nodeParent=nodeParent;
		this.nodeChild=nodeChild;
		this.url=url;
	}

	public WebPageNode getNodeParent() {
		return nodeParent;
	}

	public void setNodeParent(WebPageNode nodeParent) {
		this.nodeParent = nodeParent;
	}

	public WebPageNode getNodeChild() {
		return nodeChild;
	}

	public void setNodeChild(WebPageNode nodeChild) {
		this.nodeChild = nodeChild;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
