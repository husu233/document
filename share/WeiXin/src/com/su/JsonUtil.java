package com.su;

public class JsonUtil {
	private static JsonUtil instance = null;

	public static JsonUtil getInstance(){
        if (instance == null) {
            instance = new JsonUtil();
        }
        return instance;
    }
}
