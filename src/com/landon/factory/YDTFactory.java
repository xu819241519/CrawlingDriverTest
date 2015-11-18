package com.landon.factory;

import com.landon.entity.CourseEntity;
import com.landon.parser.IParser;
import com.landon.parser.YDTParser;
import com.landon.url.URLManager;
import com.landon.url.YDTURLManager;

public class YDTFactory implements IFactory {

	private CourseEntity mCourseEntity;

	public YDTFactory(CourseEntity entity) {
		mCourseEntity = entity;
	}

	@Override
	public IParser getParser() {
		return new YDTParser();
	}

	@Override
	public URLManager getURLManager() {
		return new YDTURLManager(mCourseEntity);
	}

	@Override
	public String getName() {
		String name = "驾校一点通科目";
		if (mCourseEntity.getCourseID() == CourseEntity.COURSE_1) {
			name += "一";
		} else if (mCourseEntity.getCourseID() == CourseEntity.COURSE_4) {
			name += "四";
		}
		return name;
	}

}
