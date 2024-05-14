package com.chatbot.languagepage;

import com.chatbot.database.DataLayer;

public class TamilModelPage {
	private DataLayer dataLayer = DataLayer.getInstance();
	private TamilViewPage viewPage;

	public TamilModelPage(TamilViewPage viewPage) {
		this.viewPage = viewPage;
	}

	public void displayTamMenu(char choice) throws Exception {
		dataLayer.displayTamMenu(choice);
	}

	public void validateValue(char level, char choice) throws Exception {
		if (choice == '0') {
			viewPage.endMessage();
		} else if (choice == '9') {
			if (level != '0') {
				dataLayer.popData();
				if (!dataLayer.isEmptyData()) {
					level = dataLayer.peekData();
					dataLayer.displayTamMenu(level, '#');
				} else {
					dataLayer.displayTamMenu('#');
					level = '0';
				}
			}
		} else if (choice >= '1' && choice <= '5') {
			dataLayer.pushData(choice);
			if (level == '0') {
				level = dataLayer.peekData();
				dataLayer.displayTamMenu(level);
			} else {
				dataLayer.displayTamMenu(++level, choice);
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
				dataLayer.displayTamMenu(choice);
			} else {
				dataLayer.displayTamMenu(level, choice);
			}
		} else {
			viewPage.showMessage("\n\tசரியான தேர்வை உள்ளிடவும்...\n");
		}

		if (!dataLayer.isEmptyData()) {
			level = dataLayer.peekData();
		}

		viewPage.setLevelData(level);
		viewPage.setChoiceData(choice);
	}
}