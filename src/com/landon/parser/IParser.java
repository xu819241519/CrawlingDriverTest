package com.landon.parser;

import java.util.List;

import org.jsoup.nodes.Document;

import com.landon.entity.Entity;

public interface IParser {

	/**
	 * ��ȡ�����б�
	 * 
	 * @param content
	 * @return �����б�
	 */
	public List<Integer> getQuestionList(String content);

	/**
	 * ��ȡ����ʵ��
	 * 
	 * @param content
	 * @return ����ʵ��
	 */
	public Entity getEntity(String content, int id);

}
