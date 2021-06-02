
<%
Boolean success = (Boolean) request.getAttribute("success");
String Message = (String) request.getAttribute("Message");
%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="ISO-8859-1">
		
		<title>IT Services Portal</title>
		
		<link rel="stylesheet" href="Style.css" type="text/css">
		
		<script> type="text/javascript"; src="validate.js"</script>
		<script src="https://code.jquery.com/jquery-1.10.2.js"
		type="text/javascript"></script>
		<div class="header">
			<h1>Reporting Form</h1>

		</div>
	</head>

	<body>
		<div class="body">
				<br />
				<h3>Please fill up all the requreid details to report an issue</h3>
				<form method = "post" action="ReportingPage">
					  <label for="issues">Please select one of the listed issues that you wish to report :</label>
						<select name="issue" id="issue" >
							<option value="Network">Network issues</option>
							<option value="Software">Software issues</option>
							<option value="Hardware">Hardware issues</option>
							<option value="Email">Email issues</option>
							<option value="Account">Account issues</option>
							<option value="Other">Other issues</option>
						</select>
						<br/>
						<label for="subissues">Please select Sub Category :</label>
						<select name="subissue" id="subissues" >
							<option value=""></option>
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

							$('#issue').on('change', function(){
                            $('#subissues').html('');
							
							if($('#issue').val()== "Network"){
                            $('#subissues').append('<option value="Internet">Internet issues</option>');
                            $('#subissues').append('<option value="Wifi">Wifi Issue</option>');
                            $('#subissues').append('<option value="System">System Issue</option>');
                              }

                            if($('#issue').val()== "Software"){
                            $('#subissues').append('<option value="Email">Email issues</option>');
                            $('#subissues').append('<option value="Crash">Software Crash Issue</option>');
                            $('#subissues').append('<option value="Storage">Storage Issue</option>');
                            }
							 
                            if($('#issue').val()== "Hardware"){
                            $('#subissues').append('<option value="Printing">Printing issues</option>');
                            $('#subissues').append('<option value="Hard">Hard Drive Issue</option>');
                            $('#subissues').append('<option value="LCD">LCD Issue</option>');
                            } 
							if($('#issue').val()== "Email"){
                            $('#subissues').append('<option value="Email">Email issues</option>');
                            $('#subissues').append('<option value="Forget">Forget Password Issue</option>');
                            $('#subissues').append('<option value="Request">Request Login</option>');
                            } 
							if($('#issue').val()== "Account"){
                            $('#subissues').append('<option value="Account">Account issues</option>');
                            $('#subissues').append('<option value="Crash">Software Crash Issue</option>');
                            } 
                            });
						</script>
					</div>
					<br/>
					<button type="submit" name ="button" value="submit" >Submit</button><br/>
				</form>
				<%
				//Display Messages/Errors on Home screen while playing Game
				if (Message != null) {
				%>
				<p>
					<em><%=Message%></em>
				</p>
				<%
				}
				%>
		</div>
	</body>
	<footer>
		<p2 class="footer" >&copy; Group number 18</p2>
		<p3 class="email" >Group-number-18@uon.edu.au</p3>
	</footer>
</html>




 
