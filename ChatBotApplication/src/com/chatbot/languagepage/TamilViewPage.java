package com.chatbot.languagepage;

import com.chatbot.application.AppInfo;
import com.chatbot.interfaces.PageInfo;

public class TamilViewPage implements PageInfo {
	private TamilModelPage modelPage;
	private char choice = '#';
	private char level = '0';

	public TamilViewPage() {
		modelPage = new TamilModelPage(this);
	}

	@Override
	public void start() throws Exception {
		startMessage();
		modelPage.displayTamMenu(choice);
		do {
			showMessage("\n\tஉங்கள் விருப்பத்தை உள்ளிடவும் : ");
			choice = sc.next().charAt(0);
			modelPage.validateValue(level, choice);
		} while (choice != '0');
	}

	@Override
	public void startMessage() {
		showMessage("\n\t+--------------------------------------------------+\n");
		showMessage("\t|--> உங்கள் IVR மொழி \"தமிழ்\" என மாற்றப்பட்டது <--|\n");
		showMessage("\t+--------------------------------------------------+\n");
	}

	@Override
	public void printMessage() {
		showMessage("\n\t+----------------------------------------------------+\n");
		showMessage("\t|--> உங்கள் விருப்பம் வெற்றிகரமாக அமைக்கப்பட்டது <--|\n");
		showMessage("\t+----------------------------------------------------+\n");
	}

	@Override
	public void endMessage() {
		showMessage("\n\t+-------------------------------------------------------+\n");
		showMessage("\t|--> " + AppInfo.getCompanyName() + " வாடிக்கையாளர் சேவையை அழைத்ததற்கு நன்றி <--|\n");
		showMessage("\t+-------------------------------------------------------+\n");
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