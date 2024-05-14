package com.chatbot.application;

import com.chatbot.customerpage.CustomerViewPage;

public class AppInfo {
	private static AppInfo appInfo;
	private static String name = "CHATBOT APPLICATION";
	private static String version = "v1.1.0";
	private static String companyName = "JIO";

	private AppInfo() {
	}

	public static AppInfo getInstance() {
		if (appInfo == null) {
			appInfo = new AppInfo();
		}
		return appInfo;
	}

	public static String getAppName() {
		return name;
	}

	public static String getAppVersion() {
		return version;
	}

	public static String getCompanyName() {
		return companyName;
	}

	public void appStart() throws Exception {
		new CustomerViewPage().start();
	}
}