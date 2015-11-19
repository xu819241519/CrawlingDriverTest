package com.landon.factory;

import org.omg.CORBA.PUBLIC_MEMBER;

public abstract class CourseType {

	// ��Ŀһ
	public static int COURSE_1;
	// ��Ŀ��
	public static int COURSE_4;

	/**
	 * ������������
	 * 
	 * @param type
	 *            ����
	 * @return ��������
	 */
	public static CourseType createType(int type) {
		if (type == CourseType.COURSE_1)
			return new Course1();
		else
			return new Course4();
	}

	/**
	 * ��ȡ������
	 * 
	 * @return ������
	 */
	public abstract int getTpyeCode();
}
