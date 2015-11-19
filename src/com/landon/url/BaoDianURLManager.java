package com.landon.url;

import java.util.List;

import com.landon.factory.CourseType;

public class BaoDianURLManager extends URLManager {

	// 获取所有url的原始url
	private String originURL = "http://api2.jiakaobaodian.com/api/open/exercise/sequence.htm?_r=113661622742962066086&_config={}&_screenDip=1.25&carType=car&cityCode=371100&course=kemu";
	// url不变的头部
	private String headerURL = "http://api2.jiakaobaodian.com/api/open/question/question-list.htm?_r=187955896323366094&_config={}&_screenDip=1.25&questionIds=";
	// url不变的尾部
	private String tailURL = "&_=";

	private CourseType mCourseType;

	public BaoDianURLManager(CourseType type) {
		mCourseType = type;
	}

	@Override
	public String getNextURL() {
		int page = getNextPage();
		String result = null;
		if (page != -1) {
			result = headerURL + page + tailURL + System.currentTimeMillis();
		}
		return result;
	}

	@Override
	public String getOriginURL() {
		if (mCourseType.getTpyeCode() == CourseType.COURSE_1) {
			originURL += "1&_=";
		} else if (mCourseType.getTpyeCode() == CourseType.COURSE_4) {
			originURL += "3&_=";
		}
		return originURL + System.currentTimeMillis();
	}

}
