package com.landon.entity;

public class CourseEntity {

	// ��ʾ��Ŀ����
	private int CourseID;

	// ��Ŀһ
	public static int COURSE_1 = 1;
	// ��Ŀ��
	public static int COURSE_4 = 4;

	public int getCourseID() {
		return CourseID;
	}

	public void setCourseID(int courseID) {
		CourseID = courseID;
	}

	public CourseEntity(int course) {
		setCourseID(course);
	}
}
