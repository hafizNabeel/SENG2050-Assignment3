<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">

		<title>IT Services Portal</title>

		<link rel="stylesheet" href="Style.css" type="text/css">

		<script> type="text/javascript"; src="validate.js"</script>

		<div class="header">
			<div class=NavBar>
				<h1>IT Services Portal</h1>
			</div>
		</div>
	</head>

	<body>
		<div class="body">
				<br />
				<h3>Please fill up all the requrid details to report an issue</h3>
				<form method = "post" action="Login">
					  <label for="issues">Please selesct one of the listed issues that you wish to report :</label>
						<select name="issue" id="issue" >
							<option value="Network">Network issues</option>
							<option value="Software">Software issues</option>
							<option value="Hardware">Hardware issues</option>
							<option value="Email">Email issues</option>
							<option value="Account">Account issues</option>
							<option value="Other">Other issues</option>
						</select>
						<br/><br/>
						<label>First name:</label>
						<input type="text" name ="firstName" required></input><br/><br/>

						<label>Last name:</label>
						<input type="text" name ="lastName" required></input><br/><br/>

						<label>Comments:</label><br/>
						<input class="comments"  type="text" name ="comments" required></input><br/><br/>
					<br/>
					<div id="clockbox">
						<script type="text/javascript">
							function timeAndDate(){
							let dates = new Date();
							let hours = dates.getHours(), minutes = dates.getMinutes(), secounds = dates.getSeconds(), PmAm;
							let months = dates.getMonth(), date = dates.getDate(), years = dates.getFullYear();
							if(hours == 0)
							{
							PmAm = "AM";
							hours = 12;
							}
							else if(hours < 12)
							{
								PmAm = "AM";
							}
							else if(hours == 12)
							{
								PmAm = "PM";
							}
							else if(minutes <= 9)
							{
								minutes = "0" +minutes;
							}
							else if(hours > 12)
							{
								PmAm = "PM";
								hours -= 12;
							}
							else if(secounds <= 9)
							{
							 secounds = "0" +secounds;
							}

							let display = "" +date+ "/" +(months+1)+ "/" +years+ " " +hours+ ":" +minutes+ ":" +secounds+PmAm+ "";
							document.getElementById('clockbox').innerHTML=display;
							}

							timeAndDate();
							setInterval(timeAndDate,1000);
						</script>

					</div>
					<br/>
					<button type="submit" name ="button" value="submit" >Submit</button><br/>
				</form>
		</div>
	</body>
	<footer id="footer">
		<p><b>Company: Group 18 <br>
			Email: Group18@something.com.au </b>
		<br>  Copyright &copy; 2021 </p>
	</footer>
</html>
