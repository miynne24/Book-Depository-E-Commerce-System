<!DOCTYPE html>
<!-- Created By CodingLab - www.codinglabweb.com -->
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <title> Admin Registration Form  </title>
    <link rel="stylesheet" href="css/adminRegStyle.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" /> <!-- untuk backbutton -->

<!-- untuk back button -->
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
     <meta name="viewport" content="width=device-width, initial-scale=1.0">

   </head>
<body>
<!-- untuk back button -->
<div class="back-button">
	<a href="Admin.jsp">
		<i class="fas fa-arrow-left"></i> 
	</a>
</div>
<!--  -->
  <div class="container">
    <div class="title">Admin Registration</div>
    <div class="content">
      <form action="RegisterAdminController" method="post">
        <div class="user-details">
    
          
          
          <div class="input-box">
          <label>Admin ID</label>
          <input type="Number" name="adminID" placeholder="Enter Admin ID" required />
     	  </div>
    
     	  <div class="input-box">
          <label>First Name</label>
          <input type="text" name="adfname" placeholder="Enter first name" required />
          </div>
       
          <div class="input-box">
          <label>Last Name</label>
          <input type="text" name="adlname" placeholder="Enter last name" required />
		  </div>
		
    
        	<div class="input-box">
            <label>Contact</label>
            <input type="text" name="adcontact" placeholder="Enter contact" required pattern="01\d{8,9}" />
        	</div>
        	
        
          <div class="gender-details">
        	<input type="radio" name="adgender" value="male" id="dot-1">
          	<input type="radio" name="adgender" value="female" id="dot-2">
         	<label>Gender</label>
         	 <div class="category">
           		<label for="dot-1">
            	<span class="dot one"></span>
            	<span class="gender">Male</span>
          		</label>
          		<label for="dot-2">
           		<span class="dot two"></span>
            	<span class="gender">Female</span>
          		</label>
          	</div>
          </div>
         
          	<div class="input-box">
          	<label>Password</label>
            <input type="password" name="adpassword" placeholder="Enter password" required />
			</div>

     	   <div class="button">
          <input type="reset" value="Reset">
        </div>
        <div class="button">
          <input type="submit" value="Register">
        </div>
      </form>
    </div>
  </div>

</body>