package book.dao;

import book.connection.ConnectionManager;
import book.model.Book;
import book.model.Orderdetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderdetailsDAO {
    private static Connection con = null;
    private static PreparedStatement ps = null;
    private static String sql;

    public boolean insertOrderdetails(int orderId, int bookId, int quantity) {
        boolean result = false;
        try {
            con = ConnectionManager.getConnection();

            sql = "INSERT INTO orderdetails (orderID, bookID, quantity) VALUES (?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, orderId);
            ps.setInt(2, bookId);
            ps.setInt(3, quantity);

            ps.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public List<Orderdetails> getOrderDetailsByOrderID(int orderID) {
        List<Orderdetails> orderDetailsList = new ArrayList<>();

        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM orderdetails WHERE orderID = ?");
        ) {
            ps.setInt(1, orderID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Orderdetails orderdetails = new Orderdetails();
                    Book b = BookDAO.getBookDetails(rs.getInt("bookID"));
                    orderdetails.setOrderID(rs.getInt("orderID"));
                    orderdetails.setBookID(rs.getInt("bookID"));
                    orderdetails.setQuantity(rs.getInt("quantity"));
                    orderdetails.setTitle(b.getTitle());
                    orderDetailsList.add(orderdetails);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return orderDetailsList;
    }
    public static  List<Orderdetails> getOrderDetails() {
        List<Orderdetails> orderDetailsList = new ArrayList<>();

        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM orderdetails");
        ) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Orderdetails orderdetails = new Orderdetails();
                    Book b = BookDAO.getBookDetails(rs.getInt("bookID"));
                    orderdetails.setOrderID(rs.getInt("orderID"));
                    orderdetails.setBookID(rs.getInt("bookID"));
                    orderdetails.setQuantity(rs.getInt("quantity"));
                    orderdetails.setTitle(b.getTitle());
                    orderDetailsList.add(orderdetails);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return orderDetailsList;
    }
}
