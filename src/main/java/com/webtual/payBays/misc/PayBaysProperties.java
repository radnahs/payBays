package com.webtual.payBays.misc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * @author Shantanu Sikdar
 *
 */
public class PayBaysProperties {
	private static Logger logger = Logger.getLogger(PayBaysProperties.class.getName());
	private static Properties properties = new Properties();
	private static InputStream in = PayBaysProperties.class.getResourceAsStream("/PayBays.properties");

	static {
		try {
			properties.load(in);
			in.close();
		} catch (IOException e) {
		} finally {
		}
	}

	public static String DOMAIN = properties.getProperty("payBays.domain");
	public static String USERNAME = properties.getProperty("payBays.username");
	public static String PASSWORD = properties.getProperty("payBays.password");

	public static String TOI_URL = properties.getProperty("toi.URL");
	public static String BBC_URL = properties.getProperty("bbc.URL");
	
	public static String FACEBOOK_URL = properties.getProperty("fb.URL");
	public static String FACEBOOK_ACCESS_TOKEN = properties.getProperty("fb.access.token");

	public static void main(String[] args) {
		System.out.println(PayBaysProperties.USERNAME);
		System.out.println(PayBaysProperties.PASSWORD);
	}
}
