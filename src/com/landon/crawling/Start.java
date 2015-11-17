package com.landon.crawling;

import com.landon.entity.CourseEntity;
import com.landon.factory.BaoDianFactory;
import com.landon.factory.IFactory;

public class Start {

	public static void main(String[] args) {

		IFactory factory = new BaoDianFactory(new CourseEntity(CourseEntity.COURSE_4));
		CrawlingWeb crawlingWeb = new CrawlingWeb();
		crawlingWeb.startCrawling(factory);

	}
}
