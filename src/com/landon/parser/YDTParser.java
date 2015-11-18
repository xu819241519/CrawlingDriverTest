package com.landon.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;

import com.landon.entity.Entity;
import com.landon.entity.YDTEntity;

public class YDTParser implements IParser {

	@Override
	public List<Integer> getQuestionList(String content) {
		List<Integer> result = null;
		// 首先获取需要的字符串段
		String text = content.substring(content.indexOf("myExamID"), content.lastIndexOf("myExamID"));
		text = text.substring(text.indexOf("for"));
		// 开始分析
		Pattern pattern = Pattern.compile("(.*?)");
		Matcher matcher = pattern.matcher(text);
		if (matcher.find()) {
			for (int i = 1; i <= matcher.groupCount(); ++i) {
				String str = matcher.group(i).trim();
				if (str != null && !str.equals("")) {
					str = str.substring(1, str.length() - 1);
					String startIndex = str.substring(str.indexOf("i=") + 2, str.indexOf(";"));
					int start = Integer.parseInt(startIndex);
					int end = start;
					int indexAss = 0;
					if (str.indexOf("<=") != -1) {
						indexAss = str.indexOf("<=");
						String endIndex = str.substring(indexAss + 2, str.indexOf(';', indexAss));
						end = Integer.parseInt(endIndex) + 1;
					} else if (str.indexOf("<") != -1) {
						indexAss = str.indexOf("<");
						String endIndex = str.substring(indexAss + 1, str.indexOf(';', indexAss));
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
		}
		return result;
	}

	@Override
	public Entity getEntity(String content, int id) {
		YDTEntity ydtEntity = new YDTEntity();
		ydtEntity.setID(id);
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
		
		
		return ydtEntity;
	}

}
