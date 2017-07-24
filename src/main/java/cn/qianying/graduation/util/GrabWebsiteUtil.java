package cn.qianying.graduation.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class GrabWebsiteUtil {

	private String strUrl;

	public GrabWebsiteUtil(String strUrl) {

		this.strUrl = strUrl;
	}


	public String getWebpage() throws IOException {

		StringBuffer buffstr=new StringBuffer();
		URL url = new URL(this.strUrl);
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

	public String getStrUrl() {
		return strUrl;
	}

	public void setStrUrl(String strUrl) {
		this.strUrl = strUrl;
	}
}
