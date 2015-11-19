package com.landon.parser;

import java.util.List;


import com.landon.entity.Entity;

public interface IParser {

	/**
	 * 获取问题列表
	 * 
	 * @param content
	 * @return 问题列表
	 */
	public List<Integer> getQuestionList(String content);

	/**
	 * 获取数据实体
	 * 
	 * @param content
	 * @return 数据实体
	 */
	public Entity getEntity(String content, int id);

}
