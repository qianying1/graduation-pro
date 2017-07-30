package cn.qianying.graduation.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qianying.graduation.dao.AnalizedMessageDao;
import cn.qianying.graduation.dao.GrabLibDao;
import cn.qianying.graduation.dao.GrabMessageDao;
import cn.qianying.graduation.dao.PageContentDao;
import cn.qianying.graduation.service.GrabingService;
import cn.qianying.graduation.util.GrabWebsiteUtil;

@Service("grabingServiceImpl")
public class GrabingServiceImpl implements GrabingService {

	private String htmlFileSaveBase = "grabedWebPages/";
	@Autowired
	private AnalizedMessageDao analizedMessageDaoImpl;
	@Autowired
	private GrabLibDao grabLibDaoImpl;
	@Autowired
	private GrabMessageDao grabMessageDaoImpl;
	@Autowired
	private PageContentDao pageContentDaoImpl;

	@Override
	public String grabAWebPage(String url) {

		String webpageContent = null;
		GrabWebsiteUtil grabWebsiteUtil = new GrabWebsiteUtil(url);
		try {
			webpageContent = grabWebsiteUtil.getWebpage();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return webpageContent;
	}

	@Override
	public void grabAWebPageAndGetMsg(String webName, String webUrl) throws IOException {

		Document doc = Jsoup.connect(webUrl).timeout(600000).get();
		String docTxt = doc.html();

		String title = doc.select("title").first().text();
		String pageTitle = writeHtmlDoc(title, webName, docTxt);
		int contentId = pageContentDaoImpl.insert(pageTitle);

		grabLibDaoImpl.insert(contentId, webName, webUrl, "Y");

		Elements ahrefEls = doc.select("a");

		List<String> ahrefList = new ArrayList<String>();
		for (Element ahrefEl : ahrefEls) {

			ahrefList.add(ahrefEl.attr("abs:href"));

			System.out.println(ahrefEl.attr("abs:href") + "\n" + ahrefEl.text());
		}

		if (ahrefList.size() > 0)
			grabLibDaoImpl.inserts(-1, webName, ahrefList, "N");

	}

	@Override
	public void grabWeb(String webName, String webUrl) throws IOException {

		// 通过url种子获取单个首页
		Document doc = null;
		try {
			doc = Jsoup.connect(webUrl).timeout(600000).get();
		} catch (IOException e) {

			// 等待链接超时处理
			System.out.println("===========请求超时处理========");
			return;
		}
		String docTxt = doc.html();
		Element titleEl = doc.select("title").first();
		String title = null;
		if (titleEl != null)
			title = titleEl.text();
		else
			title = "";

		if (!(null == webUrl || "".equals(webUrl) || isGrabed(webUrl))) {

			String pageTitle = writeHtmlDoc(title, webName, docTxt);
			int contentId = pageContentDaoImpl.insert(pageTitle);
			grabLibDaoImpl.insert(contentId, webName, webUrl, "Y");
		}

		// 抓取页面的urls
		Elements ahrefEls = doc.select("a");

		for (Element ahrefEl : ahrefEls) {

			String url = ahrefEl.attr("abs:href");
			// 判断是否为重复的url
			if (null == url || "".equals(url) || isGrabed(url)) {

				continue;
			}
			// System.out.println("===========url============"+url);
			grabWeb(webName, url);
			// System.out.println(ahrefEl.attr("abs:href") + "\n" +
			// ahrefEl.text());
		}

	}

	private boolean isGrabed(String url) {

		if (grabLibDaoImpl.isGrabed(url)) {
			return true;
		}
		return false;
	}

	private String writeHtmlDoc(String pageTitle, String webName, String htmlTxt) throws IOException {

		Calendar now = Calendar.getInstance();  
		String writeTime=String.valueOf(now.get(Calendar.YEAR))+String.valueOf((now.get(Calendar.MONTH) + 1))+String.valueOf(now.get(Calendar.DAY_OF_MONTH));
		
		File htmlFile = new File(htmlFileSaveBase + webName + File.separator + writeTime+File.separator+pageTitle + ".html");
		if (!htmlFile.getParentFile().exists()) {
			htmlFile.getParentFile().mkdirs();
		}

		String exts[] = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
				"t", "u", "v", "w", "x", "y", "z" };
		String ext = exts[(int) (Math.random() * 26)];
		while (htmlFile.exists()) {

			pageTitle = pageTitle + ext;
			htmlFile = new File(htmlFileSaveBase + webName + File.separator + writeTime+File.separator+pageTitle + ".html");
		}
		htmlFile.createNewFile();

		FileOutputStream fileOutputStream = new FileOutputStream(htmlFile);
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
		PrintWriter printWriter = new PrintWriter(bufferedOutputStream);

		printWriter.write(htmlTxt);
		printWriter.flush();

		printWriter.close();
		bufferedOutputStream.close();
		fileOutputStream.close();

		return htmlFile.getAbsolutePath();
	}

}
