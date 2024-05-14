package com.chatbot.languagepage;

import com.chatbot.database.DataLayer;

public class EnglishModelPage {
	private DataLayer dataLayer = DataLayer.getInstance();
	private EnglishViewPage viewPage;

	public EnglishModelPage(EnglishViewPage viewPage) {
		this.viewPage = viewPage;
	}

	public void displayEngMenu(char choice) throws Exception {
		dataLayer.displayEngMenu(choice);
	}

	public void validateValue(char level, char choice) throws Exception {
		if (choice == '0') {
			viewPage.endMessage();
		} else if (choice == '9') {
			if (level != '0') {
				dataLayer.popData();
				if (!dataLayer.isEmptyData()) {
					level = dataLayer.peekData();
					dataLayer.displayEngMenu(level, '#');
				} else {
					dataLayer.displayEngMenu('#');
					level = '0';
				}
			}
		} else if (choice >= '1' && choice <= '5') {
			dataLayer.pushData(choice);
			if (level == '0') {
				level = dataLayer.peekData();
				dataLayer.displayEngMenu(level);
			} else {
				dataLayer.displayEngMenu(++level, choice);
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
				dataLayer.displayEngMenu(choice);
			} else {
				dataLayer.displayEngMenu(level, choice);
			}
		} else {
			viewPage.showMessage("\n\tPlease, Enter valid choice...\n");
		}

		if (!dataLayer.isEmptyData()) {
			level = dataLayer.peekData();
		}

		viewPage.setLevelData(level);
		viewPage.setChoiceData(choice);
	}
}