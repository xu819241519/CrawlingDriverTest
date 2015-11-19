package com.landon.thread;

import java.io.IOException;

import org.jsoup.Jsoup;

import com.landon.entity.Entity;
import com.landon.parser.IParser;
import com.landon.word.Data;
import com.landon.word.WriteWord;

public class GetWebData implements Runnable {

	// 解析器
	private IParser mParser;
	// 网址
	private String URL;
	// 第几个
	private int ID;

	public GetWebData(IParser parser, String url, int id) {
		mParser = parser;
		URL = url;
		ID = id;
	}

	@Override
	public void run() {
		try {

			String content = Jsoup.connect(URL).ignoreContentType(true).execute().body();
			Entity entity = mParser.getEntity(content, ID);
			Data.addData(entity);
			//System.out.println(ID + "已经启动");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
