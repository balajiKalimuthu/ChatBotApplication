package com.chatbot.languagepage;

import com.chatbot.database.DataLayer;

public class HindiModelPage {
	private DataLayer dataLayer = DataLayer.getInstance();
	private HindiViewPage viewPage;

	public HindiModelPage(HindiViewPage viewPage) {
		this.viewPage = viewPage;
	}

	public void displayHinMenu(char choice) throws Exception {
		dataLayer.displayHinMenu(choice);
	}

	public void validateValue(char level, char choice) throws Exception {
		if (choice == '0') {
			viewPage.endMessage();
		} else if (choice == '9') {
			if (level != '0') {
				dataLayer.popData();
				if (!dataLayer.isEmptyData()) {
					level = dataLayer.peekData();
					dataLayer.displayHinMenu(level, '#');
				} else {
					dataLayer.displayHinMenu('#');
					level = '0';
				}
			}
		} else if (choice >= '1' && choice <= '5') {
			dataLayer.pushData(choice);
			if (level == '0') {
				level = dataLayer.peekData();
				dataLayer.displayHinMenu(level);
			} else {
				dataLayer.displayHinMenu(++level, choice);
				level--;
				if (level >= '2') {
					viewPage.printMessage();
					viewPage.endMessage();
					choice = '0';
					viewPage.setChoiceData(choice);
					return;
				}
			}
		} else if (choice == '#') {
			if (level == '0') {
				dataLayer.displayHinMenu(choice);
			} else {
				dataLayer.displayHinMenu(level, choice);
			}
		} else {
			viewPage.showMessage("\n\tकृपया, वैध विकल्प दर्ज करें...\n");
		}

		if (!dataLayer.isEmptyData()) {
			level = dataLayer.peekData();
		}

		viewPage.setLevelData(level);
		viewPage.setChoiceData(choice);
	}
}
