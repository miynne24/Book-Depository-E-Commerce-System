package book.controller;

import book.model.*;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Servlet implementation class AddtoCartController
 */
public class AddtoCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF=8");
		
		try(PrintWriter out = response.getWriter()){
			
			ArrayList<Cart> cartList = new ArrayList<>();
			
			int bookID = Integer.parseInt(request.getParameter("bookID"));
			
			Cart cm = new Cart();
			
			cm.setBookID(bookID);
			cm.setQuantity(1);
			
			HttpSession session = request.getSession();
			ArrayList<Cart> cart_list =(ArrayList<Cart>) session.getAttribute("cart-list");
			
			if(cart_list == null) {
				cartList.add(cm);
				session.setAttribute("cart-list", cartList);
				response.sendRedirect("studentCart.jsp");
				
			}
			
			else {
				cartList = cart_list;
				boolean exist = false;
				
			
			
			for(Cart c:cartList) {
				if(c.getBookID()==bookID) {
					exist=true;
					out.print("<h3 style='color:red; text-align:center;'>Item already exists <a href='BookController?action=listStud'>Go back</a></h3>");

				}
			}
			if(!exist) {
				cartList.add(cm);
				response.sendRedirect("studentCart.jsp");
			}
		}
				
	}

	
	


	}
}