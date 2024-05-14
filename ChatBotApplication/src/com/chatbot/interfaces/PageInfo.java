package com.chatbot.interfaces;

import java.util.Scanner;

public interface PageInfo {

	Scanner sc = new Scanner(System.in);

	void start() throws Exception;

	void startMessage();

	void printMessage();

	void endMessage();

	default void setLevelData(char level) {
	}

	default void setChoiceData(char choice) {
	}

	default void showMessage(String message) {
		System.out.print(message);
	}
}