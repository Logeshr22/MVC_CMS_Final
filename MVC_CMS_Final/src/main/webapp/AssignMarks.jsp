<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="app.css">
<meta charset="ISO-8859-1">
<title>Give Marks</title>
</head>
<body>
	<div class="topnav">
		<img src="Logo.png" id="logo">
		<h1>
			<a class="active" href="ProfessorLogin.html">Professor</a>
		</h1>
		<h1>
			<a class="Link" href="StudentLogin.html">Student</a>
		</h1>
		<h1>
			<a class="Link" href="AdminLogin.html">Admin</a>
		</h1>
		<a class="Link" href="index.html">Home</a>
	</div>
	<h1 class="header">Assign Marks</h1>
	<%
	Statement stmt = null;
	Connection con = null;
	ResultSet resultSet = null;
	PreparedStatement pstmt = null;
	int cid = (int) session.getAttribute("cid");
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/crs";
		String user = "root";
		String pwd = "Logesh88823";
		con = DriverManager.getConnection(url, user, pwd);
		String sql = "select * from student where cid=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, cid);
		resultSet = pstmt.executeQuery();
	%>
	<div class="formContainer">
		<div class="list">
			<table class="displayTable">
				<tr>
					<th class="displayTableData">Student ID</th>
					<th class="displayTableData">Student Name</th>
					<th class="displayTableData">Course ID</th>
				</tr>

				<%
				while (resultSet.next()) {
				%>
				<tr>
					<td class="displayTableData"><%=resultSet.getInt("sid")%></td>
					<td class="displayTableData"><%=resultSet.getString("sname")%></td>
					<td class="displayTableData"><%=resultSet.getInt("cid")%></td>
				</tr>
				<%
				}
				} catch (Exception e) {
				out.println(e);
				}
				%>
			</table>
			<div id="inputForm">
				<form action="AssignMarks" method="post">
					<table>
						<tr>
							<td><label class="label" for="sid">Student ID</label></td>
							<td><input class="input" type="text" name="sid"></td>
						</tr>
						<tr>
							<td><label class="label" for="mark">Enter marks</label></td>
							<td><input class="input" type="text" name="mark"></td>
						</tr>
						<tr>
							<td><label class="label" for="grade">Enter grade</label></td>
							<td><input class="input" type="text" name="grade"></td>
						</tr>
					</table>
					<div class="buttonHolder">
						<input id="LoginButton" class="input" type="submit">
					</div>
				</form>
			</div>

		</div>
	</div>
</body>

</html>