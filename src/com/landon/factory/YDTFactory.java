package com.landon.factory;

import com.landon.parser.Parser;
import com.landon.parser.YDTParser;
import com.landon.url.URLManager;
import com.landon.url.YDTURLManager;

public class YDTFactory extends Factory {

	public YDTFactory(int courseType) {
		super(courseType);
	}

	@Override
	public Parser getParser() {
		return new YDTParser(getCourseType());
	}

	@Override
	public URLManager getURLManager() {
		return new YDTURLManager(getCourseType());
	}

	@Override
	public String getName() {
		String name = "驾校一点通科目";
		if (getCourseTypeCode() == CourseType.COURSE_1) {
			name += "一";
		} else if (getCourseTypeCode() == CourseType.COURSE_4) {
			name += "四";
		}
		return name;
	}

}
