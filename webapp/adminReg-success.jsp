<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Registration Success</title>
	<style>
		body {
			font-family: Arial, sans-serif;
			background: #f1f1f1;
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

		.button {
			display: inline-block;
			background-color: #007bff;
			color: #ffffff;
			padding: 10px 20px;
			border: none;
			border-radius: 4px;
			text-decoration: none;
			transition: background-color 0.3s ease;
		}

		.button:hover {
			background-color: #0056b3;
		}
	</style>
</head>
<body>
	<div class="container">
		<h2>You have successfully registered new Admin!</h2>
		<p>New Admin have been added!</p>
		<a href="Admin.jsp" class="button">Continue</a>
	</div>
</body>
</html>
