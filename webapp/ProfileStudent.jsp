<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%if(session.getAttribute("sessionStudentID")==null)	  
    response.sendRedirect("studLogin.jsp"); %>  
<%@ page import="book.model.*" %>
<%@ page import= "book.dao.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>My Profile</title>
  <style>
    body {
      background: linear-gradient(135deg, #71b7e6, #9b59b6);
      background-repeat: no-repeat;
      background-size: cover;
      background-position: center;
      background-color: rgb(219, 219, 219);
      font-family: Arial, sans-serif;
    }
    
    .container {
      max-width: 400px;
      margin: 0 auto;
      padding: 20px;
      background-color: #fff;
      border-radius: 20px;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }
    
    h2 {
      text-align: center;
      margin-top: 0;
    }
    h1 {
    	text-align: center;
      	margin-top: 0;
      	margin-bottom:0;
      	
    }
    a{
    	font-size:150px;
    	text-align:center;
    }
    
    .form-group {
      margin-bottom: 15px;
    }
    
    label {
    text-align:center;
      display: block;
      margin-bottom: 5px;
    }
    
    input[type="text"],
    select {
      width: 100%;
      padding: 8px;
      border: 4px solid #ccc;
      border-radius: 10px;
      box-sizing: border-box;
    }
    
    textarea {
      width: 100%;
      padding: 8px;
      border: 1px solid #ccc;
      border-radius: 4px;
      box-sizing: border-box;
      resize: vertical;
    }
    
 .btn {
    
    padding: 6px 12px;
    margin-bottom: 0;
    font-size: 20px;
    font-weight: 400;
    line-height: 1.42857143;
    text-align: center;
    vertical-align: middle;
    -ms-touch-action: manipulation;
    touch-action: manipulation;
    cursor: pointer;
    border: 1px solid transparent;
    border-radius: 8px;
    color: #fff;
    background-color: orange;
  }

  .btn-primary:hover {
    color: #fff;
    background-color: #286090;
    border-color: #204d74;
  }
    
    /* Home button styles */
    .home-button {
      position: fixed;
      top: 20px;
      left: 20px;
      width: 40px;
      height: 40px;
      background-color: #040a0e;
      border-radius: 50%;
      border: none;
      color: #fff;
      font-size: 20px;
      text-align: center;
      line-height: 40px;
      cursor: pointer;
    }

    /* Adjust the positioning of the container to make space for the home button */
    .container {
      max-width: 400px;
      margin: 60px auto 0;
      /* Rest of the existing container styles */
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
<a href="Student.jsp" class="home-button">&#8962;</a> <!-- Add the home button -->
  <div class="container">
    <h2>My Profile</h2>
    <h1><a> &#128100;</a></h1>
    <form action="UpdateStudentController" method="get"></form> 
         <div class="form-group">
         <c:set var="stype" value="${sessionScope.sessionStype}" />
    	<c:set var="studentID" value="${sessionScope.sessionStudentID }"/>
    	
        <!-- Add a hidden input field to store the student type -->
        <input type="hidden" name="stype" value="${stype}">
        <!-- Display the room and block fields for resident students only -->
        <c:if test="${stype eq 'resident'}">
        First name :
        <c:out value="${student.sfname}"></c:out> <br></br>

		Last name :
        <c:out value="${student.slname}"></c:out><br></br>
      
        Course Code :
       <c:out value="${student.scoursecode}"></c:out><br></br>
      	
      	Group :
	    <c:out value="${student.sgroup}"></c:out><br></br>
	    
	    Faculty :
	   <c:out value="${student.sfaculty}"></c:out><br></br>
	    
	    Contact :
	    <c:out value="${student.scontact}"></c:out><br></br>
	    
	    Gender :
	    <c:out value="${student.sgender}"></c:out><br></br>
	    
	    Room Number :
        <c:out value="${student.room}"></c:out><br></br>
        
        Block :
        <c:out value="${student.block}"></c:out><br></br>
        
        Password :
        <c:out value="${student.spassword}"></c:out><br></br>
	    </c:if>
	    
	    <c:if test="${stype eq 'nonresident'}">
	      First name :
        <c:out value="${student.sfname}"></c:out> <br></br>

		Last name :
        <c:out value="${student.slname}"></c:out><br></br>
      
        Course Code :
       <c:out value="${student.scoursecode}"></c:out><br></br>
      	
      	Group :
	    <c:out value="${student.sgroup}"></c:out><br></br>
	    
	    Faculty :
	   <c:out value="${student.sfaculty}"></c:out><br></br>
	    
	    Contact :
	    <c:out value="${student.scontact}"></c:out><br></br>
	    
	    Gender :
	    <c:out value="${student.sgender}"></c:out><br></br>
	    
	    Address :
        <c:out value="${student.address}"></c:out><br></br>
        
       	Postcode :
        <c:out value="${student.postcode}"></c:out><br></br>
        
         Password :
        <c:out value="${student.spassword}"></c:out><br></br>
	    </c:if>
	    
      </div>
      
      <a class="btn btn-primary" href="UpdateStudentController?action=updateStudent&studentID=<c:out value="${sessionScope.sessionStudentID}"/>">Update</a>
  </div>
</body>
</html>