package com.su;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpUtil {

	private static HttpUtil instance = null;

	public static HttpUtil getInstance(){
        if (instance == null) {
            instance = new HttpUtil();
        }
        return instance;
    }

	public String get(String url) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		try {
			HttpGet httpGet = new HttpGet(url);
			response = httpclient.execute(httpGet);
			System.out.println(response.getStatusLine());
			HttpEntity entity = response.getEntity();
			String res = EntityUtils.toString(entity, "UTF-8");
			return res;
		} finally 	{
			try {
				if (response != null) {
                    response.close();
                }
                if (httpclient != null) {
                    httpclient.close();
                }
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
