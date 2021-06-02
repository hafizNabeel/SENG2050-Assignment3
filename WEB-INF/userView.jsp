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
			</div>
		</div>
	</head>

	<body>
		<div class="body">
				<br>
				<h3>Welcome to IT Portal ${sessionScope.person.fname}</h3>
				<form method = "POST" action="UserMenu">
					<button type="submit" name ="button" value="view" >View Issues</button>
					<button type="submit" name ="button" value="knowledge" >Knowledge Base</button>
					<button type="submit" name ="button" value="new" >Open New Issues</button>
					<button type="submit" name ="button" value="main" >Log Out</button>
				</form>
		</div>
	</body>
	<footer id="footer">
		<p><b>Company: Group 18 <br>
			Email: Group18@something.com.au </b>
		<br>  Copyright &copy; 2021 </p>
	</footer>
</html>
