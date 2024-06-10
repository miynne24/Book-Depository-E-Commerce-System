<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%if(session.getAttribute("sessionADMINID")==null)	  
    response.sendRedirect("adminLogin.jsp"); %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="book.model.Student" %>
<%@ page import="book.model.NonResidentStudent" %>
<%@ page import="book.model.ResidentStudent" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/adminRegStyle.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Admin</title>
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
</head>
<body>
<!-- untuk back button -->
<div class="back-button">
	<a href="RegisterAdminController?action=admindetail&ADMINID=<c:out value="${sessionScope.sessionADMINID}"/>">
		<i class="fas fa-arrow-left"></i> 
	</a>
</div>
<!--  -->
	<div class="container">
    <div class="title">Update Admin</div>
    <div class="content">
    <form action="UpdateAdminController" method="POST">
    
    <div class="user-details">
    	<c:set var="ADMINID" value="${sessionScope.sessionADMINID }"/>
    	
        <div class="input-box">
				<label for="ADMINID">Admin ID:</label>
      			<input type="text" name="ADMINID" value="<c:out value='${ADMINID}'/>" readonly/><br>
			</div>
			<div class="input-box"></div>
	        
	        <div class="input-box">
	        	<label>First Name</label>
	        	<input type="text" name="adfname" value="${admin.ADFNAME}" readonly />
	        </div>
	        
			<div class="input-box">
	        	<label for="adlname">Last Name:</label>
	        	<input type="text" name="adlname" id="adlname" value="${admin.ADLNAME}" readonly><br>
	        </div>
	        
	        <div class="input-box">
	        	<label for="adcontact">Contact:</label>
	        	<input type="text" name="adcontact" id="adcontact" value="${admin.ADCONTACT}" required pattern="01\d{8,9}"><br>
	       
	       <div class="input-box">
            <label for="adgender">Gender:</label>
            <input type="text" name="adgender" id="adgender" value="${admin.ADGENDER}" readonly><br>
          </div>
           
	        <div class="input-box">
	        	<label for="adpassword">Password:</label>
	        	<input type="password" name="adpassword" id="adpassword" value="${admin.ADPASSWORD}" ><br>
	        </div>

		<div class="button">
        <input type="submit" value="Update">
        </div>
        </div>
    </form>
    </div>
    </div>
</body>
</html>
