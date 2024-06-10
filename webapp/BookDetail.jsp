<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="book.model.Book" %>



<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />

	<meta charset="UTF-8">
	<title>Book Detail</title>
	<style>
		body {
			background: linear-gradient(135deg, #71b7e6, #9b59b6);
			background-size: cover;
			background-color: rgb(219, 219, 219);
			font-family: Arial, sans-serif;
			padding: 20px;
			margin: 0;
			display: flex;
			align-items: center;
			justify-content: center;
			min-height: 100vh;
		}

		h1 {
			color: #333;
			text-align: center;
			margin-top: 0;
		}

		.container {
			background-color: white;
			padding: 30px;
			border-radius: 10px;
			box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
			width: 90%;
			max-width: 800px;
			margin-bottom: 20px;
		}

		table {
			width: 100%;
			border-collapse: collapse;
			border: 2px solid black; /* Add border style */
		}

		th:first-child,
		td:first-child {
			width: 200px; /* Set the width for the first column */
		}

		th, td {
			padding: 15px;
			text-align: center;
			border-bottom: 2px solid black; /* Change border color to black */
			border-right: 2px solid black; /* Add right border */
		}

		th:last-child,
		td:last-child {
			border-right: none; /* Remove right border for last column */
		}

		th {
			background-color: #f2f2f2;
		}

		tr:hover {
			background-color: #f5f5f5;
		}

		.container .button-container {
			text-align: center;
			margin-top: 20px;
		}

		.container .button-container button {
			display: inline-block;
			margin: 0 10px;
			padding: 10px 20px;
			border-radius: 5px;
			border: none;
			cursor: pointer;
		}
/* Example CSS styles for the button */
.button-container {
  text-align: center; /* Center the button horizontally within the container */
}

.btn {
  display: inline-block;
  padding: 10px 20px;
  background-color: #007bff; /* Primary button color, you can change it to your desired color */
  color: #fff; /* Button text color */
  border: none;
  border-radius: 5px;
  font-size: 16px;
  cursor: pointer;
  text-decoration: none;
  transition: background-color 0.3s ease;
}

/* Hover effect for the button */
.btn:hover {
  background-color: #0056b3; /* Change the background color on hover */
}

/* Active (clicked) state for the button */
.btn:active {
  background-color: #003973; /* Change the background color when the button is clicked */
}
		.container .button-container button.update-button {
			background-color: blue;
			color: #fff;
		}

		.container .button-container button.delete-button {
			background-color: red;
			color: #fff;
		}

		.container .button-container button:hover {
			opacity: 0.8;
		}
		
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
</head>
<body>
	<div class="back-button">
	<a href="BookController?action=list">
		<i class="fas fa-arrow-left"></i> 
	</a>
</div>
	<div class="container">
		<h1>Book Details</h1>
		<table>
			<tbody>
				<tr>
					<th>Book Title</th>
					<td><c:out value="${books.title}" /></td>
				</tr>
				<tr>
					<th>Author</th>
					<td><c:out value="${books.author}" /></td>
				</tr>
				<tr>
					<th>Course Code</th>
					<td><c:out value="${books.courseCode}" /></td>
				</tr>
				<tr>
					<th>Genre</th>
					<td><c:out value="${books.genre}" /></td>
				</tr>
				<tr>
					<th>Price</th>
					<td><c:out value="RM ${books.price}" /></td>
				</tr>
				<tr>
					<th>Distributor</th>
					<td><c:out value="${books.distributor}" /></td>
				</tr>
			</tbody>
		</table>
		<div class="button-container">
			<a class="btn btn-primary" href="BookController?action=updateBook&bookID=<c:out value="${books.bookID}"/>">Update</a>
			<button class="delete-button" onclick="confirmation('${books.bookID}')">Delete</button>
		</div>
	</div>
	
	 <script>
    function confirmation(bookID) {
      console.log(bookID);
      var r = confirm("Are you sure you want to delete?");
      if (r == true) {
        location.href = 'BookController?action=delete&bookID=' + bookID;
        alert("Book successfully deleted");
      } else {
        return false;
      }
    }
  </script>
</body>
</html>
