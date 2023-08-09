package com.training.mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Users {
	String user_name;
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	String password;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet resultSet;

	public Users() {
		String url = "jdbc:mysql://localhost:3306/crs";


		String user = "root";

		String pwd = "Logesh88823";

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url, user, pwd);

		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	public boolean login() {	
		try {
			pstmt=con.prepareStatement("Select * from users where user_name=? and password=?");
			pstmt.setString(1, user_name);
			pstmt.setString(2, password);
			resultSet=pstmt.executeQuery();
			if(resultSet.next()==true) {
				this.setUser_name(resultSet.getString("user_name"));
				this.setPassword(resultSet.getString("password"));
				return true;
			}
			else {
				return false;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
