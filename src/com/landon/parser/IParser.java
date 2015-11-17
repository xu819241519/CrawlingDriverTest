package com.landon.parser;

import java.util.List;

import org.jsoup.nodes.Document;

import com.landon.entity.CourseEntity;
import com.landon.entity.Entity;

public interface IParser {

	/**
	 * ��ȡ��ҳ��
	 * 
	 * @param content
	 * @return ��ҳ��
	 */
	public List<String> getPageList(String content);

	/**
	 * ��ȡ����ʵ��
	 * 
	 * @param content
	 * @return ����ʵ��
	 */
	public Entity getEntity(String content, int id);

}
