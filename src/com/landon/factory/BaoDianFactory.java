package com.landon.factory;

import com.landon.entity.CourseEntity;
import com.landon.parser.BaoDianParser;
import com.landon.parser.IParser;
import com.landon.url.BaoDianURLManager;
import com.landon.url.URLManager;

public class BaoDianFactory implements IFactory {

	private CourseEntity mCourseEntity;

	public BaoDianFactory(CourseEntity entity) {
		mCourseEntity = entity;
	}

	public void setmCourseEntity(CourseEntity mCourseEntity) {
		this.mCourseEntity = mCourseEntity;
	}

	@Override
	public IParser getParser() {
		return new BaoDianParser(mCourseEntity);
	}

	@Override
	public URLManager getURLManager() {
		return new BaoDianURLManager(mCourseEntity);
	}

	@Override
	public String getName() {
		String result = "驾考宝典";
		if (mCourseEntity.getCourseID() == CourseEntity.COURSE_1)
			result += "科目一";
		else if (mCourseEntity.getCourseID() == CourseEntity.COURSE_4)
			result += "科目四";
		return result;
	}

}
