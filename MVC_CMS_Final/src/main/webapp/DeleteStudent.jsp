<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Professor details</title>
</head>
<body>
		
<%

    Statement stmt = null;

    Connection con = null;

    ResultSet resultSet = null;

   

    

    try {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/crs";

        String user = "root";

        String pwd = "Shivani@1235";

        con = DriverManager.getConnection(url, user, pwd);

        String sql = "select * from student";

        stmt = con.createStatement();
		resultSet = stmt.executeQuery(sql);

    %>

<table border="1">

<tr>

<th>Student ID</th>

<th>Student Name</th>

<th>email</th>

<th>User_name</th>

<th>Course ID</th>
<th>Marks</th>





</tr>

<%

        while (resultSet.next()) {

        %>

<tr>

<td><%=resultSet.getInt("sid")%></td>

<td><%=resultSet.getString("sname")%></td>
<td><%=resultSet.getString("email")%></td>
<td><%=resultSet.getString("user_name")%></td>
<td><%=resultSet.getInt("cid")%></td>
<td><%=resultSet.getInt("mark")%></td>


</tr>

<%

        }

        } catch (Exception e) {

        out.println(e);

        }  

        %>
        
        
        
	<br>
	
	
</table>

	<form action="DeleteStudent" method="post">
		<label>Student Id to Be Deleted</label>
		<input type="text" name="stud_id" placeholder=""><br> <br>

		<input type="submit" value="Delete">
	</form>
</body>

</html>