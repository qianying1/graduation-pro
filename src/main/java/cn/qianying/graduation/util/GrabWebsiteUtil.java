package cn.qianying.graduation.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GrabWebsiteUtil {

	/**
	 * 要分析的网页
	 */
	private String htmlUrl;
	
	/**
	 * 分析结果
	 */
	private ArrayList<String> hrefList=new ArrayList<String>();

	/**
	 * 网页编码方式
	 */
	private String charSet;
	
	public GrabWebsiteUtil(String htmlUrl) {

		this.htmlUrl = htmlUrl;
	}

	/**
	 * 获取链接中的整个页面内容
	 * @return
	 * @throws IOException
	 */
	public String getWebpage() throws IOException {

		StringBuffer buffstr=new StringBuffer();
		URL url = new URL(this.htmlUrl);
		URLConnection connection = url.openConnection();
		HttpURLConnection httpURLConnection = (HttpURLConnection) connection;

		int code = httpURLConnection.getResponseCode();
		if (code == HttpURLConnection.HTTP_OK) {
			System.out.println("find the website");
			InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream(),"UTF-8");

			BufferedReader in = new BufferedReader(inputStreamReader);
			String inputLine;
			
			while((inputLine=in.readLine())!=null){
				
				System.out.println(inputLine);
				buffstr.append(inputLine);
			}
			in.close();
			inputStreamReader.close();
			
		}else{
			System.out.println("Can not grab a website");
		}
		return buffstr.toString();
	}

	public String getAnalizeMsg() {

		return "";
	}

	public String getHtmlUrl() {
		return htmlUrl;
	}

	public void setHtmlUrl(String htmlUrl) {
		this.htmlUrl = htmlUrl;
	}


	/**
	 * 获取 分析结果
	 * @return
	 * @throws IOException 
	 */
	public ArrayList<String> getHrefList() throws IOException {
		
		parser();
		return hrefList;
	}
	
	/**
	 * 解析网页链接
	 * @throws IOException
	 */
	private void parser() throws IOException{
		
		URL url=new URL(htmlUrl);
		HttpURLConnection connection=(HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);
		
		String contentType=connection.getContentType();
		charSet=getCharset(contentType);
		
		InputStreamReader inputStreamReader=new InputStreamReader(connection.getInputStream(),charSet);
		BufferedReader bReader=new BufferedReader(inputStreamReader);
		
		String str=null,rString=null;
		while((str=bReader.readLine())!=null){
			
			rString=getHref(str);
			
			if(rString!=null){
				hrefList.add(rString);
			}
		}
	}

	/**
	 * 获取网页编码方式
	 * @param str
	 * @return
	 */
	private String getCharset(String str){
		
		Pattern pattern=Pattern.compile("charset=.*");
		Matcher matcher=pattern.matcher(str);
		if(matcher.find()){
			return matcher.group(0).split("charset=")[1];
		}
		return null;
	}
	
	/**
	 * 从一行字符串中读取链接
	 * @param str
	 * @return
	 */
	private String getHref(String str){
		Pattern pattern=Pattern.compile("<a href=.*</a>");
		Matcher matcher=pattern.matcher(str);
		if(matcher.find()){
			
			return matcher.group(0);
		}
		return null;
	}

	public void setHrefList(ArrayList<String> hrefList) {
		this.hrefList = hrefList;
	}


	public String getCharSet() {
		return charSet;
	}


	public void setCharSet(String charSet) {
		this.charSet = charSet;
	}
}
