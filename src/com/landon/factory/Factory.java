package com.landon.factory;

import com.landon.parser.Parser;
import com.landon.url.URLManager;

public abstract class Factory {

	// 课程类型
	protected CourseType mCourseType;

	public Factory(int type) {
		mCourseType = CourseType.createType(type);
	}

	/**
	 * 获得课程类型
	 * 
	 * @return 课程类型
	 */
	protected CourseType getCourseType() {
		return mCourseType;
	}

	/**
	 * 获得课程类型码
	 * 
	 * @return 课程类型码
	 */
	protected int getCourseTypeCode() {
		return mCourseType.getTpyeCode();
	}

	/**
	 * 设置课程类型
	 * 
	 * @param type
	 */
	public void setCourseType(int type) {
		mCourseType = CourseType.createType(type);
	}

	/**
	 * 获取解析器
	 * 
	 * @return 解析器
	 */
	public Parser getParser() {
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
