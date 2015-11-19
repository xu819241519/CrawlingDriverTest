package com.landon.factory;

import com.landon.parser.IParser;
import com.landon.parser.YDTParser;
import com.landon.url.URLManager;
import com.landon.url.YDTURLManager;

public class YDTFactory implements IFactory {

	private CourseType mCourseType;

	public YDTFactory(int courseType) {
		mCourseType = CourseType.createType(courseType);
	}

	@Override
	public IParser getParser() {
		return new YDTParser();
	}

	@Override
	public URLManager getURLManager() {
		return new YDTURLManager(mCourseType);
	}

	@Override
	public String getName() {
		String name = "驾校一点通科目";
		if (mCourseType.getTpyeCode() == CourseType.COURSE_1) {
			name += "一";
		} else if (mCourseType.getTpyeCode() == CourseType.COURSE_4) {
			name += "四";
		}
		return name;
	}

}
