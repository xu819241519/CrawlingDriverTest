package com.landon.entity;

public abstract class MediaEntity {

	// ��ý������
	protected int MediaType;
	// ͼƬ����
	public static int TYPE_PICTURE = 1;
	// ��Ƶ����
	public static int TYPE_VIDEO = 2;

	public int getMediaType() {
		return MediaType;
	}

	public void setMediaType(int mediaType) {
		MediaType = mediaType;
	}

}
