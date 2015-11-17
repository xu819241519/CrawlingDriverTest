package com.landon.thread;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;

public class GetMedia {

	public byte[] getPicture(String url) {
		byte[] result = null;
		try {
			result = Jsoup.connect(url).ignoreContentType(true).execute().bodyAsBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public String downloadVideo(String url, int id) {
		String fileName = Integer.toString(id) + url.substring(url.lastIndexOf('.'));
		try {
			URL Url = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) Url.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(6000);
			if (connection.getResponseCode() == 200) {
				InputStream inputStream = connection.getInputStream();
				byte[] data = readInstream(inputStream);
				File file = new File(fileName);
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				fileOutputStream.write(data);
				fileOutputStream.close();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return System.getProperty("user.dir") + "\\" + fileName;
	}

	private byte[] readInstream(InputStream inputStream) throws Exception {
		ByteArrayOutputStream byteArrayOutPutStream = new ByteArrayOutputStream();// ����ByteArrayOutputStream��
		byte[] buffer = new byte[1024];// ����������
		int length = -1;// �����ȡ��Ĭ�ϳ���
		while ((length = inputStream.read(buffer)) != -1) {
			byteArrayOutPutStream.write(buffer, 0, length);// �ѻ������е����뵽�ڴ���
		}
		;
		byteArrayOutPutStream.close();// �ر�������
		inputStream.close();// �ر�������

		return byteArrayOutPutStream.toByteArray();// ����������������ֽ�����
	}

}
