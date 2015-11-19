package com.landon.url;

import java.util.ArrayList;
import java.util.List;

import com.landon.factory.CourseType;

public abstract class URLManager {

	protected List<Integer> mPage;

	protected int CurrentPage = -1;

	// �γ�����
	protected CourseType mCourseType;

	public URLManager(CourseType type) {
		mCourseType = type;
	}

	protected int getCourseTypeCode() {
		return mCourseType.getTpyeCode();
	}

	/**
	 * ����ҳ��
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
	 * �����һҳ��ҳ��
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
	 * �����һ����ַ
	 * 
	 * @return ��ַ
	 */
	public String getNextURL() {
		return null;
	}

	/**
	 * ��ȡԭʼ��ַ
	 * 
	 * @return ��ַ
	 */
	public String getOriginURL() {
		return null;
	}

}
