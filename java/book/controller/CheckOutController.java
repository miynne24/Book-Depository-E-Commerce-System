package book.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import book.dao.OrderDAO;
import book.dao.OrderdetailsDAO;
import book.model.Cart;
import book.model.Orders;
import book.model.Student;

@WebServlet("/checkout")
public class CheckOutController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CheckOutController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            ArrayList<Cart> cartList = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
            Student auth = (Student) request.getSession().getAttribute("auth");
            if (cartList != null && auth != null) {
                // Insert the order into the "order" table
                Orders order = new Orders();
                order.setStudentID(auth.getStudentID());
                order.setOrderstatus("In-process");
                order.setOrderdate(formatter.format(date));
                OrderDAO orderDAO = new OrderDAO();
                int orderId = orderDAO.insertOrder(order);

                if (orderId != -1) {
                    // Insert order details into the "orderdetails" table
                    OrderdetailsDAO orderdetailsDAO = new OrderdetailsDAO();
                    for (Cart cart : cartList) {
                        orderdetailsDAO.insertOrderdetails(orderId, cart.getBookID(), cart.getQuantity());
                    }

                    cartList.clear();
                    response.sendRedirect("listOrderStud.jsp");
                } else {
                    out.println("Failed to insert order. Please try again.");
                }
            } else {
                if (auth == null) {
                    response.sendRedirect("studLogin.jsp");
                } else {
                    response.sendRedirect("studentCart.jsp");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
