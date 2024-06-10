package book.controller;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.List;
import book.model.Book;
import book.dao.BookDAO;

public class BookController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String action = "create",forward="";
    private RequestDispatcher view;
    private static String LIST = "listBookAdmin.jsp";
    private static String VIEW="BookDetail.jsp";
    private static String LISTSD="listBookStud.jsp";
    private static String BOOKDETAIL="BookDetail.jsp";
    private static String BOOKUPDATE="UpdateBook.jsp";
    private static String BOOKREPORT ="ReportAnalysis.jsp";
   
    private BookDAO dao;
    private int bookID;
   

    public BookController() {
        super();
        dao = new BookDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
          action = request.getParameter("action");

          if(action.equalsIgnoreCase("viewBook")) {
            forward = VIEW;
            //get orderId from the request
            
            bookID = Integer.parseInt(request.getParameter("bookID"));
            
            //set attribute to a servlet request and call getCustomerBooking() in BookingDAO
            
             request.setAttribute("books", BookDAO.getBookDetails(bookID));
            
          }
          
          if(action.equalsIgnoreCase("list")) {
            forward = LIST;
            //set attribute to a servlet request and call getCustomerBookings() in BookingDAO
             request.setAttribute("books", BookDAO.getAllBook());
          }
          
          if(action.equalsIgnoreCase("listStud")) {
        	  forward = LISTSD;
              //set attribute to a servlet request and call getCustomerBookings() in BookingDAO
               request.setAttribute("books", BookDAO.getAllBook());
          }

          if(action.equalsIgnoreCase("delete")) {
            forward = LIST;
            //get bookingId from the request
             bookID = Integer.parseInt(request.getParameter("bookID"));
            //invoke deleteBooking() method in BookingDAO
            dao.deleteBook(bookID);          
            //set attribute to a servlet request and call getCustomerBookings() in BookingDAO
            request.setAttribute("books", BookDAO.getAllBook());
          }
          
          if (action.equalsIgnoreCase("bookdetail")) {
        	  
        	  forward = BOOKDETAIL;
        	  bookID = Integer.parseInt(request.getParameter("bookID"));
        	  
        	  request.setAttribute("books", BookDAO.getBookDetails(bookID));
          }
          
          if (action.equalsIgnoreCase("updateBook")) {
        	  forward=BOOKUPDATE;
        	  int bookID = Integer.parseInt(request.getParameter("bookID"));
        	  request.setAttribute("books", BookDAO.getBookDetails(bookID));
           	  
         	}
          
          if(action.equalsIgnoreCase("searchadmin")) {
        	  
        	  forward=LIST;
        	  String btitle = request.getParameter("btitle");
        	  request.setAttribute("books", BookDAO.getBookSearch(btitle));
          }
          
          if(action.equalsIgnoreCase("searchstudent")) {
        	  
        	  forward=LISTSD;
        	  String btitle = request.getParameter("btitle");
        	  request.setAttribute("books", BookDAO.getBookSearch(btitle));
          }
          
		if(action.equalsIgnoreCase("report")) { 
		        
		        forward = BOOKREPORT; 
		            // Set the chart data as a request attribute 
		            request.setAttribute("chartList", BookDAO.getReport()); 
		            request.setAttribute("stChart", BookDAO.getStReport()); 
		            request.setAttribute("aChart", BookDAO.getAReport()); 
		            request.setAttribute("oChart", BookDAO.getOReport());
		   
		             
		      }
          //forward the request
          RequestDispatcher view = request.getRequestDispatcher(forward);
          view.forward(request, response);
        }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	action = request.getParameter("action");
    	
    	Book booking = new Book();
        // Retrieve form data and set the values

        booking.setTitle(request.getParameter("btitle"));
        booking.setAuthor(request.getParameter("bauthor"));
        booking.setGenre(request.getParameter("bgenre"));
        booking.setCourseCode(request.getParameter("bcoursecode"));
        booking.setPrice(Double.parseDouble(request.getParameter("bprice")));
        booking.setCondition(request.getParameter("bcondition"));
        booking.setDistributor(request.getParameter("bdistributor"));
        booking.setAdminID(Integer.parseInt(request.getParameter("adminID")));

        String bookid = request.getParameter("bookID");
	    
        if(bookid ==null || bookid.isEmpty()) {
  	      dao.addBook(booking);
  	      request.setAttribute("books", BookDAO.getAllBook());
  	      view = request.getRequestDispatcher("createBook-success.jsp");
  	        view.forward(request, response);
  	  }
  	  else {
  	    booking.setBookID(Integer.parseInt(bookid));
  	    dao.updateBook(booking);
  	    request.setAttribute("books", BookDAO.getAllBook());
  	    view = request.getRequestDispatcher("UpdateBook-success.jsp");
  	      view.forward(request, response);

  	  }
    	
    
      
    }
    	
    
    		
    	
    
    
}