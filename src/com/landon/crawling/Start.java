package com.landon.crawling;

import com.landon.factory.CourseType;
import com.landon.factory.IFactory;
import com.landon.factory.YDTFactory;

public class Start {

	public static void main(String[] args) {

		IFactory factory = new YDTFactory(CourseType.COURSE_1);
		CrawlingWeb crawlingWeb = new CrawlingWeb();
		crawlingWeb.startCrawling(factory);

	}
}
