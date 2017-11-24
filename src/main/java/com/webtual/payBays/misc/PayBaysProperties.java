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
	public static String MS_EXCHANGE_URL = properties.getProperty("payBays.ExchangeService.URL");

	public static String PAYBAYS_NUMBER_EMAILS = properties.getProperty("payBays.number.emails");

	public static String PAYBAYS_NUMBER_JIRA = properties.getProperty("payBays.number.jira");

	public static String PAYBAYS_TOI_URL = properties.getProperty("payBays.toi.URL");
	public static String PAYBAYS_BBC_URL = properties.getProperty("payBays.bbc.URL");

	public static void main(String[] args) {
		System.out.println(PayBaysProperties.USERNAME);
		System.out.println(PayBaysProperties.PASSWORD);
		System.out.println(PayBaysProperties.MS_EXCHANGE_URL);
	}
}
