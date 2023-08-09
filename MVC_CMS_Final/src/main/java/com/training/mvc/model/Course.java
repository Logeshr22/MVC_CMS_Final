package com.training.mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Course {
	int cid;
	String cname;
	int fees;
	int dur_months;
	private Connection con;
	private PreparedStatement pstmt;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}
	public int getDur_months() {
		return dur_months;
	}
	public void setDur_months(int dur_months) {
		this.dur_months = dur_months;
	}
	
	public Course() {String url = "jdbc:mysql://localhost:3306/crs";

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
	
	public boolean AddCourse() {
		try {
			pstmt = con.prepareStatement("insert into course values(?,?,?,?)");
			pstmt.setInt(1, cid);
			pstmt.setString(2, cname);
			pstmt.setInt(3, fees);
			pstmt.setInt(4, dur_months);
			int x = pstmt.executeUpdate();
			if (x > 0) {

				return true;

			} else {

				// resp.sendRedirect("/BankingApplication/LoginFail.html");
				System.out.println("error beacuse login failed after resset");
				return false;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;

	}
	
	public boolean DeleteCourse() {

		try {
			pstmt = con.prepareStatement("delete from course where cid=?");
			pstmt.setInt(1, cid);
			int x = pstmt.executeUpdate();

			if (x > 0) {

				return true;

			} else {

				// resp.sendRedirect("/BankingApplication/LoginFail.html");
				System.out.println("error beacuse login failed after resset");
				return false;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;

	}

}
