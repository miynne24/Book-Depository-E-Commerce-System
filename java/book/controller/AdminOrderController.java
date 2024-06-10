package book.controller;

import book.dao.AdminOrderDAO;
import book.model.Orderdetails;
import book.model.Orders;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;

import java.util.List;




public class AdminOrderController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equals("updateOrderStatus")) {
            int orderID = Integer.parseInt(request.getParameter("orderID"));
            String orderStatus = request.getParameter("orderStatus");

            AdminOrderDAO adminOrderDAO = new AdminOrderDAO();
            adminOrderDAO.updateOrderStatus(orderID, orderStatus);
        }
        if(action.equals("updateadmin")) {
        	  int orderID = Integer.parseInt(request.getParameter("orderID"));
              int adminID = Integer.parseInt(request.getParameter("adminID"));

              AdminOrderDAO adminOrderDAO = new AdminOrderDAO();
              adminOrderDAO.updateadminID(orderID, adminID);
        }

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Orders> orders = AdminOrderDAO.getAllOrders();
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("listOrderAdmin.jsp").forward(request, response);
    }
}
