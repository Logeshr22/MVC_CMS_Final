<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="app.css">
<title>View Professor details</title>
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

		String sql = "select * from professor";

		stmt = con.createStatement();
		resultSet = stmt.executeQuery(sql);
	%>
	<div class="formContainer">
		<h1 class="specialHeader">
			Professor List <span class="highlight">.</span>
		</h1>
		<div class="list">
			<table class="displayTable">
				<tr>
					<th class="displayTableData">Professor ID</th>
					<th class="displayTableData">Professor Name</th>
					<th class="displayTableData">Experience</th>
					<th class="displayTableData">Course ID</th>
				</tr>
				<%
				while (resultSet.next()) {
				%>
				<tr>
					<td class="displayTableData"><%=resultSet.getInt("pid")%></td>
					<td class="displayTableData"><%=resultSet.getString("pname")%></td>
					<td class="displayTableData"><%=resultSet.getInt("exp")%></td>
					<td class="displayTableData"><%=resultSet.getInt("cid")%></td>
				</tr>
				<%
				}
				} catch (Exception e) {
				out.println(e);
				}
				%>
			</table>
			<div class="space"></div>
			<form action="DeleteProfessor" method="post">
				<table class="center">
					<tr>
						<td><label class="label">Professor ID</label></td>
						<td><input class="input" type="number" name="prof_id"
							placeholder=""></td>
					</tr>
				</table>
				<div class="space"></div>
				<div class="buttonHolder">
					<input id="LoginButton" type="submit" value="Remove"> <a
						id="LoginButton" href="AdminServices.html">Back</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>