package com.landon.entity;

public class PictureEntity extends MediaEntity {
	// 数据
	private byte[] Data;
	// 宽度
	private int Width;
	// 高度
	private int Height;
	
	private String PicType;
	
	public PictureEntity() {
		setMediaType(PictureEntity.TYPE_PICTURE);
	}

	public byte[] getData() {
		return Data;
	}

	public void setData(byte[] data) {
		Data = data;
	}

	public int getWidth() {
		return Width;
	}

	public void setWidth(int width) {
		Width = width;
	}

	public int getHeight() {
		return Height;
	}

	public void setHeight(int height) {
		Height = height;
	}

	public String getPicType() {
		return PicType;
	}

	public void setPicType(String type) {
		PicType = type;
	}

}
