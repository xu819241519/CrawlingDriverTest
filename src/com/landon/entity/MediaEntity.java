package com.landon.entity;

public abstract class MediaEntity {

	// 多媒体类型
	protected int MediaType;
	// 图片类型
	public static int TYPE_PICTURE = 1;
	// 视频类型
	public static int TYPE_VIDEO = 2;

	public int getMediaType() {
		return MediaType;
	}

	public void setMediaType(int mediaType) {
		MediaType = mediaType;
	}

}
