<html>
<head>
<title lang="eng">Welcome To Shoppers-Cart</title>
<script type="text/javascript"></script>
<style type="text/css">
h2 {
	color: white;
	background: black;
	padding: 20px
}

table {
	
	align-self: center;
	cellpadding: 20px;
}

td {
	border: 16px solid white;
}

h3 {
	color: red
}
</style>


</head>
<body>

	<h2>Shoppers Cart</h2>
	<form action="register" method="post">
	  <div align="right">
		<table align="center">
			<tr>
				<td>First Name : <input type="text" name="firstname" width="30"/><br /></td>
			</tr>

			<tr>
				<td>Last Name :<input type="text" name="lastname" width="30"/> <br /></td>
			</tr>
			<tr>
				<td>Email Address : <input type="text" name="email" width="30"/></td>
			</tr>
			<tr>
				<td>Mobile :<select type="text" name="countrycode" width="30">
						<option value="91">+91</option>
						<option value="00">+00</option>
						<option value="92">+92</option>
						<option value="93">+93</option>
						<option value="94">+94</option>
				</select> <input type="text" name="mobile" width="30"/></td>
			</tr>

			<tr>
				<td>Password : <input type="password" name="password" width="30"/> <br /></td>
			</tr>

			<tr>
				<td>Gender : male <input type="radio" name="gender"
					value="male" /> Female <input type="radio" name="gender"
					value="female" /></td>
			</tr>

			<tr>
				<td>Country :<select type="text" name="country" width="30">
						<option value="choose country">Choose Country</option>
						<option value="INDIA">INDIA</option>
						<option value="AUS">AUS</option>
						<option value="USA">USA</option>
						<option value="SAUDI ARABIA">SAUDI ARABIA</option>
						<option value="DUBAI">DUBAI</option>
				</select><br/>
		    <input type="checkbox" name="termandconditions"/> Terms And Conditions Apply <br/>
		    
		    <input type="submit" value="Register"/>
		    <a href="login.jsp">Already Having Account Click here to Login</a>
		</td>
		</table>
		</div>
	</form>






</body>
</html>
