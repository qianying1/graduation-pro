package cn.qianying.graduation.support;

public class GrabingWeb {

	private String webName;
	private String url;

	public GrabingWeb(String webName, String url) {
		super();
		this.setWebName(webName);
		this.setUrl(url);
	}

	public String getWebName() {
		return webName;
	}

	public void setWebName(String webName) {
		this.webName = webName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
