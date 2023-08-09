<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="app.css">
<meta charset="ISO-8859-1">
<title>Add student</title>
</head>
<body>

	<div class="topnav">
		<img src="Logo.png" id="logo">
		<h1>
			<a class="Link" href="ProfessorLogin.html">Professor</a>
		</h1>
		<h1>
			<a class="Link" href="StudentLogin.html">Student</a>
		</h1>
		<h1>
			<a class="active" href="AdminLogin.html">Admin</a>
		</h1>
		<a class="Link" href="index.html">Home</a>
	</div>
	<h1 class="header">Add Student</h1>
	<%
	Statement stmt = null;
	Connection con = null;
	ResultSet resultSet = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/crs";
		String user = "root";
		String pwd = "Logesh88823";
		con = DriverManager.getConnection(url, user, pwd);
		String sql = "select * from course";
		stmt = con.createStatement();
		resultSet = stmt.executeQuery(sql);
	%>
	<div class="formContainer">
		<div class="list">
			<table class="displayTable">
				<tr>
					<th class="displayTableData">Course ID</th>
					<th class="displayTableData">Course Name</th>
					<th class="displayTableData">Course Fees</th>
					<th class="displayTableData">Course Duration</th>
				</tr>

				<%
				while (resultSet.next()) {
				%>
				<tr>
					<td class="displayTableData"><%=resultSet.getInt("cid")%></td>
					<td class="displayTableData"><%=resultSet.getString("cname")%></td>
					<td class="displayTableData"><%=resultSet.getString("fees")%></td>
					<td class="displayTableData"><%=resultSet.getString("dur_months")%></td>
				</tr>
				<%
				}
				} catch (Exception e) {
				out.println(e);
				}
				%>
			</table>
			<div id="inputForm">
				<form action="AddStudent" method="post">
					<table>
						<tr>
							<td><label class="label">Student ID</label></td>
							<td><input class="input" type="number" name="Student_id" placeholder=""></td>
						</tr>
						<tr>
							<td><label class="label">Student Name</label></td>
							<td><input class="input" type="text" name="Student_name" placeholder=""></td>
						</tr>
						<tr>
							<td><label class="label">User Name</label></td>
							<td><input class="input" type="text" name="User_Name" placeholder="">
							</td>
						</tr>
						<tr>
							<td><label class="label">Email</label></td>
							<td><input class="input" type="text" name="Email" placeholder=""></td>
						</tr>
						<tr>
							<td><label class="label">Password</label></td>
							<td><input class="input" type="password" name="student_password"
								placeholder=""></td>
						</tr>
						<tr>
							<td><label class="label">Course ID</label></td>
							<td><input class="input"	 type="number" name="Course_id" placeholder=""></td>
						</tr>
					</table>
					<div class="buttonHolder">
						<input id="LoginButton" class="input" type="submit"
							value="Add Student">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>