package book.dao;


import java.security.*;
import java.sql.*;
import java.util.*;
import book.connection.ConnectionManager;
import book.model.Admin;
import book.model.Orders;

public class AdminOrderDAO {
	
	 public static List<Orders> getAllOrders() {
	        List<Orders> orders = new ArrayList<>();

	        Connection conn = null;
	        Statement stmt = null;
	        ResultSet rs = null;

	        try {
	

	            // Open a connection
	            conn = ConnectionManager.getConnection();

	            // Execute a query
	            stmt = conn.createStatement();
	            String sql = "SELECT * FROM orders";
	            rs = stmt.executeQuery(sql);

	            // Extract data from result set
	            while (rs.next()) {
	                // Create an Order object and populate its attributes
	                Orders order = new Orders();
	                order.setOrderID(rs.getInt("orderID"));
	                order.setOrderdate(rs.getString("orderdate"));
	                order.setOrderstatus(rs.getString("orderstatus"));
	                order.setStudentID(rs.getInt("studentID"));
	                order.setAdminID(rs.getInt("adminID"));

	                // Add the order to the list
	                orders.add(order);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // Close the resources
	            try {
	                if (rs != null)
	                    rs.close();
	                if (stmt != null)
	                    stmt.close();
	                if (conn != null)
	                    conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	        return orders;
	    }
	 
	 
	 public void updateOrderStatus(int orderID, String orderStatus) {
	        Connection conn = null;
	        PreparedStatement stmt = null;

	        try {
	            conn =ConnectionManager.getConnection();
	            String sql = "UPDATE orders SET orderstatus = ? WHERE orderID = ?";
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, orderStatus);
	            stmt.setInt(2, orderID);
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	      
	    }
	 public void updateadminID(int orderID, int adminID) {
	        Connection conn = null;
	        PreparedStatement stmt = null;

	        try {
	            conn =ConnectionManager.getConnection();
	            String sql = "UPDATE orders SET adminID = ? WHERE orderID = ?";
	            stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, adminID);
	            stmt.setInt(2, orderID);
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	      
	    }
}
