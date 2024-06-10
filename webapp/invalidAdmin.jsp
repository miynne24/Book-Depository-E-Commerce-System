<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<title>Invalid Login</title>
	<style>
		body {
			font-family: Arial, sans-serif;
			background: ;
			padding: 20px;
		}

		.container {
			background-color: #ffffff;
			border: 1px solid #cccccc;
			padding: 20px;
			margin: 0 auto;
			max-width: 400px;
			text-align: center;
		}

		h2 {
			color: #333333;
			margin-top: 0;
		}

		p {
			margin-bottom: 30px;
		}

		a {
			background-color: #007bff;
			color: #ffffff;
			padding: 10px 20px;
			border: none;
			border-radius: 4px;
			text-decoration: none;
		}

		a:hover {
			background-color: #0056b3;
		}
	</style>
</head>
<body>
	<div class="container">
		<h2>Invalid Login</h2>
		<p>You are either not a registered user<br><br>OR<br><br>You entered the wrong username or password.</p>
		<a href="adminLogin.jsp">Login Here</a>
	</div>
</body>
</html>
