package com.landon.factory;

import org.omg.CORBA.PUBLIC_MEMBER;

public abstract class CourseType {

	// 科目一
	public static int COURSE_1;
	// 科目四
	public static int COURSE_4;

	/**
	 * 创建类型子类
	 * 
	 * @param type
	 *            类型
	 * @return 类型子类
	 */
	public static CourseType createType(int type) {
		if (type == CourseType.COURSE_1)
			return new Course1();
		else
			return new Course4();
	}

	/**
	 * 获取类型码
	 * 
	 * @return 类型码
	 */
	public abstract int getTpyeCode();
}
