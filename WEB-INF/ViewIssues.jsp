<%@page import="java.sql.*" %>
<%@page import="javax.sql.*" %>
<%@page import="javax.naming.InitialContext" %>
<%@page import="java.util.*" %>
<%	
	InitialContext ctx = new InitialContext();
	DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/itservices");

	Connection conn = ds.getConnection();
	String query = "SELECT * FROM Issues";
	Statement stat = conn.createStatement();
	ResultSet rs = stat.executeQuery(query);
 %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>User Issues</title>
		<link rel="stylesheet" href="Style.css" type="text/css">
		<script src="sortTable.js"></script>

		<div class="header">
			<h1>User Issues</h1>
		</div>
	</head>

	<body>
		<div class="body">
			<br>
			<h3>Below is a list of current user issue, click on the desired issue to be taken to its dedicated page</h3>
			<table id="table">
				<tr>
					<th onClick = 'sortTable(0)'>Issue Number</th>
					<th onClick = 'sortTable(1)'>Date</th>
					<th>Title</th>
					<th onClick = 'sortTable(3);'>Category</th>
					<th onClick = 'sortTable(4)'>Status</th>
				</tr>
                <%
					while(rs.next()){
						String issueID = rs.getString("issueID");
						String status = rs.getString("issueState");
						String category = rs.getString("category");
						String title = rs.getString("title");
						String date = rs.getString("dateReported");
						%>
						<tr onClick="location.href = 'issue.jsp?id=<%= issueID%>';">
							<td><%= issueID%></td>
							<td><%= date%></td>
							<td><%= title%></td>
							<td><%= category%></td>
							<td><%= status%></td>
						</tr>
				<%	}
				conn.close();
				%>
			</table>
		</div>
	</body>
	<footer>
		<p class="footer" >&copy; Group number 18</p><br/>
		<p class="email" >Group-number-18@uon.edu.au</p>
	</footer>
</html>