package cn.qianying.graduation.support.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import cn.qianying.graduation.support.AcfunSupport;

@Component("acfunSupportImpl")
public class AcfunSupportImpl extends CommonSupportImpl implements AcfunSupport {

	@Override
	public List<String> analizeHeader(Element header) {

		Element nav = header.getElementById("nav");
		Elements ahrefs = nav.select("a");

		List<String> urls = new ArrayList<String>();
		for (Element ahref : ahrefs) {

			String url = ahref.attr("abs:href");
			if (null != url && !"".equals(url)) {
				urls.add(url);
			}
		}

		return urls;
	}

	@Override
	public void analizeBodyMain(Element bodyMain) {

		Element firstSection = bodyMain.select("section").first();
		Elements otherSections = bodyMain.select("section");
		otherSections.remove(0);
		analizeFirstSection(firstSection);
		analizeOtherSections(otherSections);
	}

	private void analizeOtherSections(Elements otherSections) {

	}

	@Override
	public void analyWebByBF() {

	}

	private void analizeFirstSection(Element firstSection) {

		Element sliderWrap = firstSection.getElementsByClass("slider-wrap").get(0);
		Element sliderRight = firstSection.getElementsByClass("slider-right-x6").get(0);

		// 处理左边轮播
		Elements hrefEls = sliderWrap.select("a");
		List<String> urList = new ArrayList<String>();
		for (Element hrefEl : hrefEls) {

			String url = hrefEl.attr("abs:href");
			urList.add(url);
		}

		handleSliderWrap(urList);

		// 处理右边6个小视频

	}

	// 处理主页左边轮播链接得到的页面
	private void handleSliderWrap(List<String> urList) {

		for (String url : urList) {

			videoPageAnalize(url);
		}
	}

	private void videoPageAnalize(String url) {

		Connection connection = Jsoup.connect(url)
				.userAgent(
						"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2906.0 Safari/537.36")
				.ignoreContentType(true);
		Document document = null;
		try {
			document = connection.get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (document != null) {

			Element mainEl = document.getElementById("main");

			// 获取头部信息
			Element header = mainEl.select("section").first();
			String title = header.getElementsByClass("title").first().text();
			Element typeDatas = header.getElementsByClass("title").first().nextElementSibling()
					.getElementById("bd_crumb");
			String videoType = typeDatas.getElementsByClass("sp3").first().text() + "-"
					+ typeDatas.getElementsByClass("sp5").first().text();
			String releaseTime = typeDatas.getElementsByClass("sp7").first().previousElementSibling().text();

			// 获取视频下的各种例如评论数量等信息
			Element crumpDatas = mainEl.select("section.clearfix.wp.area.crumb").first();
			String viewCount = crumpDatas.select("span.view.f1").first().select("span.sp2").first().text();

			int danmu = Integer.valueOf(crumpDatas.select("span.danmu.f1").first().select("span.sp2").first().text());
			int commentCount = Integer.valueOf(crumpDatas.getElementById("bd_comm").select("span.sp2").first().text());
			int likeCount = Integer
					.valueOf(crumpDatas.getElementById("bd_collection").select("span.sp4").first().text());
			int bananaCount = Integer
					.valueOf(crumpDatas.select("span.banana.f1").first().select("span.sp4").first().text());

			Element userDiv = mainEl.select("div.introduction").first().select("section.clearfix.wp.area").first()
					.select("div.column-right.fr").first();
			String signature = userDiv.select("div.bottom").first().select("div.desc").first().text();
			String authorPageUrl = userDiv.select("div.user").first().select("a").first().attr("abs:href");
			String authorPic = userDiv.select("div.user").first().select("a").first().select("img").first().attr("src");
			String authorName = userDiv.select("div.user").first().getElementById("bd_upname").select("div.title")
					.first().text();
			
			
		}
	}

	private void authorPageAnalize(String url) {

	}

}
