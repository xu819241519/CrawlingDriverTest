package com.landon.parser;

import java.util.List;

import org.jsoup.nodes.Document;

import com.landon.entity.CourseEntity;
import com.landon.entity.Entity;

public interface IParser {

	/**
	 * 获取总页数
	 * 
	 * @param content
	 * @return 总页数
	 */
	public List<String> getPageList(String content);

	/**
	 * 获取数据实体
	 * 
	 * @param content
	 * @return 数据实体
	 */
	public Entity getEntity(String content, int id);

}
