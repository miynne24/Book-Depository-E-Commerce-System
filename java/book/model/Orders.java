package book.model;

import java.util.List;

public class Orders extends Book{
	private int orderID;
	private String orderdate;
	private String orderstatus;
	private int studentID;
	private int adminID;
	private List<Orderdetails> orderDetails;
	
	public Orders() {
		orderstatus="In-process";
	}
	
	public Orders(int orderID, String orderdate,String orderstatus, int studentID, int adminID) {
		super();
		this.orderID = orderID;
		this.orderdate = orderdate;
		this.orderstatus = orderstatus;
		this.adminID = adminID;
	}

	public Orders(int studentID, String orderdate, String orderstatus) {
		super();
		this.studentID = studentID;
		this.orderdate = orderdate;
		this.orderstatus = orderstatus;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public String getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	
	public List<Orderdetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<Orderdetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

	
}
