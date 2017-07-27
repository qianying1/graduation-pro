package cn.qianying.graduation.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import cn.qianying.graduation.domain.AnalizedMessage;
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
	public List<AnalizedMessage> listAll() {
		return analizedMessageDaoImpl.listAll();
	}

	@Override
	public int addRecord(AnalizedMessage analizedMessage) {
		return analizedMessageDaoImpl.addRecord(analizedMessage);
	}

	@Override
	public int saveOrUpdate(AnalizedMessage analizedMessage) {
		return analizedMessageDaoImpl.saveOrUpdate(analizedMessage);
	}

	@Override
	public AnalizedMessage getDetail(String id) {
		return analizedMessageDaoImpl.getDetail(id);
	}

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

		Document doc = Jsoup.connect(webUrl).timeout(10000).get();
		String docTxt = doc.html();

		String title = doc.select("title").first().text();
		String pageTitle=writeHtmlDoc(title, webName, docTxt);
		int contentId=pageContentDaoImpl.insert(pageTitle);
		
		grabLibDaoImpl.insert(contentId,webName,webUrl,"Y");

		Elements ahrefEls = doc.select("a");

		List<String> ahrefList=new ArrayList<String>();
		for (Element ahrefEl : ahrefEls) {

			ahrefList.add(ahrefEl.attr("abs:href"));
			System.out.println(ahrefEl.attr("abs:href") + "\n" + ahrefEl.text());
		}
		grabLibDaoImpl.inserts(-1,webName,ahrefList,"N");
		
	}

	private String writeHtmlDoc(String pageTitle, String webName, String htmlTxt) throws IOException {

		File htmlFile = new File(htmlFileSaveBase + webName + File.separator + pageTitle + ".html");
		if (!htmlFile.getParentFile().exists()) {
			htmlFile.getParentFile().mkdirs();
		}
		String ext = "ext";
		while (htmlFile.exists()) {

			pageTitle = pageTitle + ext;
			htmlFile = new File(htmlFileSaveBase + webName + File.separator + pageTitle + ".html");
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
