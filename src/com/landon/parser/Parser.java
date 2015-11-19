package com.landon.parser;

import java.util.List;

import com.landon.entity.Entity;
import com.landon.factory.CourseType;

public abstract class Parser {

	// �γ�����
	protected CourseType mCourseType;

	public Parser(CourseType type) {
		mCourseType = type;
	}

	protected int getCourseTypeCode() {
		return mCourseType.getTpyeCode();
	}

	/**
	 * ��ȡ�����б�
	 * 
	 * @param content
	 * @return �����б�
	 */
	public List<Integer> getQuestionList(String content) {
		return null;
	}

	/**
	 * ��ȡ����ʵ��
	 * 
	 * @param content
	 * @return ����ʵ��
	 */
	public Entity getEntity(String content, int id) {
		return null;
	}

}
