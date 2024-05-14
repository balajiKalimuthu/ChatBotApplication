package com.chatbot.languagepage;

import com.chatbot.application.AppInfo;
import com.chatbot.interfaces.PageInfo;

public class TeluguViewPage implements PageInfo {
	private TeluguModelPage modelPage;
	private char choice = '#';
	private char level = '0';

	public TeluguViewPage() {
		modelPage = new TeluguModelPage(this);
	}

	@Override
	public void start() throws Exception {
		startMessage();
		modelPage.displayTelMenu(choice);
		do {
			showMessage("\n\tమీ ఎంపికను నమోదు చేయండి : ");
			choice = sc.next().charAt(0);
			modelPage.validateValue(level, choice);
		} while (choice != '0');
	}

	@Override
	public void startMessage() {
		showMessage("\n\t+-------------------------------------+\n");
		showMessage("\t|--> మీ IVR భాష \"తెలుగు\"కి మార్చబడింది <--|\n");
		showMessage("\t+-------------------------------------+\n");
	}

	@Override
	public void printMessage() {
		showMessage("\n\t+------------------------------------------+\n");
		showMessage("\t|--> మీ ఎంపిక విజయవంతంగా సెట్ చేయబడింది <--|\n");
		showMessage("\t+------------------------------------------+\n");
	}

	@Override
	public void endMessage() {
		showMessage("\n\t+----------------------------------------------+\n");
		showMessage("\t|--> " + AppInfo.getCompanyName() + " కస్టమర్ కేర్‌కు కాల్ చేసినందుకు ధన్యవాదాలు <--|\n");
		showMessage("\t+----------------------------------------------+\n");
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