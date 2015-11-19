package com.landon.crawling;

import com.landon.factory.BaoDianFactory;
import com.landon.factory.CourseType;
import com.landon.factory.Factory;
import com.landon.factory.YDTFactory;

public class Start {

	public static void main(String[] args) {

		Factory factory = new BaoDianFactory(CourseType.COURSE_1);
		CrawlingWeb crawlingWeb = new CrawlingWeb();
		crawlingWeb.startCrawling(factory);

	}
}
