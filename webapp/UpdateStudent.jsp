<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%if(session.getAttribute("sessionStudentID")==null)	  
    response.sendRedirect("studLogin.jsp"); %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="book.model.Student" %>
<%@ page import="book.model.NonResidentStudent" %>
<%@ page import="book.model.ResidentStudent" %>
<%@ page import="java.util.List" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/updateStudStyle.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Student</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" /> <!-- untuk backbutton -->
    
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
	<a href="UpdateStudentController?action=studentdetail&studentID=<c:out value="${sessionScope.sessionStudentID}"/>">
		<i class="fas fa-arrow-left"></i> 
	</a>
</div>
<!--  -->
	<div class="container">
    <div class="title">Update Student</div>
    <div class="content">
    <form action="UpdateStudentController" method="POST">
    <div class="user-details">
    	<c:set var="stype" value="${sessionScope.sessionStype}" />
    	<c:set var="studentID" value="${sessionScope.sessionStudentID }"/>
    	
        <!-- Add a hidden input field to store the student type -->
        <input type="hidden" name="stype" value="${stype}">
        
        <!-- Display the room and block fields for resident students only -->
        <c:if test="${stype eq 'resident'}">
	        <div class="input-box">
	        	<label for="studentID">Student ID:</label>
				<input type="text" name="studentID" value="<c:out value='${studentID}'/>" readonly/><br>
			</div>
			<div class="input-box"></div>
	        
	        <div class="input-box">
	        	<label>First Name</label>
	        	<input type="text" name="sfname" value="${student.sfname}" readonly />
	        </div>
	        
			<div class="input-box">
	        	<label for="slname">Last Name:</label>
	        	<input type="text" name="slname" id="slname" value="${student.slname}" readonly><br>
	        </div>

	        <div class="input-box">
	        	<label for="scoursecode">Course Code:</label>
	        	<input type="text" name="scoursecode" id="scoursecode" value="${student.scoursecode}" readonly><br>
	        </div>
	        
	        <div class="input-box">
	        	<label for="sgroup">Group:</label>
	        	<input type="text" name="sgroup" id="sgroup" value="${student.sgroup}" required><br>
	        </div>
	        
	        <div class="input-box">
	        	<label for="sfaculty">Faculty:</label>
	        	<input type="text" name="sfaculty" id="sfaculty" value="${student.sfaculty}" readonly><br>
	        </div>
	        
	        <div class="input-box">
	        	<label for="scontact">Contact:</label>
	        	<input type="text" name="scontact" id="scontact" value="${student.scontact}" required pattern="01\d{8,9}"><br>
	        </div>
	        
	        <div class="input-box">
            <label for="adgender">Gender:</label>
            <input type="text" name="adgender" id="adgender" value="${student.sgender}" readonly><br>
          </div>
           
	        <div class="input-box">
	        	<label for="spassword">Password:</label>
	        	<input type="password" name="spassword" id="spassword" value="${student.spassword}" ><br>
	        </div>
	        
	        <div class="input-box">
            	<label for="room">Room Number:</label>
            	<input type="text" name="room" id="room" value="${student.room}"><br>
			</div>
			<div class="input-box">
            <label for="block">Block:</label>
            <input type="text" name="block" id="block" value="${student.block}" ><br>
        	</div>
        </c:if>

        <!-- Display the address and postcode fields for non-resident students only -->
        <c:if test="${stype eq 'nonresident'}">
             <div class="input-box">
	        	<label for="studentID">Student ID:</label>
				<input type="text" name="studentID" value="<c:out value='${studentID}'/>" readonly/><br>
			</div>
			<div class="input-box"></div>
	        
	        <div class="input-box">
	        	<label>First Name</label>
	        	<input type="text" name="sfname" value="${student.sfname}" readonly />
	        </div>
	        
			<div class="input-box">
	        	<label for="slname">Last Name:</label>
	        	<input type="text" name="slname" id="slname" value="${student.slname}" readonly><br>
	        </div>

	        <div class="input-box">
	        	<label for="scoursecode">Course Code:</label>
	        	<input type="text" name="scoursecode" id="scoursecode" value="${student.scoursecode}" readonly><br>
	        </div>
	        
	        <div class="input-box">
	        	<label for="sgroup">Group:</label>
	        	<input type="text" name="sgroup" id="sgroup" value="${student.sgroup}" readonly><br>
	        </div>
	        
	        <div class="input-box">
	        	<label for="sfaculty">Faculty:</label>
	        	<input type="text" name="sfaculty" id="sfaculty" value="${student.sfaculty}" readonly><br>
	        </div>
	        
	        <div class="input-box">
	        	<label for="scontact">Contact:</label>
	        	<input type="text" name="scontact" id="scontact" value="${student.scontact}" required><br>
	        </div>
	        
	         <div class="gender-details">
        	<input type="radio" name="sgender" value="male"
        	 <c:if test="${student.sgender == 'male'||student.sgender == 'Male'}">selected</c:if> id="dot-1" required>
          	<input type="radio" name="sgender" value="female"
          	 <c:if test="${student.sgender == 'female'||student.sgender == 'Female'}">selected</c:if> id="dot-2">
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
	        	<label for="spassword">Password:</label>
	        	<input type="password" name="spassword" id="spassword" value="${student.spassword}" ><br>
	        </div>
	        
	        <div class="input-box">
            	<label for="address">Address:</label>
            	<textarea name="address" rows="5" cols="40" required>${student.address}</textarea><br>
			</div>
			<div class="input-box">
            	<label for="postcode">Postcode:</label>
            	<input type="text" name="postcode" value="${student.postcode}" required><br>
        	</div>
        </c:if>
		<div class="button">
        <input type="submit" value="Update">
        </div>
        </div>
    </form>
    </div>
    </div>
</body>
</html>
