package com.loan.entity;


import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Customer_Details")

//This class represents the Customer entity and maps to the "Customer_Details" table in the database.
public class Customer {
	
	// Primary key for the Customer table
	@Id
	@Column(name="CustomerID",length=10)
	private String CustomerID;
	
	@Column(name="Customer_Name",length=20)// Customer's name with max length 20
	private String Customer_Name;
	
	@Column(name="Customer_ac_no",length=20)// Customer's account number
	private int Customer_ac_no ;
	
	@Column(name="Customer_Address",length=20)// Customer's address with max length 20
	private String Customer_Address ;
	
	
	/* @ManyToOne
	    @JoinColumn(name = "emp_id")
	    private Employee employee;

	    @OneToMany(mappedBy = "customer")
	    private List<Loan> loans;

	    @OneToMany(mappedBy = "customer")
	    private List<Emi> emis;*/

    
	// Default constructor
	public Customer() {
		super();
	}

	// Parameterized constructor to initialize all fields
	public Customer(String customerID, String customer_Name, int customer_ac_no, String customer_Address) {
		super();
		CustomerID = customerID;
		Customer_Name = customer_Name;
		Customer_ac_no = customer_ac_no;
		Customer_Address = customer_Address;
	}

	
	 // Getter and Setter methods
	public String getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}

	public String getCustomer_Name() {
		return Customer_Name;
	}

	public void setCustomer_Name(String customer_Name) {
		Customer_Name = customer_Name;
	}

	public int getCustomer_ac_no() {
		return Customer_ac_no;
	}

	public void setCustomer_ac_no(int customer_ac_no) {
		Customer_ac_no = customer_ac_no;
	}

	public String getCustomer_Address() {
		return Customer_Address;
	}

	public void setCustomer_Address(String customer_Address) {
		Customer_Address = customer_Address;
	}

	
	// toString method for displaying customer details
	@Override
	public String toString() {
		return "Customer [CustomerID=" + CustomerID + ", Customer_Name=" + Customer_Name + ", Customer_ac_no="
				+ Customer_ac_no + ", Customer_Address=" + Customer_Address + "]";
	}

 

}