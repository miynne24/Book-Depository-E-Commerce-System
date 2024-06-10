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
public class UpdateStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private String action="", forward="";
	 private static String LIST ="studLogin.jsp";
	  private static String VIEW ="viewBooking.jsp";
	  private static String UPDATE="UpdateStudent.jsp";
	  private static String PROFILE="ProfileStudent.jsp";
	private static StudentDAO dao;
	private int studentID;
	private RequestDispatcher view;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentController() {
        super();
        dao=new StudentDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 action = request.getParameter("action"); // Assuming you have a parameter "action" in the URL
		  if (action.equalsIgnoreCase("studentdetail")) {
	            
	            forward = PROFILE;
	            studentID = Integer.parseInt(request.getParameter("studentID"));
	            request.setAttribute("student", StudentDAO.getStudentById(studentID));
	          }  
		  
		 if (action.equalsIgnoreCase("updateStudent")) {
		        forward = UPDATE;
		        int studentID = Integer.parseInt(request.getParameter("studentID"));
		        
		        request.setAttribute("student", StudentDAO.getStudentById(studentID));        
		 }
		 
		    view = request.getRequestDispatcher(forward);
		    view.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String stype = request.getParameter("stype");

	        // If stype is null, it means the session has expired or something went wrong
	        // You should handle this case accordingly (e.g., redirect to an error page)
	        if (stype == null) {
	            // Redirect to an error page or login page
	            response.sendRedirect("error.jsp");
	            return;
	        }
	        
		 if (stype.equals("resident")) {
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
	            residentStudent.setStype(request.getParameter("stype"));

	            // Invoke method to add resident student
	            try {
					dao.updateResidentStudent(residentStudent);
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
		 }
		 else if (stype.equals("nonresident")) {
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
	            nonResidentStudent.setStype(stype);

	            // Invoke method to add non-resident student
	            try {
					dao.updateNonResidentStudent(nonResidentStudent);
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
		
		//set attribute to a servlet request and call 
		request.setAttribute("students",StudentDAO.getAllStudent());
		
		forward="UpdateStudent-success.jsp";
		//forward the request to studLogin.jsp
		RequestDispatcher view=request.getRequestDispatcher(forward);
		view.forward(request, response);
		}
		
	}


