package com.chatbot.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.chatbot.interfaces.SqlConnection;

public class TamilMenu implements SqlConnection {
	private static TamilMenu tamil;
	private Connection obj;
	private PreparedStatement pst;
	private ResultSet rs;
	private String query;

	private TamilMenu() {
	}

	public static TamilMenu getInstance() {
		if (tamil == null) {
			tamil = new TamilMenu();
		}
		return tamil;
	}

	public void displayTamMenu(char choice) throws Exception {
		obj = getConnection();
		switch (choice) {
		case '#':
			query = "SELECT * FROM tamil_menu";
			break;
		case '1':
			query = "SELECT * FROM tam1_menu";
			break;
		case '2':
			query = "SELECT * FROM tam2_menu";
			break;
		case '3':
			query = "SELECT * FROM tam3_menu";
		}
		pst = obj.prepareStatement(query);
		rs = pst.executeQuery();
		System.out.println();
		while (rs.next()) {
			System.out.println("\t " + rs.getString(2));
		}
	}

	public void displayTamMenu(char top, char choice) throws Exception {
		obj = getConnection();
		if (choice == '#') {
			switch (top) {
			case '2':
				query = "SELECT * FROM tam1_menu";
				break;
			case '3':
				query = "SELECT * FROM tam2_menu";
				break;
			case '4':
				query = "SELECT * FROM tam3_menu";
			}
		} else {
			switch (top) {
			case '2':
				query = "SELECT * FROM tam1_menu WHERE id = " + choice;
				break;
			case '3':
				query = "SELECT * FROM tam2_menu WHERE id = " + choice;
				break;
			case '4':
				query = "SELECT * FROM tam3_menu WHERE id = " + choice;
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