package com.chatbot.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.chatbot.interfaces.SqlConnection;

public class EnglishMenu implements SqlConnection {
	private static EnglishMenu english;
	private Connection obj;
	private PreparedStatement pst;
	private ResultSet rs;
	private String query;

	private EnglishMenu() {
	}

	public static EnglishMenu getInstance() {
		if (english == null) {
			english = new EnglishMenu();
		}
		return english;
	}

	public void displayEngMenu(char choice) throws Exception {
		obj = getConnection();
		switch (choice) {
		case '#':
			query = "SELECT * FROM english_menu";
			break;
		case '1':
			query = "SELECT * FROM eng1_menu";
			break;
		case '2':
			query = "SELECT * FROM eng2_menu";
			break;
		case '3':
			query = "SELECT * FROM eng3_menu";
		}
		pst = obj.prepareStatement(query);
		rs = pst.executeQuery();
		System.out.println();
		while (rs.next()) {
			System.out.println("\t " + rs.getString(2));
		}
	}

	public void displayEngMenu(char level, char choice) throws Exception {
		obj = getConnection();
		if (choice == '#') {
			switch (level) {
			case '2':
				query = "SELECT * FROM eng1_menu";
				break;
			case '3':
				query = "SELECT * FROM eng2_menu";
				break;
			case '4':
				query = "SELECT * FROM eng3_menu";
			}
		} else {
			switch (level) {
			case '2':
				query = "SELECT * FROM eng1_menu WHERE id = " + choice;
				break;
			case '3':
				query = "SELECT * FROM eng2_menu WHERE id = " + choice;
				break;
			case '4':
				query = "SELECT * FROM eng3_menu WHERE id = " + choice;
			}
		}
		pst = obj.prepareStatement(query);
		rs = pst.executeQuery();
		System.out.println();
		while (rs.next()) {
			System.out.println("\t " + rs.getString(2));
		}
	}
}