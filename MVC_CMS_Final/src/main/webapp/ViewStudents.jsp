<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="app.css">
<meta charset="ISO-8859-1">
<title>View All Students</title>
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

        String sql = "select * from student";

        stmt = con.createStatement();
		resultSet = stmt.executeQuery(sql);
	%>
	<div class="formContainer">
		<h1 class="specialHeader">Students List <span class="highlight">.</span></h1>
		<div class="list">
			<table class="displayTable">
				<tr>
					<th class="displayTableData">Student ID</th>
					<th class="displayTableData">Student Name</th>
					<th class="displayTableData">Email</th>
					<th class="displayTableData">User Name</th>
					<th class="displayTableData">Course ID</th>
					<th class="displayTableData">Marks</th>
				</tr>
				<%
				while (resultSet.next()) {
				%>
				<tr>
					<td class="displayTableData"><%=resultSet.getInt("sid")%></td>
					<td class="displayTableData"><%=resultSet.getString("sname")%></td>
					<td class="displayTableData"><%=resultSet.getString("email")%></td>
					<td class="displayTableData"><%=resultSet.getString("user_name")%></td>
					<td class="displayTableData"><%=resultSet.getInt("cid")%></td>
					<td class="displayTableData"><%=resultSet.getInt("mark")%></td>
				</tr>
				<%
				}
				} catch (Exception e) {
				out.println(e);
				}
				%>
			</table>
			<div class="space"></div>
			<div class="buttonHolder">
				<a id="LoginButton" href="AdminServices.html">Back</a>
			</div>
		</div>
	</div>
</body>

</html>