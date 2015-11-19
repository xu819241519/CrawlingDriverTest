package com.landon.thread;

import java.io.IOException;

import org.jsoup.Jsoup;

import com.landon.entity.Entity;
import com.landon.parser.IParser;
import com.landon.word.Data;
import com.landon.word.WriteWord;

public class GetWebData implements Runnable {

	// ������
	private IParser mParser;
	// ��ַ
	private String URL;
	// �ڼ���
	private int ID;

	public GetWebData(IParser parser, String url, int id) {
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
			//System.out.println(ID + "�Ѿ�����");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
