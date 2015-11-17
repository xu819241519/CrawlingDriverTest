package com.landon.url;

import java.util.ArrayList;
import java.util.List;

public abstract class URLManager {

	protected List<String> mPage;

	public void setPageList(List<String> page) {
		if (page != null && page.size() > 0) {
			if (mPage == null) {
				mPage = new ArrayList<String>();
			}
			mPage.addAll(page);
		}
	}

	public String getPage(int index) {
		if (mPage != null && index < mPage.size())
			return mPage.get(index);
		else
			return null;
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
