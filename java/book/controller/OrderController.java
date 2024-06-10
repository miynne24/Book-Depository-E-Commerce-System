package book.controller;

import java.io.IOException;
import java.util.List;



import book.dao.OrderDAO;
import book.dao.OrderdetailsDAO;
import book.model.Orders;
import book.model.Orderdetails;
import book.model.Book;
import book.model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class OrderController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Get studentID from the session
            Student auth = (Student) request.getSession().getAttribute("auth");
            if (auth == null) {
                // If the student is not logged in, redirect to the login page or display an error
                response.sendRedirect("studLogin.jsp");
                return;
            }

            int studentID = auth.getStudentID();
            OrderDAO orderDAO = new OrderDAO();
            List<Orders> orders = orderDAO.getOrdersByStudentID(studentID);

            // Get order details and books for each order
            OrderdetailsDAO orderdetailsDAO = new OrderdetailsDAO();
            for (Orders order : orders) {
                List<Orderdetails> orderDetailsList = orderdetailsDAO.getOrderDetailsByOrderID(order.getOrderID());
                order.setOrderDetails(orderDetailsList);

                for (Orderdetails orderdetails : orderDetailsList) {
                    Book book = new Book(); // Replace this with your code to fetch book details based on bookID
                    book.setBookID(orderdetails.getBookID());
                    orderdetails.setBook(book);
                }
            }

            // Set the orders as an attribute and forward to the JSP page
            request.setAttribute("orders", orders);
            request.getRequestDispatcher("listOrderStud.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
