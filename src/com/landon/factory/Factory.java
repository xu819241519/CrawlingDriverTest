package com.landon.factory;

import com.landon.parser.IParser;
import com.landon.url.URLManager;

public abstract class Factory {

	// 课程类型
	protected CourseType mCourseType;

	public Factory(int type) {
		mCourseType = CourseType.createType(type);
	}

	protected CourseType getCourseType() {
		return mCourseType;
	}

	public void setCourseType(int type) {
		mCourseType = CourseType.createType(type);
	}

	/**
	 * 获取解析器
	 * 
	 * @return 解析器
	 */
	public IParser getParser() {
		return null;
	}

	/**
	 * 获取URLManager
	 * 
	 * @return URLManager
	 */
	public URLManager getURLManager() {
		return null;
	}

	/**
	 * 获得工厂的名字
	 * 
	 * @return
	 */
	public String getName() {
		return null;
	}
}
