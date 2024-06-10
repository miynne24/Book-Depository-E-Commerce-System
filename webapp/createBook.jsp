
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="book.model.*" %>
<%@ page import= "book.dao.*" %>
<%@ page import="java.util.List" %>

<%
    List<Admin> adminList = AdminDAO.getAllAdmins();
    request.setAttribute("adminList", adminList);
%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Create Book</title>
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
    <h2>Create Book</h2>
    <form action="BookController" method="POST" >
      <div class="form-group">
      
        <label for="btitle">Title:</label>
        <input type="text" id="btitle" name="btitle" required>
      </div>
      <div class="form-group">
        <label for="bauthor">Author:</label>
        <input type="text" id="bauthor" name="bauthor" required>
      </div>
      <div class="form-group">
        <label for="bgenre">Genre:</label>
        <select id="bgenre" name="bgenre" required>
          <option value="">Select Genre</option>
         <option value="Computer">Computer</option>
          <option value="Science">Science</option>
          <option value="Architecture">Architecture</option>
          <option value="Mathematics">Mathematics</option>
          <option value="English">English</option>
          <option value="AI Tech">AI</option>
          <!-- Add more genre options as needed -->
        </select>
      </div>
      <div class="form-group">
        <label for="bcoursecode">Course Code:</label>
        <select id="bcoursecode" name="bcoursecode" required>
          <option value="">Select Genre</option>
          <option value="CS110">CS110</option>
          <option value="CS230">CS230</option>
          <option value="CS251">CS251</option>
          <option value="CS253">CS253</option>
          <option value="CS255">CS255</option>
          <option value="CS266">CS266</option>
          <!-- Add more genre options as needed -->
        </select>
      </div>
      <div class="form-group">
        <label for="bprice">Price:</label>
        <input type="number" id="bprice" name="bprice" step=".01" required>
      </div>
      <div class="form-group">
        <label for="bcondition">Condition:</label>
        <select id="bcondition" name="bcondition" required>
          <option value="">Select Genre</option>
          <option value="New Book">New Book</option>
          <option value="Like New">Like New</option>
          <option value="Used Book with some defects">Used Book with some defects</option>
          
         
        </select>
      </div>
      <div class="form-group">
        <label for="bdistributor">Distributor:</label>
        <input type="text" id="bdistributor" name="bdistributor" required>
      </div>
      
      
    <div class="form-group">
    <label for="adminID">Admin Name:</label>
    <select id="adminID" name="adminID" required>
        <option value="">Select Admin</option>
        <c:forEach var="admin" items="${adminList}">
            <option value="${admin.ADMINID}">${admin.ADFNAME} ${admin.ADLNAME}</option>
        </c:forEach>
    </select>
</div>
      
      <button type="submit"  >Add Book</button>
    </form>
  </div>
</body>
</html>