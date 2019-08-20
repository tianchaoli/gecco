package com.adsino.crawler.toutiao;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.JSONPath;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.JsonBean;

public class ToutiaoJsonArticle implements JsonBean {

	private static final long serialVersionUID = 2250225801616402995L;

	@JSONPath(value="$.title", optional=true)
	private String title;

//	@JSONPath("$.ads")
//	private List<JSONObject> ads;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		
		System.out.println(title);
	}

}
