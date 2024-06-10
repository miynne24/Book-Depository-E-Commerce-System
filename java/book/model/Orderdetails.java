package book.model;

import java.util.List;

public class Orderdetails extends Book{
	private int orderID;
	private int BookID;
	private int quantity;
	private List<Orderdetails> orderDetails;
	
	public Orderdetails() {}
	
	
	
	public Orderdetails(int orderID, int bookID, int quantity) {
		super();
		this.orderID = orderID;
		BookID = bookID;
		this.quantity = quantity;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getBookID() {
		return BookID;
	}

	public void setBookID(int bookID) {
		BookID = bookID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getTitle(String title) {
		return super.getTitle();
	}
	public List<Orderdetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<Orderdetails> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
