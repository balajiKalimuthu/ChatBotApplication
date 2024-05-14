package com.chatbot.languagepage;

import com.chatbot.application.AppInfo;
import com.chatbot.interfaces.PageInfo;

public class HindiViewPage implements PageInfo {
	private HindiModelPage modelPage;
	private char choice = '#';
	private char level = '0';

	public HindiViewPage() {
		modelPage = new HindiModelPage(this);
	}

	@Override
	public void start() throws Exception {
		startMessage();
		modelPage.displayHinMenu(choice);
		do {
			showMessage("\n\tअपनी पसंद दर्ज करें : ");
			choice = sc.next().charAt(0);
			modelPage.validateValue(level, choice);
		} while (choice != '0');
	}

	@Override
	public void startMessage() {
		showMessage("\n\t+--------------------------------------+\n");
		showMessage("\t|--> आपकी IVR भाषा बदलकर \"हिन्दी\" हो गई <--|\n");
		showMessage("\t+--------------------------------------+\n");
	}

	@Override
	public void printMessage() {
		showMessage("\n\t+------------------------------------+\n");
		showMessage("\t|--> आपका विकल्प सफलतापूर्वक सेट हो गया <--|\n");
		showMessage("\t+------------------------------------+\n");
	}

	@Override
	public void endMessage() {
		showMessage("\n\t+-----------------------------------------+\n");
		showMessage("\t|--> " + AppInfo.getCompanyName() + " ग्राहक सेवा पर कॉल करने के लिए धन्यवाद <--|\n");
		showMessage("\t+-----------------------------------------+\n");
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