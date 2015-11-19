package com.landon.thread;

import java.io.IOException;

import org.jsoup.Jsoup;

import com.landon.entity.Entity;
import com.landon.parser.Parser;
import com.landon.word.Data;

public class GetWebData implements Runnable {

	// ������
	private Parser mParser;
	// ��ַ
	private String URL;
	// �ڼ���
	private int ID;

	public GetWebData(Parser parser, String url, int id) {
		mParser = parser;
		URL = url;
		ID = id;
	}

	@Override
	public void run() {
		try {

			String content = Jsoup.connect(URL).ignoreContentType(true).execute().body();
			Entity entity = mParser.getEntity(content, ID);
			Data.addData(entity);
			// System.out.println(ID + "�Ѿ�����");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
