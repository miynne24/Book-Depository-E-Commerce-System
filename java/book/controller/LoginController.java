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
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static StudentDAO dao;	
	private HttpSession session;
	private RequestDispatcher view;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        dao=new StudentDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Student student=new Student();
			
			//retrieve and set student id and password
			student.setStudentID(Integer.parseInt(request.getParameter("studentID")));
			student.setSpassword(request.getParameter("spassword"));
		
			student=StudentDAO.login(student);
		
			//set user session if user is valid
				if(student.isValid()) {
					session=request.getSession(true);
					session.setAttribute("auth", student);
					session.setAttribute("sessionStudentID", student.getStudentID());
					session.setAttribute("sessionStype", student.getStype());
					session.setAttribute("sessionStudentFName",student.getSfname());
					
					
						request.setAttribute("students", StudentDAO.getAllStudent());
						view=request.getRequestDispatcher("Student.jsp");
						view.forward(request,response);
					
				}
				else if(student.isValid()==false){
				response.sendRedirect("invalidStud.jsp");
				}	
				
	
		}
		catch(Throwable ex) {
			ex.printStackTrace();
		}
	}

}
