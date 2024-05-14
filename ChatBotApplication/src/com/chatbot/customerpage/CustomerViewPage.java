package com.chatbot.customerpage;

import com.chatbot.application.AppInfo;
import com.chatbot.interfaces.PageInfo;
import com.chatbot.languagepage.EnglishViewPage;
import com.chatbot.languagepage.HindiViewPage;
import com.chatbot.languagepage.TamilViewPage;
import com.chatbot.languagepage.TeluguViewPage;

public class CustomerViewPage implements PageInfo {
	private CustomerModelPage modelPage;
	private char choice = '0';

	public CustomerViewPage() {
		modelPage = new CustomerModelPage(this);
	}

	public void start() throws Exception {
		startMessage();

		do {
			printMessage();
			modelPage.displayMainMenu();
			showMessage("\n\tEnter Your Choice : ");
			choice = sc.next().charAt(0);

			switch (choice) {
			case '0':
				endMessage();
				break;
			case '1':
				new EnglishViewPage().start();
				choice = '0';
				break;
			case '2':
				new TamilViewPage().start();
				choice = '0';
				break;
			case '3':
				new HindiViewPage().start();
				choice = '0';
				break;
			case '4':
				new TeluguViewPage().start();
				choice = '0';
				break;
			case '#':
				break;
			default:
				showMessage("\n\tPlease, Enter valid choice...\n");
			}
		} while (choice != '0');
	}

	@Override
	public void startMessage() {
		showMessage("\n\n\n--> "+ AppInfo.getAppName() +" "+ AppInfo.getAppVersion() +" --- Loading <--\n\n\n");
		showMessage("\t+------------------------------------+\n");
		showMessage("\t|--> Welcome to " + AppInfo.getCompanyName() + " Customer Care <--|\n");
		showMessage("\t+------------------------------------+\n");
	}

	@Override
	public void printMessage() {
		showMessage("\n\t+----------------------------------------------+\n");
		showMessage("\t|--> Please select IVR language to continue <--|\n");
		showMessage("\t+----------------------------------------------+\n");
	}

	@Override
	public void endMessage() {
		showMessage("\n\t+-----------------------------------------------+\n");
		showMessage("\t|--> Thank you for calling " + AppInfo.getCompanyName() + " Customer Care <--|\n");
		showMessage("\t+-----------------------------------------------+\n");
		showMessage("\n\n--> "+ AppInfo.getAppName() +" "+ AppInfo.getAppVersion() +" --- Closing <--");
	}
}