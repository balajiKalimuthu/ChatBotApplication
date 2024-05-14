package com.chatbot.customerpage;

import com.chatbot.database.DataLayer;

public class CustomerModelPage {
	private CustomerViewPage viewPage;
	private DataLayer dataLayer = DataLayer.getInstance();

	protected CustomerModelPage(CustomerViewPage viewPage) {
		this.viewPage = viewPage;
	}

	public void displayMainMenu() throws Exception {
		viewPage.showMessage("");
		dataLayer.displayMainMenu();
	}
}