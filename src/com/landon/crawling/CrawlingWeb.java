package com.landon.crawling;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.landon.factory.IFactory;
import com.landon.parser.IParser;
import com.landon.thread.GetWebData;
import com.landon.url.URLManager;
import com.landon.word.Data;
import com.landon.word.WriteWord;

public class CrawlingWeb {

	/**
	 * 开始爬取网页
	 * 
	 * @param threadCount
	 *            允许最大的线程数
	 * @param factory
	 */
	public void startCrawling(IFactory factory) {
		URLManager urlManager = factory.getURLManager();
		initURLManager(urlManager, factory.getParser());

		String url = urlManager.getNextURL();
		if (url != null) {
			int cores = Runtime.getRuntime().availableProcessors();
			ExecutorService executorService = Executors.newFixedThreadPool(cores + 1);
			int titleID = 1;
			while (url != null) {
				executorService.execute(new GetWebData(factory.getParser(), url, titleID++));
				url = urlManager.getNextURL();
			}
			executorService.shutdown();
			try {

				if (executorService.awaitTermination(1000, TimeUnit.SECONDS)) {
					WriteWord writeWord = new WriteWord();
					writeWord.write2Word(factory.getName());
					// System.out.println("任务已经完成");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 初始化URLManager的页数列表
	 * 
	 * @param urlManager
	 * @param parser
	 */
	private void initURLManager(URLManager urlManager, IParser parser) {
		try {
			String url = urlManager.getOriginURL();
			String result = Jsoup.connect(url).ignoreContentType(true).execute().body();
			List<Integer> pageList = parser.getQuestionList(result);
			urlManager.setPageList(pageList);
			//System.out.println("预先获得" + pageList.size() + "个题");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
