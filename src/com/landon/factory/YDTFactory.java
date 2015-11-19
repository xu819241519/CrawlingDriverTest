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
		String name = "��Уһ��ͨ��Ŀ";
		if (mCourseType.getTpyeCode() == CourseType.COURSE_1) {
			name += "һ";
		} else if (mCourseType.getTpyeCode() == CourseType.COURSE_4) {
			name += "��";
		}
		return name;
	}

}
