package com.training.mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Professor {
	int pid;
	String pname;
	int exp;
	String ppassword;
	int cid;
	String new_pass;
	String confirm_pass;

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

	public Connection con;
	private PreparedStatement pstmt;
	private ResultSet resultSet;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public String getPpassword() {
		return ppassword;
	}

	public void setPpassword(String ppassword) {
		this.ppassword = ppassword;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public Professor() {
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
			pstmt = con.prepareStatement("select * from professor where pname=? and ppassword=?");
			pstmt.setString(1, pname);
			pstmt.setString(2, ppassword);

			resultSet = pstmt.executeQuery();

			if (resultSet.next()) {

				this.setPname(resultSet.getString("pname"));

				this.setPpassword(resultSet.getString("ppassword"));
				this.setExp(resultSet.getInt("exp"));
				this.setPid(resultSet.getInt("pid"));
				this.setCid(resultSet.getInt("cid"));

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

	public boolean changepassword(String pname) {
		if (new_pass.equals(confirm_pass)) {

			try {
				pstmt = con.prepareStatement("update professor set ppassword=? where pname=? and ppassword=? ");
				pstmt.setString(1, new_pass);
				pstmt.setString(2, pname);
				pstmt.setString(3, ppassword);

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

	public boolean AddProfessor() {

		try {
			pstmt = con.prepareStatement("insert into professor values(?,?,?,?,?)");
			pstmt.setInt(1, pid);
			pstmt.setString(2, pname);
			pstmt.setInt(3, exp);
			pstmt.setString(4, ppassword);
			pstmt.setInt(5, cid);
			int x = pstmt.executeUpdate();

			if (x > 0) {
				String sql1 = "insert into users values(?,?)";
				pstmt = con.prepareStatement(sql1);
				pstmt.setString(1, pname);
				pstmt.setString(2, ppassword);

				x = pstmt.executeUpdate();
				if (x > 0) {

					return true;

				} else {

					// resp.sendRedirect("/BankingApplication/LoginFail.html");
					System.out.println("error beacuse login failed after resset");
					return false;
				}

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	public boolean DeleteProessor(int prof_id) {
		try {
			pstmt = con.prepareStatement("delete from professor where pid=?");
			pstmt.setInt(1, prof_id);
			int x = pstmt.executeUpdate();
			System.out.println(x);
			if (x > 0) {

				return true;

			} else {

				System.out.println("error beacuse login failed after resset");
				return false;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

}
