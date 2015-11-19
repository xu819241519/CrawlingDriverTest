package com.landon.url;

import com.landon.factory.CourseType;

public class YDTURLManager extends URLManager {

	private String OriginURL = "http://wz.jxedt.com/test/abcd/sxlx.asp?type=";

	private String HeaderURL = "http://wz.jxedt.com/test/abcd/ajax.asp?r=0.42186994873918593&index=";

	private CourseType mCourseType;

	public YDTURLManager(CourseType type) {
		mCourseType = type;
	}

	@Override
	public String getOriginURL() {
		if (mCourseType.getTpyeCode() == CourseType.COURSE_1)
			return OriginURL + "c";
		else
			return OriginURL + "s";
	}

	@Override
	public String getNextURL() {
		int page = getNextPage();
		if (page == -1)
			return null;
		return HeaderURL + page;
	}

}
