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
		<a id="Link" href="ProfessorLogin.html">Professor</a> <a id="Link"
			href="StudentLogin.html">Student</a> <a id="activeLink"
			href="AdminLogin.html">Admin</a> <a id="Link" href="index.html">Home</a>
	</div>
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
		<h1 class="specialHeader">
			Add Professor <span class="highlight">.</span>
		</h1>
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
				<form action="AddProfessor" method="post">
					<table>
						<tr>
							<td><label class="label">Professor ID</label></td>
							<td><input class="input" type="number" name="Professor_id"
								placeholder=""></td>
						</tr>
						<tr>
							<td><label class="label">Professor Name</label></td>
							<td><input class="input" type="text" name="Professor_name"
								placeholder=""></td>
						</tr>
						<tr>
							<td><label class="label">Experience</label></td>
							<td><input class="input" type="number" name="Experience"
								placeholder=""></td>
						</tr>
						<tr>
							<td><label class="label">Password</label></td>
							<td><input class="input" type="password" name="Password"
								placeholder=""></td>
						</tr>
						<tr>
							<td><label class="label">Course ID</label></td>
							<td><input class="input" type="number" name="Course_id"
								placeholder=""></td>
						</tr>
					</table>
					<div class="space"></div>
					<div class="buttonHolder">
						<input id="LoginButton" class="input" type="submit"> <a
							id="LoginButton" href="AdminServices.html">Back</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>