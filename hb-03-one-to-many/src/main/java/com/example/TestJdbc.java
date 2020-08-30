package com.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		try {
			String url = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&sereverTimezone=UTC";
			String user = "hbstudent";
			String password = "hbstudent";
			System.out.println("Connecting to databse");
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection successful");

		} catch (Exception e) {
			System.out.println(e);

		}

	}

}
