package book.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import book.dao.OrderDAO;
import book.dao.OrderdetailsDAO;
import book.model.Book;
import book.model.Orderdetails;
import book.model.Orders;

/**
 * Servlet implementation class OrderdetailsController
 */
public class OrderdetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String action = "create",forward="";
    private RequestDispatcher view;
    private OrderdetailsDAO dao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderdetailsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try{
			int orderID = Integer.parseInt(request.getParameter("orderID"));
		
         OrderDAO orderDAO = new OrderDAO();
         List<Orders> orders = orderDAO.getOrdersByOrderID(orderID);

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
         request.getRequestDispatcher("Orderdetailspage.jsp").forward(request, response);
     } catch (Exception e) {
         e.printStackTrace();
         response.sendRedirect("error.jsp");
     }
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
		
	}

}
