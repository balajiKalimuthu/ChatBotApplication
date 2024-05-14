package com.chatbot.languagepage;

import com.chatbot.application.AppInfo;
import com.chatbot.interfaces.PageInfo;

public class EnglishViewPage implements PageInfo {
	private EnglishModelPage modelPage;
	private char choice = '#';
	private char level = '0';

	public EnglishViewPage() {
		modelPage = new EnglishModelPage(this);
	}

	@Override
	public void start() throws Exception {
		startMessage();
		modelPage.displayEngMenu(choice);
		do {
			showMessage("\n\tEnter Your Choice : ");
			choice = sc.next().charAt(0);
			modelPage.validateValue(level, choice);
		} while (choice != '0');
	}

	@Override
	public void startMessage() {
		showMessage("\n\t+----------------------------------------------+\n");
		showMessage("\t|--> Your IVR language changed to \"English\" <--|\n");
		showMessage("\t+----------------------------------------------+\n");
	}

	@Override
	public void printMessage() {
		showMessage("\n\t+---------------------------------------+\n");
		showMessage("\t|--> Your option successfully setted <--|\n");
		showMessage("\t+---------------------------------------+\n");
	}

	@Override
	public void endMessage() {
		showMessage("\n\t+-----------------------------------------------+\n");
		showMessage("\t|--> Thank you for calling " + AppInfo.getCompanyName() + " Customer Care <--|\n");
		showMessage("\t+-----------------------------------------------+\n");
		showMessage("\n\n--> "+ AppInfo.getAppName() +" "+ AppInfo.getAppVersion() +" --- Closing <--");
	}

	@Override
	public void setChoiceData(char choice) {
		this.choice = choice;
	}

	@Override
	public void setLevelData(char level) {
		this.level = level;
	}
}