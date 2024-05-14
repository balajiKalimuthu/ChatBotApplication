package com.chatbot;

import com.chatbot.application.AppInfo;

public class Application {
	private static AppInfo app = AppInfo.getInstance();

	public static void main(String[] args) throws Exception {
		app.appStart();
	}
}