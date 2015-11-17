package com.landon.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;

import org.apache.log4j.rewrite.RewriteAppender;
import org.apache.poi.hwpf.model.PICF;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.omg.CORBA.INTERNAL;

import com.landon.entity.BaoDianEntity;
import com.landon.entity.CourseEntity;
import com.landon.entity.Entity;
import com.landon.entity.PictureEntity;
import com.landon.entity.VideoEntity;
import com.landon.thread.GetMedia;

public class BaoDianParser implements IParser {

	private CourseEntity mCourseEntity;

	public BaoDianParser(CourseEntity entity) {
		mCourseEntity = entity;
	}

	/**
	 * 获取实体
	 */
	@Override
	public Entity getEntity(String content, int id) {
		Entity result = new BaoDianEntity();
		JSONObject jsonObject = new JSONObject(content);
		JSONArray jsonArray = jsonObject.getJSONArray("data");
		JSONObject jObject = jsonArray.getJSONObject(0);
		result.setAnalysis(jObject.getString("explain"));
		int answerIndex = jObject.getInt("answer");
		int[] standard = { 16, 32, 64, 128, 256, 512, 1024, 2048, 4096 };
		for (int i = standard.length - 1; answerIndex > 0; i--) {
			if (answerIndex == standard[i]) {
				result.addAnswerIndex(i + 1);
				break;
			} else if (answerIndex > standard[i]) {
				result.addAnswerIndex(i + 1);
				answerIndex -= standard[i];
			}
		}
		result.setID(id);
		result.setTitle(jObject.getString("question"));
		List<String> options = new ArrayList<String>();

		String[] ops = { "optionA", "optionB", "optionC", "optionD", "optionE", "optionF", "optionG", "optionH" };
		for (int i = 0; i < ops.length; ++i) {
			Object value = jObject.get(ops[i]);
			if (value != null && !value.equals(null))
				if (value != null && !((String) value).trim().equals("")) {
					options.add((String) value);

				}
		}
		result.setOptions(options);

		if (jObject.getInt("mediaType") == 1) {
			PictureEntity pictureEntity = new PictureEntity();
			GetMedia getPicture = new GetMedia();
			String urlPic = jObject.getString("mediaContent");
			pictureEntity.setPicType(urlPic.substring(urlPic.lastIndexOf('.') + 1));
			pictureEntity.setData(getPicture.getPicture(urlPic));
			pictureEntity.setWidth(jObject.getInt("mediaWidth"));
			pictureEntity.setHeight(jObject.getInt("mediaHeight"));
			result.setMedia(pictureEntity);
		} else if (jObject.getInt("mediaType") == 2) {
			VideoEntity videoEntity = new VideoEntity();
			videoEntity.setURL(jObject.getString("mediaContent"));
			GetMedia getMedia = new GetMedia();
			videoEntity.setPath(getMedia.downloadVideo(jObject.getString("mediaContent"), result.getID()));
			result.setMedia(videoEntity);
		}

		return result;
	}

	@Override
	public List<String> getPageList(String content) {
		List<String> result = null;
		JSONObject jo = new JSONObject(content);
		JSONArray jsonArray = jo.getJSONArray("data");
		if (jsonArray != null && jsonArray.length() != 0) {
			result = new ArrayList<String>();
		}
		for (int i = 0; i < jsonArray.length(); ++i) {
			result.add(Integer.toString(jsonArray.getInt(i)));
		}
		return result;
	}

}
