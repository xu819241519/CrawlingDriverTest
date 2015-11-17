package com.landon.url;

import java.util.List;

import com.landon.entity.CourseEntity;

public class BaoDianURLManager extends URLManager {

	// ��ȡ����url��ԭʼurl
	private String originURL = "http://api2.jiakaobaodian.com/api/open/exercise/sequence.htm?_r=113661622742962066086&_config={}&_screenDip=1.25&carType=car&cityCode=371100&course=kemu";
	// url�����ͷ��
	private String headerURL = "http://api2.jiakaobaodian.com/api/open/question/question-list.htm?_r=187955896323366094&_config={}&_screenDip=1.25&questionIds=";
	// url�����β��
	private String tailURL = "&_=";
	// ��ǰͷ��
	private int currentPage = 0;

	private CourseEntity mCourseEntity;

	public BaoDianURLManager(CourseEntity entity) {
		mCourseEntity = entity;
	}

	@Override
	public String getNextURL() {
		String page = getPage(currentPage++);
		String result = null;
		if (page != null) {
			result = headerURL + page + tailURL + System.currentTimeMillis();
		}
		return result;
	}

	@Override
	public String getOriginURL() {
		if(mCourseEntity.getCourseID() == CourseEntity.COURSE_1){
			originURL += "1&_=";
		} else if(mCourseEntity.getCourseID() == CourseEntity.COURSE_4){
			originURL += "3&_=";
		}
		return originURL + System.currentTimeMillis();
	}

}