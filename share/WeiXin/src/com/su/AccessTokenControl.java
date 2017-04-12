package com.su;

import java.net.URI;
import java.util.TimerTask;

import org.apache.http.client.utils.URIBuilder;

public class AccessTokenControl extends TimerTask {
	private final static String appID = "wx641178ea9955a245";
	private final static String appsecret = "a282e7e223b3394c421a95232b4c8f4c";
	private final static String grantType = "client_credential";
	public static String accessToken;
	public static int expiresIn;

	@Override
	public void run() {
		try {
			URI uri = new URIBuilder()
					.setScheme("https")
					.setHost("api.weixin.qq.com")
					.setPath("/cgi-bin/token")
					.setParameter("grant_type", grantType)
					.setParameter("appid", appID)
					.setParameter("secret", appsecret).build();
			HttpUtil httpUtil = HttpUtil.getInstance();
			String response = httpUtil.get(uri.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
