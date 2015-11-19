package com.landon.factory;

import com.landon.parser.BaoDianParser;
import com.landon.parser.IParser;
import com.landon.url.BaoDianURLManager;
import com.landon.url.URLManager;

public class BaoDianFactory implements IFactory {

	private CourseType mCourseType;

	public BaoDianFactory(int courseType) {
		mCourseType = CourseType.createType(courseType);
	}

	public void setmCourseEntity(int courseType) {
		this.mCourseType = CourseType.createType(courseType);
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
		String result = "�ݿ�����";
		if (mCourseType.getTpyeCode() == CourseType.COURSE_1)
			result += "��Ŀһ";
		else if (mCourseType.getTpyeCode() == CourseType.COURSE_4)
			result += "��Ŀ��";
		return result;
	}

}
