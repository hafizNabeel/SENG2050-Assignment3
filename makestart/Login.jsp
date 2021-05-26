<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		
		<title>IT Services Portal</title>
		
		<link rel="stylesheet" href="Style.css" type="text/css">
		
		<script> type="text/javascript"; src="validate.js"</script>

		<div class="header">
			<h1>IT Services Portal</h1>

		</div>
	</head>

	<body>
		<div class="body">
				<br />
				<h3>To log in please enter valid username and paaswor</h3>
				<form method = "post" action="MainPage">
					<label>User name:</label>
					<input type="text" name ="username" required></input>
					
					<label>Password: </label>
					<input type="password" name ="password" required></input><br/>
					<button type="submit" name ="button" value="submit" >Submit</button><br/>
				</form>
		</div>
	</body>
	<footer>
		<p2 class="footer" >&copy; Group number 18</p2>
		<p3 class="email" >Group-number-18@uon.edu.au</p3>
	</footer>
</html>