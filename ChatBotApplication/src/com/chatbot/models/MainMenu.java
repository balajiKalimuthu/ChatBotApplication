package com.chatbot.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.chatbot.interfaces.SqlConnection;

public class MainMenu implements SqlConnection {
	private static MainMenu main;
	private Connection obj;
	private PreparedStatement pst;
	private ResultSet rs;
	private String query;

	private MainMenu() {
	}

	public static MainMenu getInstance() {
		if (main == null) {
			main = new MainMenu();
		}
		return main;
	}

	public void displayMainMenu() throws Exception {
		obj = DriverManager.getConnection(url, user, password);
		query = "SELECT * FROM main_menu";
		pst = obj.prepareStatement(query);
		rs = pst.executeQuery();
		while (rs.next()) {
			System.out.println("\t " + rs.getString(2));
		}
	}
}