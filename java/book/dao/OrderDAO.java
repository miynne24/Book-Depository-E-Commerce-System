package book.dao;

import book.connection.ConnectionManager;
import book.model.Book;
import book.model.Orderdetails;
import book.model.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    private static Connection con = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private static String sql;
    int orderID;
	int bookID;

    public int insertOrder(Orders model) {
        int generatedOrderId = -1;
        try {
            con = ConnectionManager.getConnection();

            sql = "INSERT INTO orders (studentID, orderstatus, orderdate) VALUES (?, ?, ?)";
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, model.getStudentID());
            ps.setString(2, model.getOrderstatus());
            ps.setString(3, model.getOrderdate());

            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    generatedOrderId = generatedKeys.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return generatedOrderId;
    }
    
    public List<Orders> getOrdersByStudentID(int studentID) {
        List<Orders> orderList = new ArrayList<>();

        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM orders WHERE studentID = ?");
        ) {
            ps.setInt(1, studentID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Orders order = new Orders();
                    order.setOrderID(rs.getInt("orderID"));
                    order.setStudentID(rs.getInt("studentID"));
                    order.setOrderstatus(rs.getString("orderstatus"));
                    orderList.add(order);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return orderList;
    }
    public List<Orders> getOrdersByOrderID(int orderID) {
        List<Orders> orderList = new ArrayList<>();

        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM orders WHERE orderID = ?");
        ) {
            ps.setInt(1, orderID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Orders order = new Orders();
                    order.setOrderID(rs.getInt("orderID"));
                    order.setStudentID(rs.getInt("studentID"));
                    order.setOrderstatus(rs.getString("orderstatus"));
                    orderList.add(order);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return orderList;
    }
}

