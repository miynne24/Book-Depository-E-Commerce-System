package book.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import book.dao.AdminDAO;
import book.dao.StudentDAO;
import book.dao.StudentDAO;
import book.model.Admin;
import book.model.Student;

import java.io.IOException;

import org.apache.catalina.User;

/**
 * Servlet implementation class LoginController
 */
public class LoginAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static AdminDAO dao;	
	private HttpSession session;
	private RequestDispatcher view;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAdminController() {
        super();
        dao=new AdminDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Admin admin=new Admin();
			
			//retrieve and set student id and password
			admin.setADMINID(Integer.parseInt(request.getParameter("ADMINID")));
			admin.setADPASSWORD(request.getParameter("ADPASSWORD"));
		
			admin=AdminDAO.login(admin);
		
			//set user session if user is valid
				if(admin.isValid()) {
					session=request.getSession(true);
					session.setAttribute("sessionADMINID", admin.getADMINID());
					session.setAttribute("sessionADFNAME",admin.getADFNAME());
					request.setAttribute("admins", AdminDAO.getAllAdmins());

					view=request.getRequestDispatcher("Admin.jsp");
				
					view.forward(request,response);
				}
				else if(admin.isValid()==false){
					response.sendRedirect("invalidAdmin.jsp");
				}	
	
		}
		catch(Throwable ex) {
			ex.printStackTrace();
		}
	}

}
