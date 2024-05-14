package com.chatbot.database;

import com.chatbot.models.EnglishMenu;
import com.chatbot.models.HindiMenu;
import com.chatbot.models.ImplementedStack;
import com.chatbot.models.MainMenu;
import com.chatbot.models.TamilMenu;
import com.chatbot.models.TeluguMenu;

public class DataLayer {
	private static DataLayer dataLayer;
	private EnglishMenu english = EnglishMenu.getInstance();
	private HindiMenu hindi = HindiMenu.getInstance();
	private ImplementedStack stack = ImplementedStack.getInstance();
	private MainMenu main = MainMenu.getInstance();
	private TamilMenu tamil = TamilMenu.getInstance();
	private TeluguMenu telugu = TeluguMenu.getInstance();

	private DataLayer() {
	}

	public static DataLayer getInstance() {
		if (dataLayer == null) {
			dataLayer = new DataLayer();
		}
		return dataLayer;
	}

	public boolean isEmptyData() {
		return stack.isEmptyData();
	}

	public void pushData(char choice) {
		stack.pushData(choice);
	}

	public void popData() {
		stack.popData();
	}

	public char peekData() {
		return stack.peekData();
	}

	public void displayMainMenu() throws Exception {
		main.displayMainMenu();
	}

	public void displayEngMenu(char choice) throws Exception {
		english.displayEngMenu(choice);
	}

	public void displayEngMenu(char level, char choice) throws Exception {
		english.displayEngMenu(level, choice);
	}

	public void displayTamMenu(char choice) throws Exception {
		tamil.displayTamMenu(choice);
	}

	public void displayTamMenu(char level, char choice) throws Exception {
		tamil.displayTamMenu(level, choice);
	}

	public void displayHinMenu(char choice) throws Exception {
		hindi.displayHinMenu(choice);
	}

	public void displayHinMenu(char level, char choice) throws Exception {
		hindi.displayHinMenu(level, choice);
	}

	public void displayTelMenu(char choice) throws Exception {
		telugu.displayTelMenu(choice);
	}

	public void displayTelMenu(char level, char choice) throws Exception {
		telugu.displayTelMenu(level, choice);
	}
}