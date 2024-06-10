package book.controller;

import book.model.*;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;


public class RemoveFromCartController extends HttpServlet {
	   
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookID = Integer.parseInt(request.getParameter("BookID"));

        // Get the cart list from the session
        HttpSession session = request.getSession();
        ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cart-list");

        // Find the item with the matching bookID and remove it from the cart list
        if (cartList != null) {
            Iterator<Cart> iterator = cartList.iterator();
            while (iterator.hasNext()) {
                Cart cartItem = iterator.next();
                if (cartItem.getBookID() == bookID) {
                    iterator.remove();
                    break; // Stop the loop after finding and removing the item
                }
            }
        }

        // Update the cart list in the session
        session.setAttribute("cart-list", cartList);

        // Redirect back to the cart view page
        response.sendRedirect("studentCart.jsp");
    }
}
