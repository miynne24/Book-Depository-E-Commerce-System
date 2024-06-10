<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
</head>
<link rel="stylesheet" href="css/SLogin.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
<style>
.back-button {
		position: absolute;
		top: 20px;
		left: 20px;
	}

	.back-button a {
		display: inline-flex;
		align-items: center;
		padding: 10px 15px;
		background-color: #333;
		color: #fff;
		text-decoration: none;
		border-radius: 5px;
	}

	.back-button a i {
		margin-right: 5px;
	}

	.back-button a:hover {
		background-color: #555;
	}
</style>
<body>
<div class="back-button">
	<a href="homepage.jsp">
		<i class="fas fa-arrow-left"></i> 
	</a>
</div>
	<section>
		<form action="LoginAdminController" method="POST">
		<div class="form-box">
			<div class ="form-value">
				<h2>Login</h2>
         		
				<div class ="inputbox">
					<input type = "number" name="ADMINID" required class="no-spinner">
					<label for= "Admin ID">Admin ID</label>
				</div>
				<div class ="inputbox">
					<input type = "Password" name="ADPASSWORD" required>
					<label for= "Admin Password">Password</label>
				</div>
				<a href="Admin.jsp">
  					<button>Log in</button>
				</a>
				</div>
	</div>
	</form>
	</section>
	
</body>
</html>