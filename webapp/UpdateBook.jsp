<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="book.model.*" %>
<%@ page import= "book.dao.*" %>
<%@ page import="java.util.List" %>



<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Update Book</title>
  <style>
    body {
      background: linear-gradient(135deg, #71b7e6, #9b59b6);
      background-repeat: no-repeat;
      background-size: cover;
      background-position: center;
      background-color: rgb(219, 219, 219);
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
    
    .form-group {
      margin-bottom: 15px;
    }
    
    label {
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
    
    button[type="submit"] {
      display: block;
      width: 100%;
      padding: 10px;
      background-color: #4CAF50;
      color: white;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }
    
    button[type="submit"]:hover {
      background-color: #45a049;
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
  <script>
    function showMessage() {
      alert("New Book Succesfully Added!");
    }
  </script>
</head>
<body>
<a href="Admin.jsp" class="home-button">&#8962;</a> <!-- Add the home button -->
  <div class="container">
    <h2>Update Book</h2>
    <form action="BookController" method="POST" >
      <div class="form-group">
        
        <div class="form-group">
        <label for="bookID">Book ID:</label>
        <input type="number" id="bookID" name="bookID" value="<c:out value="${books.bookID}"/>" readonly>
      </div>
      
        <label for="btitle">Title:</label>
        <input type="text" id="btitle" name="btitle" value="<c:out value="${books.title}"/>"  readonly>
      </div>
      <div class="form-group">
        <label for="bauthor">Author:</label>
        <input type="text" id="bauthor" name="bauthor"  value="<c:out value="${books.author}"/>"  readonly>
      </div>
      
      <div class="form-group">
        <label for="bgenre">Genre:</label>
        <input type="text" id="bgenre" name="bgenre" value="<c:out value="${books.genre}"/>"  readonly>
      
      <div class="form-group">
        <label for="bcoursecode">Course Code:</label>
        <input type="text" id="bcoursecode" name="bcoursecode" value="<c:out value="${books.courseCode}"/>"  readonly>
      </div>
      
    <div class="form-group">
  <label for="bprice">Price:</label>
  <input type="number" id="bprice" name="bprice" step=".01" value="<c:out value="${books.price}" />" required>
</div>
      
<div class="form-group">
  <label for="bcondition">Condition:</label>
  <select id="bcondition" name="bcondition" required>
    <option value="">Select Condition</option>
    <option value="New Book" <c:if test="${books.condition == 'New Book'}">selected</c:if>>New Book</option>
    <option value="Like New" <c:if test="${books.condition == 'Like New'}">selected</c:if>>Like New</option>
    <option value="Used Book with some defects" <c:if test="${books.condition == 'Used Book with some defects'}">selected</c:if>>Used Book with some defects</option>
  </select>
</div>
      <div class="form-group">
        <label for="bdistributor">Distributor:</label>
        <input type="text" id="bdistributor" name="bdistributor" value="<c:out value="${books.distributor}"/>"  readonly>
      </div>
      
       <div class="form-group">
        
        <input type="hidden" id="adminID" name="adminID" value="<c:out value="${books.adminID}"/>"  readonly>
      </div>
      
      <button type="submit"  >Update Book</button>
    </form>
  </div>
</body>
</html>