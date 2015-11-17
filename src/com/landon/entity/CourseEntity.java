package com.landon.entity;

public class CourseEntity {

	// 表示科目代号
	private int CourseID;

	// 科目一
	public static int COURSE_1 = 1;
	// 科目四
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
