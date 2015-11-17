package com.landon.word;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.landon.entity.Entity;

public class Data {

	private static List<Entity> Data = null;

	public synchronized static List<Entity> getData() {
		return Data;
	}

	public synchronized static void clearData() {
		Data.clear();
		Data = null;
	}

	public synchronized static void addData(Entity entity) {
		if (Data == null) {
			Data = new ArrayList<Entity>();
		}
		Data.add(entity);
	}

	public synchronized static List<Entity> getSortedData() {
		if (Data != null) {
			Collections.sort(Data);
		}
		return Data;
	}

}
