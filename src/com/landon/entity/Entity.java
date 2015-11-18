package com.landon.entity;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public abstract class Entity implements Comparable<Entity> {

	// ���
	private int ID;
	// ��Ŀ
	private String Title;
	// ѡ��
	private List<String> Options;
	// ��ȷ������
	private List<Integer> AnswerIndexList;
	// ������ý��
	private MediaEntity Media;
	// ��ȷ�𰸽���
	private String Analysis;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public List<String> getOptions() {
		return Options;
	}

	public void addOptions(String opt) {
		if (Options == null)
			Options = new ArrayList<String>();
		Options.add(opt);
	}

	public List<Integer> getAnswerIndex() {
		return AnswerIndexList;
	}

	public void addAnswerIndex(int answerIndex) {
		if (AnswerIndexList == null)
			AnswerIndexList = new ArrayList<Integer>();
		AnswerIndexList.add(answerIndex);
	}

	public MediaEntity getMedia() {
		return Media;
	}

	public void setMedia(MediaEntity media) {
		Media = media;
	}

	public String getAnalysis() {
		return Analysis;
	}

	public void setAnalysis(String analysis) {
		Analysis = analysis;
	}

	@Override
	public int compareTo(Entity o) {
		if (getID() > o.getID())
			return 1;
		else if (getID() == o.getID())
			return 0;
		else
			return -1;
	}

}
