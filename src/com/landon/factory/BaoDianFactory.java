package com.landon.factory;

import com.landon.parser.BaoDianParser;
import com.landon.parser.IParser;
import com.landon.url.BaoDianURLManager;
import com.landon.url.URLManager;

public class BaoDianFactory extends Factory {

	public BaoDianFactory(int courseType) {
		super(courseType);
	}

	@Override
	public IParser getParser() {
		return new BaoDianParser(mCourseType);
	}

	@Override
	public URLManager getURLManager() {
		return new BaoDianURLManager(mCourseType);
	}

	@Override
	public String getName() {
		String result = "驾考宝典";
		if (getCourseType().getTpyeCode() == CourseType.COURSE_1)
			result += "科目一";
		else if (getCourseType().getTpyeCode() == CourseType.COURSE_4)
			result += "科目四";
		return result;
	}

}
