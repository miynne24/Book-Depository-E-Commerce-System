<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%if(session.getAttribute("sessionStudentID")==null)	  
    response.sendRedirect("studLogin.jsp");
	
ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
List<Cart> cartProduct =null;
if (cart_list != null){
	
	request.setAttribute("cart_list",cart_list);
}

%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="book.model.Student" %>
<%@ page import="book.model.*" %>
<%@ page import="book.dao.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <title>Student Dashboard</title>
  <link rel="stylesheet" href="css/dashboardStyle.css" />
  <!-- Font Awesome Cdn Link -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" />
  <style>
    body {
      height: 100vh;
	  justify-content: center;
	  align-items: center;
	  background: linear-gradient(135deg, #71b7e6, #9b59b6);
	  width:100%;
	}
    }
  </style>
  <script>
	function confirmLogout() {
	  var result = confirm("Are you sure you want to log out?");
	  return result;
	}
</script>
<script>
  function redirectToPage() {
    window.location.href = 'BookController?action=listStud';
  }
</script>


<script>
function handleButtonClick() {
    var btitle = document.getElementById("btitle").value;
    if (btitle.trim() !== "") {
        location.href = 'BookController?action=searchstudent&btitle=' + encodeURIComponent(btitle);
    } else {
        // Handle empty search query (optional)
        alert("Please enter a search query.");
    }
}
</script>
</head>
<body>
  <header class="header">
    <div class="logo">
      <a href="Student.jsp">UiTM Preloved Book Depository System</a>
      <div class="search_box">
        <input type="text" placeholder="Search book by title" id="btitle" >
         <button onclick="handleButtonClick()">
        <i class="fa-sharp fa-solid fa-magnifying-glass"></i>
       </button>
      </div>
    </div>

    <div class="header-icons">
	  <a href="homepage.jsp" title="Log Out" onclick="return confirmLogout()"><i class="fas fa-sign-out-alt"> Log Out</i></a>
	  <div class="account">
	    <p style="font-size: 30px;"><a>&#128100;</a></p>
        <h4>Hello <c:out value='${sessionScope.sessionStudentFName}'/></h4>
        
      </div>
    </div>
  </header>
  <div class="container">
    <nav>
      <div class="side_navbar">
        <span>Main Menu</span>
        <a href="Student.jsp" class="active highlight-button">Dashboard</a>
        <a href="UpdateStudentController?action=studentdetail&studentID=<c:out value="${sessionScope.sessionStudentID}"/>">My Account</a>
        <a href="OrderController" >View Order</a>
        <a href="BookController?action=listStud">View Book</a>
        <a href="studentCart.jsp">Cart</a>

        <!--  <div class="links">
          <span>Quick Link</span>
          <a href="#">Paypal</a>
          <a href="#">EasyPay</a>
          <a href="#">SadaPay</a>
        </div>-->
      </div>
    </nav>

    <div class="main-body">
      <h2>Dashboard</h2>
      <div class="promo_card">
        <h1>Welcome to UiTM Preloved Book Depository!</h1>
        <span>Why spend fortune when you can spend for cheap!</span>
        <button onclick="redirectToPage()">Start Browsing</button>
      </div>

      <div class="history_lists">
        <div class="list1">
          <div class="row">
            <h4>Order History</h4>
            <a href="OrderController">See all</a>
          </div>
          <table>
            <thead>
              <tr>
                <th>#</th>
                <th>Dates</th>
                <th>Name</th>
                <th>Type</th>
                <th>Ammount</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>1</td>
                <td>2, Aug, 2022</td>
                <td>Sam Tonny</td>
                <td>Premimum</td>
                <td>RM 26.20</td>
              </tr>
              <tr>
                <td>2</td>
                <td>29, July, 2022</td>
                
                <td>Code Info</td>
                <td>Silver</td>
                <td>RM 124.20</td>
              </tr>
              <tr>
                <td>3</td>
                <td>15, July, 2022</td>
              
                <td>Jhon David</td>
                <td>Startup</td>
                <td>RM 52.00</td>
              </tr>
              <tr>
                <td>4</td>
                <td>5, July, 2022</td>
                <td>Salina Gomiz</td>
                <td>Premimum</td>
                <td>RM 19.10</td>
              </tr>
              <tr>
                <td>5</td>
                <td>29, June, 2022</td>
                <td>Gomiz</td>
                <td>Gold</td>
                <td>RM 21.20</td>
              </tr>
              <tr>
                <td>6</td>
                <td>28, June, 2022</td>
                <td>Elyana Jhon</td>
                <td>Premimum</td>
                <td>RM 252.00</td>
              </tr>
            </tbody>
          </table>
        </div>

        <div class="list2">
          <div class="row">
            <h4>New Books</h4>
            <a href="BookController?action=listStud">View</a>
          </div>
          <table>
            <thead>
              <tr>
                <th>#</th>
                <th>Title</th>
                <th>Type</th>
                <th>In Stocks</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>1</td>
                <td>CNIC</td>
                <td>PDF</td>
                <td>20</td>
              </tr>
              <tr>
                <td>2</td>
                <td>Passport</td>
                <td>PDF</td>
                <td>12</td>
              </tr>
              <tr>
                <td>3</td>
                <td>Licence</td>
                <td>PDF</td>
                <td>9</td>
              </tr>
              <tr>
                <td>4</td>
                <td>Pic</td>
                <td>Jpg</td>
                <td>22</td>
              </tr> 
              <tr>
                <td>5</td>
                <td>CNIC</td>
                <td>Jpg</td>
                <td>22</td>
              </tr> 
              <tr>
                <td>6</td>
                <td>Docx</td>
                <td>Word</td>
                <td>22</td>
              </tr> 
            </tbody>
          </table>
        </div>
      </div>
    </div>

    <div class="sidebar">
      <h4>Account Balance</h4>
      
      <div class="balance">
        <i class="fas fa-dollar icon"></i>
        <div class="info">
          <h5>Dollar</h5>
          <span><i class="fas fa-dollar"></i>25,000.00</span>
        </div>
      </div>
      
      <div class="balance">
        <i class="fa-solid fa-rupee-sign icon"></i>
        <div class="info">
          <h5>PKR</h5>
          <span><i class="fa-solid fa-rupee-sign"></i>300,000.00</span>
        </div>
      </div>

      <div class="balance">
        <i class="fas fa-euro icon"></i>
        <div class="info">
          <h5>Euro</h5>
          <span><i class="fas fa-euro"></i>25,000.00</span>
        </div>
      </div>

      <div class="balance">
        <i class="fa-solid fa-indian-rupee-sign icon"></i>
        <div class="info">
          <h5>INR</h5>
          <span><i class="fa-solid fa-indian-rupee-sign"></i>220,000.00</span>
        </div>
      </div>

      <div class="balance">
        <i class="fa-solid fa-sterling-sign icon"></i>
        <div class="info">
          <h5>Pound</h5>
          <span><i class="fa-solid fa-sterling-sign"></i>30,000.00</span>
        </div>
      </div>

    </div>
  </div>
</body>
</html>
