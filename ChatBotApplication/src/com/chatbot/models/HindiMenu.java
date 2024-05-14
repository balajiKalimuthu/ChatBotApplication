package com.chatbot.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.chatbot.interfaces.SqlConnection;

public class HindiMenu implements SqlConnection {
	private static HindiMenu hindi;
	private Connection obj;
	private PreparedStatement pst;
	private ResultSet rs;
	private String query;

	private HindiMenu() {
	}

	public static HindiMenu getInstance() {
		if (hindi == null) {
			hindi = new HindiMenu();
		}
		return hindi;
	}

	public void displayHinMenu(char choice) throws Exception {
		obj = getConnection();
		switch (choice) {
		case '#':
			query = "SELECT * FROM hindi_menu";
			break;
		case '1':
			query = "SELECT * FROM hin1_menu";
			break;
		case '2':
			query = "SELECT * FROM hin2_menu";
			break;
		case '3':
			query = "SELECT * FROM hin3_menu";
		}
		pst = obj.prepareStatement(query);
		rs = pst.executeQuery();
		System.out.println();
		while (rs.next()) {
			System.out.println("\t " + rs.getString(2));
		}
	}

	public void displayHinMenu(char top, char choice) throws Exception {
		obj = getConnection();
		if (choice == '#') {
			switch (top) {
			case '2':
				query = "SELECT * FROM hin1_menu";
				break;
			case '3':
				query = "SELECT * FROM hin2_menu";
				break;
			case '4':
				query = "SELECT * FROM hin3_menu";
			}
		} else {
			switch (top) {
			case '2':
				query = "SELECT * FROM hin1_menu WHERE id = " + choice;
				break;
			case '3':
				query = "SELECT * FROM hin2_menu WHERE id = " + choice;
				break;
			case '4':
				query = "SELECT * FROM hin3_menu WHERE id = " + choice;
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