package com.landon.url;

import java.util.ArrayList;
import java.util.List;

import com.landon.factory.CourseType;

public abstract class URLManager {

	protected List<Integer> mPage;

	protected int CurrentPage = -1;

	// 课程类型
	protected CourseType mCourseType;

	public URLManager(CourseType type) {
		mCourseType = type;
	}

	protected int getCourseTypeCode() {
		return mCourseType.getTpyeCode();
	}

	/**
	 * 设置页号
	 * 
	 * @param page
	 */
	public void setPageList(List<Integer> page) {
		if (page != null && page.size() > 0) {
			if (mPage == null) {
				mPage = new ArrayList<Integer>();
			}
			mPage.addAll(page);
		}
	}

	/**
	 * 获得下一页的页号
	 * 
	 * @return
	 */
	protected int getNextPage() {
		CurrentPage++;
		if (CurrentPage < mPage.size())
			return mPage.get(CurrentPage);
		else
			return -1;
	}

	/**
	 * 获得下一个网址
	 * 
	 * @return 网址
	 */
	public String getNextURL() {
		return null;
	}

	/**
	 * 获取原始网址
	 * 
	 * @return 网址
	 */
	public String getOriginURL() {
		return null;
	}

}
