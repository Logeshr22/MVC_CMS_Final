package com.training.mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Student {
	int sid;
	String sname;
	String email;
	String user_name;
	String spassword;
	int cid;
	int mark;
	String grade;
	String confirm_pass;
	String new_pass;

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getNew_pass() {
		return new_pass;
	}

	public void setNew_pass(String new_pass) {
		this.new_pass = new_pass;
	}

	public String getConfirm_pass() {
		return confirm_pass;
	}

	public void setConfirm_pass(String confirm_pass) {
		this.confirm_pass = confirm_pass;
	}

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet resultSet;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getSpassword() {
		return spassword;
	}

	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public Student() {
		String url = "jdbc:mysql://localhost:3306/crs";
		String user = "root";
		String pwd = "Logesh88823";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean login() {
		try {
			pstmt = con.prepareStatement("Select * from student where user_name=? and spassword=?");
			pstmt.setString(1, user_name);
			pstmt.setString(2, spassword);

			resultSet = pstmt.executeQuery();

			if (resultSet.next()) {

				this.setSid(resultSet.getInt("sid"));

				this.setMark(resultSet.getInt("mark"));
				this.setUser_name(resultSet.getString("user_name"));
				this.setCid(resultSet.getInt("cid"));
				this.setEmail(resultSet.getString("email"));
				this.setSname(resultSet.getString("sname"));
				return true;
			}

			else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean givemarks() {
		try {
			pstmt = con.prepareStatement("update student set mark=?, grade=? where sid=? ");
			pstmt.setInt(1, mark);
			pstmt.setString(2, grade);
			
			pstmt.setInt(3, sid);
			int resultSet = pstmt.executeUpdate();
			if (resultSet > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean changepassword(String sname) {
		if (new_pass.equals(confirm_pass)) {
			try {
				pstmt = con.prepareStatement("update student set spassword=? where sname=? and spassword=? ");
				pstmt.setString(1, new_pass);
				pstmt.setString(2, sname);
				pstmt.setString(3, spassword);
				int resultSet = pstmt.executeUpdate();
				if (resultSet > 0) {
					return true;
				} else {
					return false;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		} else {
			return false;
		}
	}

	public boolean DeleteStudent(int stud_id) {
		try {
			pstmt = con.prepareStatement("delete from student where sid=?");
			pstmt.setInt(1, stud_id);
			int x = pstmt.executeUpdate();
			System.out.println(x);
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

	public boolean addstudent() {
		try {
			pstmt = con.prepareStatement(
					"insert into student(sname,spassword,email,user_name,cid,sid) values(?,?,?,?,?,?)");
			pstmt.setString(1, sname);
			pstmt.setString(2, spassword);
			pstmt.setString(3, email);
			pstmt.setString(4, user_name);
			pstmt.setInt(5, cid);
			pstmt.setInt(6, sid);
			int x = pstmt.executeUpdate();
			if (x > 0)
			{
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}