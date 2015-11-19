package com.landon.factory;

import com.landon.parser.IParser;
import com.landon.url.URLManager;

public interface IFactory {

	/**
	 * 获取解析器
	 * 
	 * @return 解析器
	 */
	public IParser getParser();

	/**
	 * 获取URLManager
	 * 
	 * @return URLManager
	 */
	public URLManager getURLManager();

	/**
	 * 获得工厂的名字
	 * 
	 * @return
	 */
	public String getName();
}
