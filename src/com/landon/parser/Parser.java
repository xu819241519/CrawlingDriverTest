package com.landon.parser;

import java.util.List;

import com.landon.entity.Entity;
import com.landon.factory.CourseType;

public abstract class Parser {

	// 课程类型
	protected CourseType mCourseType;

	public Parser(CourseType type) {
		mCourseType = type;
	}

	protected int getCourseTypeCode() {
		return mCourseType.getTpyeCode();
	}

	/**
	 * 获取问题列表
	 * 
	 * @param content
	 * @return 问题列表
	 */
	public List<Integer> getQuestionList(String content) {
		return null;
	}

	/**
	 * 获取数据实体
	 * 
	 * @param content
	 * @return 数据实体
	 */
	public Entity getEntity(String content, int id) {
		return null;
	}

}
