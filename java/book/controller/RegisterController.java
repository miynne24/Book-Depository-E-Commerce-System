package book.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import book.dao.BookDAO;
import book.dao.StudentDAO;
import book.model.NonResidentStudent;
import book.model.ResidentStudent;
import book.model.Student;

/**
 * Servlet implementation class RegisterController
 */
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private String action="", forward="";
	 private static String LIST ="studLogin.jsp";
	  private static String VIEW ="viewBooking.jsp";
	private static StudentDAO dao;   
	private RequestDispatcher view;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        dao=new StudentDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		view = request.getRequestDispatcher("Register.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String studentType = request.getParameter("stype");

		
		 if (studentType.equals("resident")) {
		//retrieve input and set
			 
			 ResidentStudent residentStudent = new ResidentStudent();
	            // Set attributes specific to resident students
	            residentStudent.setRoom(request.getParameter("room"));
	            residentStudent.setBlock(request.getParameter("block"));

	            // Set common attributes
	            residentStudent.setStudentID(Integer.parseInt(request.getParameter("studentID")));
	            residentStudent.setSfname(request.getParameter("sfname"));
	            residentStudent.setSlname(request.getParameter("slname"));
	            residentStudent.setSgroup(request.getParameter("sgroup"));
	            residentStudent.setScoursecode(request.getParameter("scoursecode"));
	            residentStudent.setSfaculty(request.getParameter("sfaculty"));
	            residentStudent.setScontact(request.getParameter("scontact"));
	            residentStudent.setSgender(request.getParameter("sgender"));
	            residentStudent.setSpassword(request.getParameter("spassword"));
	            residentStudent.setStype(studentType);

	            // Invoke method to add resident student
	            try {
					dao.addResidentStudent(residentStudent);
					//set attribute to a servlet request and call 
					request.setAttribute("books",BookDAO.getAllBook());
					
					forward=LIST;
					//forward the request to studLogin.jsp
					RequestDispatcher view=request.getRequestDispatcher("studReg-success.jsp");
					view.forward(request, response);
	            }catch (RuntimeException e) {
		              // If an exception occurred during the database operation,
		              // redirect to the error page
		              response.sendRedirect("studReg-fail.jsp");	
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
		 else if (studentType.equals("nonresident")) {
	            NonResidentStudent nonResidentStudent = new NonResidentStudent();
	            // Set attributes specific to non-resident students
	            nonResidentStudent.setAddress(request.getParameter("address"));
	            nonResidentStudent.setPostcode(request.getParameter("postcode"));

	            // Set common attributes
	            nonResidentStudent.setStudentID(Integer.parseInt(request.getParameter("studentID")));
	            nonResidentStudent.setSfname(request.getParameter("sfname"));
	            nonResidentStudent.setSlname(request.getParameter("slname"));
	            nonResidentStudent.setSgroup(request.getParameter("sgroup"));
	            nonResidentStudent.setScoursecode(request.getParameter("scoursecode"));
	            nonResidentStudent.setSfaculty(request.getParameter("sfaculty"));
	            nonResidentStudent.setScontact(request.getParameter("scontact"));
	            nonResidentStudent.setSgender(request.getParameter("sgender"));
	            nonResidentStudent.setSpassword(request.getParameter("spassword"));
	            nonResidentStudent.setStype(studentType);


	            // Invoke method to add non-resident student
	            try {
					dao.addNonResidentStudent(nonResidentStudent);
					//set attribute to a servlet request and call 
					request.setAttribute("books",BookDAO.getAllBook());
					
					forward=LIST;
					//forward the request to studLogin.jsp
					RequestDispatcher view=request.getRequestDispatcher("studReg-success.jsp");
					view.forward(request, response);
					
	            }catch (RuntimeException e) {
		              // If an exception occurred during the database operation,
		              // redirect to the error page
		              response.sendRedirect("studReg-fail.jsp");	
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
		
	
		
	}
}

