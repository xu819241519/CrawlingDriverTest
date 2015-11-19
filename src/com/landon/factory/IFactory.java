package com.landon.factory;

import com.landon.parser.IParser;
import com.landon.url.URLManager;

public interface IFactory {

	/**
	 * ��ȡ������
	 * 
	 * @return ������
	 */
	public IParser getParser();

	/**
	 * ��ȡURLManager
	 * 
	 * @return URLManager
	 */
	public URLManager getURLManager();

	/**
	 * ��ù���������
	 * 
	 * @return
	 */
	public String getName();
}
