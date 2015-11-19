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
		String name = "��Уһ��ͨ��Ŀ";
		if (getCourseTypeCode() == CourseType.COURSE_1) {
			name += "һ";
		} else if (getCourseTypeCode() == CourseType.COURSE_4) {
			name += "��";
		}
		return name;
	}

}
