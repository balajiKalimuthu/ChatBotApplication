package com.chatbot.languagepage;

import com.chatbot.database.DataLayer;

public class TeluguModelPage {
	private DataLayer dataLayer = DataLayer.getInstance();
	private TeluguViewPage viewPage;

	public TeluguModelPage(TeluguViewPage viewPage) {
		this.viewPage = viewPage;
	}

	public void displayTelMenu(char choice) throws Exception {
		dataLayer.displayTelMenu(choice);
	}

	public void validateValue(char level, char choice) throws Exception {
		if (choice == '0') {
			viewPage.endMessage();
		} else if (choice == '9') {
			if (level != '0') {
				dataLayer.popData();
				if (!dataLayer.isEmptyData()) {
					level = dataLayer.peekData();
					dataLayer.displayTelMenu(level, '#');
				} else {
					dataLayer.displayTelMenu('#');
					level = '0';
				}
			}
		} else if (choice >= '1' && choice <= '5') {
			dataLayer.pushData(choice);
			if (level == '0') {
				level = dataLayer.peekData();
				dataLayer.displayTelMenu(level);
			} else {
				dataLayer.displayTelMenu(++level, choice);
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
				dataLayer.displayTelMenu(choice);
			} else {
				dataLayer.displayTelMenu(level, choice);
			}
		} else {
			viewPage.showMessage("\n\tదయచేసి, చెల్లుబాటు అయ్యే ఎంపికను నమోదు చేయండి...\n");
		}

		if (!dataLayer.isEmptyData()) {
			level = dataLayer.peekData();
		}

		viewPage.setLevelData(level);
		viewPage.setChoiceData(choice);
	}
}