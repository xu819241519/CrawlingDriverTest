package com.landon.factory;

import com.landon.parser.IParser;
import com.landon.url.URLManager;

public abstract class Factory {

	// �γ�����
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
	 * ��ȡ������
	 * 
	 * @return ������
	 */
	public IParser getParser() {
		return null;
	}

	/**
	 * ��ȡURLManager
	 * 
	 * @return URLManager
	 */
	public URLManager getURLManager() {
		return null;
	}

	/**
	 * ��ù���������
	 * 
	 * @return
	 */
	public String getName() {
		return null;
	}
}
