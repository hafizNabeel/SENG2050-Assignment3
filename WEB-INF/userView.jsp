<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">

		<title>IT Services Portal</title>

		<link rel="stylesheet" href="Style.css" type="text/css">

		<script> type="text/javascript"; src="validate.js"</script>

		<div class="header">
			<div class=NavBar>
				<a href="/SENG2050-Assignment3/UserMenu"> <h1>IT Services Portal</h1> </a>
                <a href="/SENG2050-Assignment3/IssueList">View Issues</a>
                <a href="/SENG2050-Assignment3/KBase">Knowledge Base</a>
                <a href="/SENG2050-Assignment3/CreateIssue">Open new Issues</a>
                <a href="/SENG2050-Assignment3/MainPage">Log Out</a>
			</div>
		</div>
	</head>

	<body>
		<div class="body">
				<br />
				<h3>Welcome to IT Portal ${sessionScope.person.fname}</h3>
		</div>
	</body>
	<footer id="footer">
		<p><b>Company: Group 18 <br>
			Email: Group18@something.com.au </b>
		<br>  Copyright &copy; 2021 </p>
	</footer>
</html>
