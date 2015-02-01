package com.fudfil.edelivery.common;

import com.google.gson.Gson;

public class JSONUtils {

	public static String getJSONObjStr(Object tObj) {
		Gson gson = new Gson();
		String json = gson.toJson(tObj);
		return json;
	}
}
