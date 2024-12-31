package com.hotel.client.config;

import java.io.File;
import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class Database {
	protected static Connection con;
	protected static PreparedStatement pst;
	protected static ResultSet rs;
	protected static CallableStatement cst;
	protected static Database db = null;

	private Database() {
		try {
			File f = new File("");
			Class.forName("com.mysql.cj.jdbc.Driver");
			String path = f.getAbsolutePath();
			FileInputStream fis = new FileInputStream(path + "\\src\\main\\resources\\Application.properties");
			Properties p = new Properties();
			p.load(fis);

			String url = p.getProperty("url");
			String username = p.getProperty("username");
			String password = p.getProperty("password");

			con = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static Database getInstance() {
		if (db == null) {
			db = new Database();
		}
		return db;
	}

	public static Connection getCon() {
		return con;
	}

	public static PreparedStatement getStatement() {
		return pst;
	}

	public static ResultSet getResult() {
		return rs;
	}

	public static CallableStatement getCall() {
		return cst;
	}

}
