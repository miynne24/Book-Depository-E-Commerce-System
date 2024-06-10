<!DOCTYPE html>
<!-- Created By CodingLab - www.codinglabweb.com -->

<html lang="en" dir="ltr">
  <head>
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" /> <!-- untuk backbutton -->

<!-- untuk back button -->
<style>

.back-button {
		position: fixed;
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
	input:disabled:hover,
  input[readonly]:hover {
    background-image: url('path/to/ban-icon.png');
    background-repeat: no-repeat;
    background-position: right center;
    background-size: 20px 20px;
    padding-right: 30px; /* Adjust padding to make space for the icon */
    cursor: not-allowed;
  }
</style>
    <meta charset="UTF-8">
    <title> Student Registration Form  </title>
    <link rel="stylesheet" href="css/studRegStyle.css">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     
     <script>
     function text(x){
    	 
    	
    	if(x == 1){
    		document.getElementById("myResident").style.display = "block";
 			document.getElementById("myNon").style.display = "none";
    	}
    	
    	else if(x == 2){
    		document.getElementById("myResident").style.display = "none";
 			document.getElementById("myNon").style.display = "Block";
    	}
    
 		return ;
  	}
     </script>
   </head>
<body>
<!-- untuk back button -->
<div class="back-button">
	<a href="studLogin.jsp">
		<i class="fas fa-arrow-left"></i> 
	</a>
</div>
<!--  -->
  <div class="container">
    <div class="title">Registration</div>
    <div class="content">
      <form action="RegisterController" method="post">
        <div class="user-details">
    
          <div class="input-box">
          <label>First Name</label>
          <input type="text" name="sfname" placeholder="Enter first name" required />
        </div>
        
          <div class="input-box">
          <label>Last Name</label>
          <input type="text" name="slname" placeholder="Enter last name" required />
        </div>

		<div class="input-box">
          <label>Student ID</label>
          <input type="Number" name="studentID" placeholder="Enter Student ID" required />
        </div>
        <div class="input-box">
          <label>Group</label>
          <input type="text" name="sgroup" placeholder="Enter group" required />
        </div>
        
        <div class="input-box">
          <label>Course Code</label>
          <input type="text" name="scoursecode" placeholder="Enter course code" required />
        </div>
        
       	<div class="input-box">
          <label>Faculty</label>
          <input type="text" name="sfaculty" placeholder="Enter faculty" required />
        </div>
        
        <div class="input-box">
            <label>Contact</label>
            <input type="text" name="scontact" placeholder="Enter contact" required pattern="01\d{8,9}" />
        </div>
        
          <div class="gender-details">
        	<input type="radio" name="sgender" value="male" id="dot-1">
          	<input type="radio" name="sgender" value="female" id="dot-2">
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
            <input type="password" name="spassword" placeholder="Enter password" required />
          </div>
           
          <div class="type">
        	<input type="radio" name="stype"	value="resident" id="dot-3" onclick="text(1)">
         	<input type="radio" name="stype" value="nonresident" id="dot-4" onclick="text(2)">
          	<label>Type</label>
          	<div class="category">
            	<label for="dot-3">
            	<span class="dot three"></span>
            	Resident
          	</label>
          	<label for="dot-4">
            	<span class="dot four"></span>
            	Non-Resident
          	</label>
          	</div>
          </div>
         
        <div class ="input-group" id="myResident">
        <div class="input-box">
            <label>RoomNum</label>
            <input type="text" name="room" placeholder="Enter room number"  />
        </div>
        
         <div class="input-box">
            <label>Block</label>
            <input type="text" name="block" placeholder="Enter block"  />
        </div>
        </div>
        
        <div class ="input-group" id="myNon">
        <div class="input-box">
            <label>Address</label>
            <textarea name="address" rows = "3" cols = "50"  placeholder = "Enter Address" ></textarea>
        </div>
        
         <div class="input-box">
            <label>Postcode</label>
            <input type="text" name="postcode" placeholder="Enter postcode"  />
        </div>
        </div>
        
          </div>
        <div class="button">
          <input type="submit" value="Register">
        </div>
      </form>
    </div>
  </div>

</body>
</html>