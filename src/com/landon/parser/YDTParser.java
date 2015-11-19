package com.landon.parser;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.json.JSONObject;
import org.omg.CORBA.OBJ_ADAPTER;

import com.landon.entity.Entity;
import com.landon.entity.PictureEntity;
import com.landon.entity.VideoEntity;
import com.landon.entity.YDTEntity;
import com.landon.thread.GetMedia;

public class YDTParser implements IParser {

	public static Object object = new Object();

	@Override
	public List<Integer> getQuestionList(String content) {
		List<Integer> result = null;
		// 首先获取需要的字符串段
		String text = content.substring(content.indexOf("myExamID"), content.lastIndexOf("myExamID"));
		text = text.substring(text.indexOf("for"));
		// 开始分析
		Pattern pattern = Pattern.compile("\\(.+?\\)");
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			String str = matcher.group(0).trim();
			if (str != null && !str.equals("")) {
				str = str.substring(1, str.length() - 1).trim();
				String startIndex = str.substring(str.indexOf("i = ") + 4, str.indexOf(";"));
				int start = Integer.parseInt(startIndex);
				int end = start;
				int indexAss = 0;
				if (str.indexOf("<= ") != -1) {
					indexAss = str.indexOf("<= ");
					String endIndex = str.substring(indexAss + 3, str.indexOf(';', indexAss));
					end = Integer.parseInt(endIndex) + 1;
				} else if (str.indexOf("< ") != -1) {
					indexAss = str.indexOf("< ");
					String endIndex = str.substring(indexAss + 2, str.indexOf(';', indexAss));
					end = Integer.parseInt(endIndex);
				}

				if (end > start) {
					if (result == null)
						result = new ArrayList<Integer>();
					for (int j = start; j < end; ++j) {
						result.add(j);
					}
				}
			}
		}
		return result;
	}

	@Override
	public Entity getEntity(String content, int id) {
		YDTEntity ydtEntity = new YDTEntity();
		ydtEntity.setID(id);
		if (content != null && content.length() != 0) {

			// content = content.replace("\"", "");
			content = content.replace("\\这个", "向右的");

			//System.out.println(content);
			JSONObject jsonObject = new JSONObject(content);
			ydtEntity.setTitle(jsonObject.getString("question"));
			ydtEntity.setAnalysis(jsonObject.getString("bestanswer"));
			int answers = jsonObject.getInt("ta");
			while (answers > 0) {
				ydtEntity.addAnswerIndex(answers % 10);
				answers = answers / 10;
			}
			String[] opts = { "a", "b", "c", "d" };
			int i = 0;
			for (i = 0; i < opts.length; ++i) {
				String option = jsonObject.getString(opts[i]);
				if (option == null || option.equals("")) {
					break;
				} else {
					ydtEntity.addOptions(option);
				}
			}
			if (i != opts.length) {
				ydtEntity.addOptions("正确");
				ydtEntity.addOptions("错误");
			}

			System.out.println(id + "运行中1");

			String mediaURL = jsonObject.getString("sinaimg");
			if (mediaURL != null && !mediaURL.equals("")) {
				synchronized (object) {
					PictureEntity pictureEntity = new PictureEntity();
					GetMedia getMedia = new GetMedia();
					pictureEntity.setData(getMedia.getPicture("http://ww3.sinaimg.cn/mw240/" + mediaURL));
					InputStream inputStream = new ByteArrayInputStream(pictureEntity.getData());

					System.out.println(id + "运行中2");

					try {
						BufferedImage image = ImageIO.read(inputStream);
						pictureEntity.setHeight(image.getHeight());
						pictureEntity.setWidth(image.getWidth());
						pictureEntity.setPicType(mediaURL.substring(mediaURL.lastIndexOf('.') + 1));
						ydtEntity.setMedia(pictureEntity);
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						System.out.println(id + "运行中3");
						if (inputStream != null)

							try {
								inputStream.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
					}
				}

			} else {
				mediaURL = jsonObject.getString("imageurl");
				if (mediaURL != null && !mediaURL.equals("")) {

					System.out.println(id + "运行中4");

					VideoEntity videoEntity = new VideoEntity();
					videoEntity.setURL(mediaURL);
					GetMedia getMedia = new GetMedia();
					videoEntity.setPath(getMedia.downloadVideo(mediaURL, id));
					ydtEntity.setMedia(videoEntity);
				}
			}
		}

		return ydtEntity;
	}

}
