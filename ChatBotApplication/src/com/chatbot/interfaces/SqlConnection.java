package com.chatbot.interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface SqlConnection {
	final static String url = "jdbc:mysql://localhost:3306/chatbot";
	final static String user = "root";
	final static String password = "Sridevi@07";
	final static Connection connection = createConnection();

	static Connection createConnection() {
		Connection connection = null;
		if (connection == null) {
			try {
				connection = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}

	default Connection getConnection() throws SQLException {
		return connection;
	}
}