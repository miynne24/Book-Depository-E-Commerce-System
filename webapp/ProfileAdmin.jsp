<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%if(session.getAttribute("sessionADMINID")==null)	  
    response.sendRedirect("adminLogin.jsp"); %>  
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
      background-color: #71b7e6;
      height:100%;
      font-family: Arial,sans-serif;
    }
    
    .container {
      max-width: 400px;
      margin: 0 auto;
      padding: 20px;
      background-color: #fff;
      border-radius: 20px;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
      height: 640px;
    }
    
    h2 {
      text-align: center;
      margin-top: 0;
    }
    h1 {
    	text-align: center;
      	margin-top: 0;
      	margin-bottom:40px;
      	
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
<a href="Admin.jsp" class="home-button">&#8962;</a> <!-- Add the home button -->
  <div class="container">
    <h2>My Profile</h2>
    <h1><a> &#128100;</a></h1>
    <form action="RegisterAdminController" method="get">
         <div class="form-group">
    	<c:set var="ADMINID" value="${sessionScope.sessionADMINID }"/>
    	        
        First name :
         <c:out value="${admin.ADFNAME}"></c:out> <br></br><br>

        Last name :
        <c:out value="${admin.ADLNAME}"></c:out> <br></br><br>
  
	    Contact :
	    <c:out value="${admin.ADCONTACT}"></c:out> <br></br><br>
	    
	    Gender :
	    <c:out value="${admin.ADGENDER}"></c:out> <br></br><br>
	    
	    Password : 
	    <c:out value="${admin.ADPASSWORD}"></c:out> <br></br>
 
      </div>
      <a class="btn btn-primary" href="UpdateAdminController?action=updateAdmin&ADMINID=<c:out value="${sessionScope.sessionADMINID}"/>">Update</a>
      
  </form>
  </div>
  
</body>
</html>