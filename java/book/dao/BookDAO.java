package book.dao;

import java.sql.*;
import java.util.*;

import book.model.AdminHandleTotalBookChart;
import book.model.Book;
import book.model.BookTypeChart;
import book.model.Cart;
import book.model.StudentTypeChart;
import book.connection.*;
import book.model.AdminHandleTotalOrderChart;



public class BookDAO {
  private static Connection con = null;
  private static PreparedStatement ps = null;
  private static Statement stmt = null;
  private static ResultSet rs = null;
  private static String sql;
  private int bookID;
  private String btitle;
  private String bauthor;
  private String bgenre;
  private String bcoursecode;
  private double bprice;
  private String bcondition;
  private String bdistributor;
  private int adminID;

  //Get Book by id
  public static Book getBookDetails(int bookID) { 
    Book book = new Book();
    try {
      //call getConnection() method
      con = ConnectionManager.getConnection();

      //create statement
      ps = con.prepareStatement("SELECT * FROM books WHERE bookID=?");
      ps.setInt(1, bookID);
      
      //execute query
      rs = ps.executeQuery();
      if(rs.next()) {
      
        book.setBookID(rs.getInt("bookID"));
        book.setTitle(rs.getString("btitle"));
        book.setAuthor(rs.getString("bauthor"));
        book.setGenre(rs.getString("bgenre"));
        book.setCourseCode(rs.getString("bcoursecode"));
        book.setPrice(rs.getDouble("bprice"));
        book.setCondition(rs.getString("bcondition"));
        book.setDistributor(rs.getString("bdistributor"));
        book.setAdminID(rs.getInt("adminID"));
        
      }
      //close connection
      con.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return book; 
  }

//Complete addBook() method with exception handling
  public void addBook(Book bean) {
     // Get values
     bookID = bean.getBookID();
     btitle = bean.getTitle();
     bauthor = bean.getAuthor();
     bgenre = bean.getGenre();
     bcoursecode = bean.getCourseCode();
     bprice = bean.getPrice();
     bcondition = bean.getCondition();
     bdistributor = bean.getDistributor();
     adminID = bean.getAdminID();
    

     try {
         // Get database connection
         con = ConnectionManager.getConnection();

         // Create prepared statement
         ps = con.prepareStatement("INSERT INTO books(bookID,btitle,bauthor,bgenre,bcoursecode,bprice,bcondition,bdistributor,adminID)VALUES(?,?,?,?,?,?,?,?,?)");
         ps.setInt(1, bookID);
         ps.setString(2, btitle);
         ps.setString(3, bauthor);
         ps.setString(4, bgenre);
         ps.setString(5, bcoursecode);
         ps.setDouble(6, bprice);
         ps.setString(7, bcondition);
         ps.setString(8, bdistributor);
         ps.setInt(9, adminID);
         

         // Execute query
         ps.executeUpdate();
         System.out.println("Successfully inserted");

         // Close connection
         con.close();
     } catch (SQLException e) {
         e.printStackTrace();
         // Display the error message to the user or handle it as needed
         System.out.println("Error occurred while inserting the book gggggggggg: " + e.getMessage());
     } catch (Exception e) {
         e.printStackTrace();
         // Display the error message to the user or handle it as needed
         System.out.println("An unexpected error occurred: " + e.getMessage());
     }
  } 
  
  //Complete deleteBooking() method
  public void deleteBook(int bookID) {
    try {
      //call getConnection() method 
      con = ConnectionManager.getConnection();

      //create statement 
      ps = con.prepareStatement("DELETE FROM books WHERE bookID=?");
      ps.setInt(1, bookID);


      //execute query
      ps.executeUpdate();


      //close connection
      con.close();

    }catch(Exception e) {
      e.printStackTrace();
    }
  }

  //Complete getCustomerBookings() method
  public static List<Book> getAllBook() { 
    List<Book> books = new ArrayList<Book>(); 
    try { 
      //call getConnection() method
      con = ConnectionManager.getConnection();
    //create statement
      sql = "SELECT * FROM books b INNER JOIN admin a ON a.adminID=b.adminID";
      stmt = con.createStatement();
    //execute query
      rs = stmt.executeQuery(sql);
      
      while(rs.next()) {  
      Book b = new Book();
      b.setBookID(rs.getInt("bookID"));
      b.setTitle(rs.getString("btitle"));
      b.setAuthor(rs.getString("bauthor"));
      b.setGenre(rs.getString("bgenre"));
      b.setCourseCode(rs.getString("bcoursecode"));
      b.setPrice(rs.getDouble("bprice"));
      b.setCondition(rs.getString("bcondition"));
      b.setDistributor(rs.getString("bdistributor"));
      b.setAdminID(rs.getInt("adminID"));
      
      books.add(b);
      }
      //close connection
      con.close();
      
    } catch (Exception e) { 
      e.printStackTrace(); 
    }
    return books; 
  }
  
  
  public void updateBook(Book bean) {
      // Get values
      int bookID = bean.getBookID();
      String btitle = bean.getTitle();
      String bauthor = bean.getAuthor();
      String bgenre = bean.getGenre();
      String bcoursecode = bean.getCourseCode();
      double bprice = bean.getPrice();
      String bcondition = bean.getCondition();
      String bdistributor = bean.getDistributor();
      int adminID = bean.getAdminID();

      try {
          // Get database connection
          con = ConnectionManager.getConnection();

          // Create prepared statement
          ps = con.prepareStatement("UPDATE books SET btitle=?, bauthor=?, bgenre=?, bcoursecode=?, bprice=?, bcondition=?, bdistributor=?, adminID=? WHERE bookID=?");
          ps.setString(1, btitle);
          ps.setString(2, bauthor);
          ps.setString(3, bgenre);
          ps.setString(4, bcoursecode);
          ps.setDouble(5, bprice);
          ps.setString(6, bcondition);
          ps.setString(7, bdistributor);
          ps.setInt(8, adminID);
          ps.setInt(9, bookID); // Use the bookID as the condition for updating

          // Execute query
          int rowsAffected = ps.executeUpdate();
          if (rowsAffected > 0) {
              System.out.println("Successfully updated");
          } else {
              System.out.println("Book with ID " + bookID + " not found. No update performed.");
          }

          // Close connection
          con.close();
      } catch (SQLException e) {
          e.printStackTrace();
          System.out.println("Error occurred while updating the book: " + e.getMessage());
      } catch (Exception e) {
          e.printStackTrace();
          System.out.println("An unexpected error occurred: " + e.getMessage());
      }

  }
  
  public static List<Book> getBookSearch(String btitle) { 
	    List<Book> books = new ArrayList<Book>(); 
	    try { 
	        // Call getConnection() method
	        con = ConnectionManager.getConnection();

	        // Prepare the SQL query with a placeholder for the searchQuery
	        sql = "SELECT * FROM books b INNER JOIN admin a ON a.adminID=b.adminID WHERE btitle LIKE ?";

	        // Create a prepared statement with the SQL query
	        PreparedStatement pstmt = con.prepareStatement(sql);

	        // Set the searchQuery as a parameter in the prepared statement
	        pstmt.setString(1, "%" + btitle + "%"); // Use the LIKE operator to search for partial matches

	        // Execute the query
	        rs = pstmt.executeQuery();

	        while (rs.next()) {  
	            Book b = new Book();
	            b.setBookID(rs.getInt("bookID"));
	            b.setTitle(rs.getString("btitle"));
	            b.setAuthor(rs.getString("bauthor"));
	            b.setGenre(rs.getString("bgenre"));
	            b.setCourseCode(rs.getString("bcoursecode"));
	            b.setPrice(rs.getDouble("bprice"));
	            b.setCondition(rs.getString("bcondition"));
	            b.setDistributor(rs.getString("bdistributor"));
	            b.setAdminID(rs.getInt("adminID"));

	            books.add(b);
	        }

	        // Close the connection and prepared statement
	        pstmt.close();
	        con.close();
	    } catch (Exception e) { 
	        e.printStackTrace(); 
	    }
	    return books; 
}
  
  public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
	    List<Cart> books = new ArrayList<Cart>();
	    try {
	        con = ConnectionManager.getConnection();

	        if (cartList.size() > 0) {
	            for (Cart item : cartList) {
	                String query = "SELECT * FROM books WHERE bookID=?";
	                ps = con.prepareStatement(query);
	                ps.setInt(1, item.getBookID());
	                rs = ps.executeQuery();
	                while (rs.next()) {
	                    Cart row = new Cart();
	                    row.setBookID(rs.getInt("bookID"));
	                    row.setTitle(rs.getString("btitle")); 
	                    row.setGenre(rs.getString("bgenre"));
	                    row.setPrice(rs.getDouble("bprice") * item.getQuantity());
	                    row.setQuantity(item.getQuantity());

	                    books.add(row);
	                }
	            }
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (con != null) con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return books;
	}
  
  public double getTotalCartPrice(ArrayList<Cart> cartList) {
	  double sum=0;
	  
	  try {
		  con = ConnectionManager.getConnection();
		  
		  if(cartList.size()>0) {
			  for(Cart item:cartList) {
			  	String query="SELECT bprice FROM books WHERE bookID=?";
			  	ps =this.con.prepareStatement(query);
                ps.setInt(1, item.getBookID());
                rs = ps.executeQuery();
                
                while(rs.next()) {
                	sum+=rs.getDouble("bprice")*item.getQuantity();
                }
			  }
		  }
	  }
	  catch(Exception e){
		  e.printStackTrace();
	  }
	  return sum;
  }
  //CHARTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
  //CHARTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
  //CHARTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
  public static List<BookTypeChart> getReport(){ 
	   List<BookTypeChart> chartList = new ArrayList<BookTypeChart>(); 
	    
	   try {  
	          // Call getConnection() method 
	       Connection con = ConnectionManager.getConnection(); 
	 
	             // Prepare the SQL query with a placeholder for the searchQuery 
	             String sql = "SELECT bgenre, COUNT(*) FROM books GROUP BY bgenre"; 
	 
	             PreparedStatement pstmt = con.prepareStatement(sql); 
	 
	             ResultSet rs = pstmt.executeQuery(); 
	 
	             while (rs.next()) { 
	              BookTypeChart c = new BookTypeChart(); 
	                 c.setLabel(rs.getString("bgenre")) ; 
	                 c.setCount(rs.getInt(2)); 
	                 chartList.add(c); 
	             } 
	 
	             // Close the resources (rs, pstmt, con) 
	             rs.close(); 
	             pstmt.close(); 
	             con.close(); 
	         } catch (SQLException e) { 
	             e.printStackTrace(); 
	         } 
	 
	         return chartList; 
	  } 
	   
	  public static List<StudentTypeChart> getStReport(){ 
	   List<StudentTypeChart> stChart = new ArrayList<StudentTypeChart>(); 
	    
	   try {  
	          // Call getConnection() method 
	       Connection con = ConnectionManager.getConnection(); 
	 
	             // Prepare the SQL query with a placeholder for the searchQuery 
	             String sql = "SELECT stype, COUNT(*) FROM student GROUP BY stype"; 
	 
	             PreparedStatement pstmt = con.prepareStatement(sql); 
	 
	             ResultSet rs = pstmt.executeQuery(); 
	 
	             while (rs.next()) { 
	              StudentTypeChart s = new StudentTypeChart(); 
	                 s.setStLabel(rs.getString("stype")) ; 
	                 s.setStNum(rs.getInt(2)); 
	                 stChart.add(s); 
	             } 
	 
	             // Close the resources (rs, pstmt, con) 
	             rs.close(); 
	             pstmt.close(); 
	             con.close(); 
	         } catch (SQLException e) { 
	             e.printStackTrace(); 
	         } 
	 
	         return stChart; 
	  } 
	   
	  public static List<AdminHandleTotalBookChart> getAReport(){ 
	   List<AdminHandleTotalBookChart> aChart = new ArrayList<AdminHandleTotalBookChart>(); 
	    
	   try {  
	          // Call getConnection() method 
	       Connection con = ConnectionManager.getConnection(); 
	 
	             // Prepare the SQL query with a placeholder for the searchQuery 
	       String sql = "SELECT a.adfname, COUNT(*) FROM books b INNER JOIN admin a ON a.adminID = b.adminID GROUP BY a.adminID, a.adfname;"; 
	 
	 
	             PreparedStatement pstmt = con.prepareStatement(sql); 
	 
	             ResultSet rs = pstmt.executeQuery(); 
	 
	             while (rs.next()) { 
	              AdminHandleTotalBookChart a = new AdminHandleTotalBookChart(); 
	                 a.setaName(rs.getString("adfname")) ; 
	                 a.setaCount(rs.getInt(2)); 
	                 aChart.add(a); 
	             } 
	 
	             // Close the resources (rs, pstmt, con) 
	             rs.close(); 
	             pstmt.close(); 
	             con.close(); 
	         } catch (SQLException e) { 
	             e.printStackTrace(); 
	         } 
	 
	         return aChart; 
	  }
	  
	  public static List<AdminHandleTotalOrderChart> getOReport(){ 
		   List<AdminHandleTotalOrderChart> oChart = new ArrayList<AdminHandleTotalOrderChart>(); 
		    
		   try {  
		          // Call getConnection() method 
		       Connection con = ConnectionManager.getConnection(); 
		 
		             // Prepare the SQL query with a placeholder for the searchQuery 
		       String sql = "SELECT a.adfname, COUNT(*) FROM orders o INNER JOIN admin a ON a.adminID = o.adminID GROUP BY a.adminID, a.adfname;"; 
		 
		 
		             PreparedStatement pstmt = con.prepareStatement(sql); 
		 
		             ResultSet rs = pstmt.executeQuery(); 
		 
		             while (rs.next()) { 
		              AdminHandleTotalOrderChart o = new AdminHandleTotalOrderChart(); 
		                 o.setoName(rs.getString("adfname")) ; 
		                 o.setoCount(rs.getInt(2)); 
		                 oChart.add(o); 
		             } 
		 
		             // Close the resources (rs, pstmt, con) 
		             rs.close(); 
		             pstmt.close(); 
		             con.close(); 
		         } catch (SQLException e) { 
		             e.printStackTrace(); 
		         } 
		 
		         return oChart; 
		  }
	  
	  ///////////////////////////////////////CHART//////////////////////////////////////////////////////////////////////////////////////////
	  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}