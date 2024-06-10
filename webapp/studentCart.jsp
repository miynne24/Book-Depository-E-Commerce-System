
<%@ page import="book.model.*" %>
<%@ page import="book.dao.*" %>
<%@ page import="java.util.*" %>
<%@page import="java.text.DecimalFormat"%>
<%@ page import="book.connection.ConnectionManager" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%

DecimalFormat dcf = new DecimalFormat("#.##");
request.setAttribute("dcf", dcf);

ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
List<Cart> cartProduct =null;
if (cart_list != null){
  BookDAO bdao = new BookDAO();
  cartProduct = bdao.getCartProducts(cart_list);
  double total = bdao.getTotalCartPrice(cart_list);
  request.setAttribute("cart_list",cart_list);
  request.setAttribute("total", total);
}
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <title>Cart</title>
  <link rel="stylesheet" href="css/viewBook2.css" />
  <!-- Font Awesome Cdn Link -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" />
<style>
 body{
  height: 100vh;
  justify-content: center;
  align-items: center;
  background: linear-gradient(135deg, #71b7e6, #9b59b6);
  width:100%;
}
table {
    width: 80%;
    margin: 20px auto; /* Center the table on the page */
    border-collapse: collapse;
    background-color: #f2f2f2;
}
th, td {
  padding: 10px;
  text-align: left;
  border-bottom: 1px solid black; /* Change border color to black */
  border-right: 1px solid black; /* Add right border */
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

.btn {
  display: inline-block;
  padding: 6px 12px;
  margin-bottom: 0;
  font-size: 14px;
  font-weight: 400;
  line-height: 1.42857143;
  text-align: center;
  white-space: nowrap;
  vertical-align: middle;
  -ms-touch-action: manipulation;
  touch-action: manipulation;
  cursor: pointer;
  border: 1px solid transparent;
  border-radius: 4px;
  color: #fff;
  background-color: orange;
  border-color: #2e6da4;
}

.btn-danger {
  background-color: #d9534f;
  border-color: #d43f3a;
}

.btn-primary:hover,
.btn-danger:hover {
  color: #fff;
  background-color: #286090;
  border-color: #204d74;
}
.remove-button {
    background-color: #f44336;
    color: white;
    padding: 8px 12px;
    border-radius: 4px;
    text-decoration: none;
}
.remove-button:hover {
    background-color: #d32f2f;
}
.button-container{
  position: center;
  text-align: center;
}

.checkoutbutton {
    display: block;
    width: 150px;
    margin: 20px auto; /* Center the button on the page */
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    text-align: center;
    text-decoration: none;
    border-radius: 4px;
}
.total {
    font-weight: bold;
}
.centered-title {
    text-align: center;
}


</style>
  <script>
    function confirmLogout() {
      var result = confirm("Are you sure you want to log out?");
      return result;
    }
  </script>
</head>
<body>
  <header class="header">
    <div class="logo">
      <a href="Student.jsp">UiTM Preloved Book Depository System</a>
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
        <a href="Student.jsp">Dashboard</a>
        <a href="UpdateStudentController?action=studentdetail&studentID=<c:out value="${sessionScope.sessionStudentID}"/>">My Account</a>
        <a href="OrderController">View Order</a>
        <a href="BookController?action=listStud" >View Book</a>
        <a href="studentCart.jsp"  class="highlight-button">Cart</a>
      </div>
    </nav>

<div class="main-body">
      <h2>Cart</h2>
  
  <table class="table">
    <tr>
        <th>Book ID</th>
        <th>Title</th>
        <th>Genre</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Action</th>
    </tr>
    <tbody>
        <% if (cart_list != null) {
            for (Cart c : cartProduct) { %>
                <tr>
                    <td><%=c.getBookID()%></td>
                    <td><%=c.getTitle()%></td>
                    <td><%= c.getGenre()%></td>
                    <td><%= dcf.format(c.getPrice())%></td>
                    <td>
            <form action="order-now" method="post" class="form-inline">
            <input type="hidden" name="id" value="<%= c.getBookID()%>" class="form-input">
              <div class="form-group d-flex justify-content-between">
              <a class="btn btn-sm btn-decre" href="quantity-inc-dec?action=dec&BookID=<%=c.getBookID()%>"><i class="fas fa-minus-square"></i></a>
                <input type="text" name="quantity" class="form-control"  value="<%=c.getQuantity()%>" readonly> 
              <a class="btn bnt-sm btn-incre" href="quantity-inc-dec?action=inc&BookID=<%=c.getBookID()%>"><i class="fas fa-plus-square"></i></a> 
              </div>
            </form>
          </td>
                    <td><a href="RemoveFromCartController?BookID=<%=c.getBookID() %>" class="remove-button">Remove</a></td>
                </tr>
            <% }
        } %>
    </tbody>
</table>
  
  <br>
  <div class="button-container">
  <h3 class="centered-title">Total Price:RM ${total}</h3>
<br>
<br>
    <a href="cart-check-out" class="btn btn-primary">Proceed to Checkout</a>
  </div>
  </div>
  </div>
</body>
</html>