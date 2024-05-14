package com.chatbot.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.chatbot.interfaces.SqlConnection;

public class TeluguMenu implements SqlConnection {
	private static TeluguMenu telugu;
	private Connection obj;
	private PreparedStatement pst;
	private ResultSet rs;
	private String query;

	private TeluguMenu() {
	}

	public static TeluguMenu getInstance() {
		if (telugu == null) {
			telugu = new TeluguMenu();
		}
		return telugu;
	}

	public void displayTelMenu(char choice) throws Exception {
		obj = getConnection();
		switch (choice) {
		case '#':
			query = "SELECT * FROM telugu_menu";
			break;
		case '1':
			query = "SELECT * FROM tel1_menu";
			break;
		case '2':
			query = "SELECT * FROM tel2_menu";
			break;
		case '3':
			query = "SELECT * FROM tel3_menu";
		}
		pst = obj.prepareStatement(query);
		rs = pst.executeQuery();
		System.out.println();
		while (rs.next()) {
			System.out.println("\t " + rs.getString(2));
		}
	}

	public void displayTelMenu(char top, char choice) throws Exception {
		obj = getConnection();
		if (choice == '#') {
			switch (top) {
			case '2':
				query = "SELECT * FROM tel1_menu";
				break;
			case '3':
				query = "SELECT * FROM tel2_menu";
				break;
			case '4':
				query = "SELECT * FROM tel3_menu";
			}
		} else {
			switch (top) {
			case '2':
				query = "SELECT * FROM tel1_menu WHERE id = " + choice;
				break;
			case '3':
				query = "SELECT * FROM tel2_menu WHERE id = " + choice;
				break;
			case '4':
				query = "SELECT * FROM tel3_menu WHERE id = " + choice;
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