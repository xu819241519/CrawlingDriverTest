package com.landon.factory;

import com.landon.parser.Parser;
import com.landon.url.URLManager;

public abstract class Factory {

	// �γ�����
	protected CourseType mCourseType;

	public Factory(int type) {
		mCourseType = CourseType.createType(type);
	}

	/**
	 * ��ÿγ�����
	 * 
	 * @return �γ�����
	 */
	protected CourseType getCourseType() {
		return mCourseType;
	}

	/**
	 * ��ÿγ�������
	 * 
	 * @return �γ�������
	 */
	protected int getCourseTypeCode() {
		return mCourseType.getTpyeCode();
	}

	/**
	 * ���ÿγ�����
	 * 
	 * @param type
	 */
	public void setCourseType(int type) {
		mCourseType = CourseType.createType(type);
	}

	/**
	 * ��ȡ������
	 * 
	 * @return ������
	 */
	public Parser getParser() {
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
