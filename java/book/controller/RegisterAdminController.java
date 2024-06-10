package book.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import book.dao.AdminDAO;
import book.dao.BookDAO;
import book.dao.StudentDAO;
import book.model.Admin;

/**
 * Servlet implementation class RegisterAdminController
 */
public class RegisterAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private String action="", forward="";
	 private static String LIST ="Admin.jsp";
	  private static String VIEW ="";
	  private static String PROFILE="ProfileAdmin.jsp";
	private static AdminDAO dao;  
	private int ADMINID;
	private RequestDispatcher view;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterAdminController() {
        super();
        dao=new AdminDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		action=request.getParameter("action");
		if (action.equalsIgnoreCase("admindetail")) {
            forward = PROFILE;
            ADMINID = Integer.parseInt(request.getParameter("ADMINID"));
            request.setAttribute("admin", AdminDAO.getadminByADMINID(ADMINID));
          }  
		view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			Admin ad=new Admin();
	 
			ad.setADMINID(Integer.parseInt(request.getParameter("adminID")));
			ad.setADFNAME(request.getParameter("adfname"));
			ad.setADLNAME(request.getParameter("adlname"));
			ad.setADCONTACT(request.getParameter("adcontact"));
			ad.setADGENDER(request.getParameter("adgender"));
			ad.setADPASSWORD(request.getParameter("adpassword"));
			
			try {
	            dao.addAdmin(ad);
	            request.setAttribute("successMessage", "New Admin inserted successfully.");
	            forward = LIST;
	            view = request.getRequestDispatcher("adminReg-success.jsp");
	            view.forward(request, response);
	        }catch (RuntimeException e) {
	              // If an exception occurred during the database operation,
	              // redirect to the error page
	              response.sendRedirect("adminReg-fail.jsp");
	          } catch (NoSuchAlgorithmException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	      }

		
	}

}
