<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="book.model.Admin" %>
<%@ page import="java.util.List" %>
<%@ page import="book.model.Orders" %> <!-- Assuming you have an Order class -->
<%@ page import="book.controller.AdminOrderController" %>
<%@ page import="book.dao.*" %>
<%
    List<Admin> adminList = AdminDAO.getAllAdmins();
    request.setAttribute("adminList", adminList);
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <title>Orders </title>
  <link rel="stylesheet" href="css/OrderStyle.css" />
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
    /*for studentview*/
    
	button {
	  color: #fff;
	  cursor: pointer;
	  display: flex;
	  align-items: center;
	  width:15%;
	}
	
	.button i {
	  margin-right: 5px;
	}
	
  </style>
  <script>
	function confirmLogout() {
	  var result = confirm("Are you sure you want to log out?");
	  return result;
	}
	

</script>

  <script>
function handleButtonClick() {
    var btitle = document.getElementById("btitle").value;
    if (btitle.trim() !== "") {
        location.href = 'BookController?action=searchadmin&btitle=' + encodeURIComponent(btitle);
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
      <a href="Admin.jsp">UiTM Preloved Book Depository System</a>
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
        <h4>Welcome <c:out value='${sessionScope.sessionADFNAME}'/></h4>
      </div>
    </div>
  </header>
  <div class="container">
    <nav>
      <div class="side_navbar">
        <span>Main Menu</span>
        <a href="Admin.jsp" class="active">Dashboard</a>
        <a href="RegisterAdminController?action=admindetail&ADMINID=<c:out value="${sessionScope.sessionADMINID}"/>">My Account</a>
        <a href="listOrderAdmin.jsp" class="highlight-button">Orders</a>
        <a href="createBook.jsp">Create Book</a>
        <a href="BookController?action=list" >View Book</a>
        <a href="BookController?action=report">Report</a>
        <a href="AdminRegister.jsp">New Admin</a>


      </div>
    </nav>
    
    <main class="table">
        <section class="table__header">
            <h1>List Orders</h1>

        </section>
        <section class="table__body">
        
               <table>
        <tr>
            <th>Order ID</th>
            <th>Order Date</th>
            <th>Order Status</th>
            <th>Student ID</th>
            <th>Choose Admin</th>
            <th>Admin in-charge</th>
        </tr>
        <%-- Retrieve orders from the controller --%>
        <% List<Orders> orders = AdminOrderDAO.getAllOrders(); %>
        <%-- Iterate over the orders and display them --%>
        <% for (Orders order : orders) { %>
            <tr>
                <td><a href="OrderdetailsController?action=list&orderID=<%= order.getOrderID()  %>"/><%= order.getOrderID() %></a></td>
                <td><%= order.getOrderdate() %></td>
                <td>
               <form method="post" action="AdminOrderController?action=updateOrderStatus">
                  <input type="hidden" name="orderID" value="<%= order.getOrderID() %>" />
                  <select name="orderStatus" onchange="this.form.submit()">
                  	<option value="In-process" <%= order.getOrderstatus().equals("In-Process") ? "selected" : "" %>>In-process</option>
                    <option value="Ready" <%= order.getOrderstatus().equals("Ready") ? "selected" : "" %>>Ready</option>
                  </select>
                </form>
                </td>
                <td><%= order.getStudentID() %></td>
                <td><form method="post" action="AdminOrderController?action=updateadmin">
                  <input type="hidden" name="orderID" value="<%= order.getOrderID() %>" />
                  <select name="adminID" onchange="this.form.submit()">
                  <option value="Null">Choose Admin</option>
                  <c:forEach var="admin" items="${adminList}">
					<option value="${admin.ADMINID}">${admin.ADFNAME} ${admin.ADLNAME}</option>
				  </c:forEach>
				  </select>
                </form></td>
                <td><%= order.getAdminID() %></td>
            </tr>
        <% } %>
        
        
    </table>
        </section>
    </main>
    </div>