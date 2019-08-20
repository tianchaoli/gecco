package com.adsino.crawler.toutiao;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.JSONPath;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.JsonBean;

@Gecco(matchUrl="https://www.toutiao.com/search_content/?offset=0&format=json&keyword=北京大学&autoload=true&count=20&cur_tab=1&from=search_tab", pipelines="toutiaoJsonPipeline")
public class ToutiaoJsonPage implements JsonBean {

	private static final long serialVersionUID = 2250225801616402995L;

	@JSONPath(value="$.count", optional=true)
	private int count;

	@JSONPath(value="$.has_more", optional=true)
	private boolean hasMore;

	@JSONPath(value="$.data", optional=true)
	private List<ToutiaoJsonArticle> articles;

//	@JSONPath("$.ads")
//	private List<JSONObject> ads;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean getHasMore() {
		return hasMore;
	}

	public void setHasMore(boolean hasMore) {
		this.hasMore = hasMore;
	}

	public List<ToutiaoJsonArticle> getArticles() {
		return articles;
	}

	public void setArticles(List<ToutiaoJsonArticle> articles) {
		this.articles = articles;
	}

/*	public List<JSONObject> getAds() {
		return ads;
	}

	public void setAds(List<JSONObject> ads) {
		this.ads = ads;
	}

*/	public static void main(String[] args) throws Exception {
		HttpRequest request = new HttpGetRequest("https://www.toutiao.com/search_content/?offset=0&format=json&keyword=北京大学&autoload=true&count=20&cur_tab=1&from=search_tab");
		request.setCharset("GBK");
		GeccoEngine.create()
		.classpath("com.adsino.crawler.toutiao")
		//开始抓取的页面地址
		.start(request)
		//开启几个爬虫线程
		.thread(1)
		//单个爬虫每次抓取完一个请求后的间隔时间
		.interval(2000)
		.start();
	}

}
