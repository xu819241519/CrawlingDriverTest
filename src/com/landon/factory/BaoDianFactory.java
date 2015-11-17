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
		String result = "�ݿ�����";
		if (mCourseEntity.getCourseID() == CourseEntity.COURSE_1)
			result += "��Ŀһ";
		else if (mCourseEntity.getCourseID() == CourseEntity.COURSE_4)
			result += "��Ŀ��";
		return result;
	}

}
