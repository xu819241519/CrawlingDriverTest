package com.landon.entity;

public class VideoEntity extends MediaEntity {

	public VideoEntity() {
		setMediaType(VideoEntity.TYPE_VIDEO);
	}

	// ������ַ
	private String URL;
	// ����·��
	private String Path;

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getPath() {
		return Path;
	}

	public void setPath(String path) {
		Path = path;
	}

}
