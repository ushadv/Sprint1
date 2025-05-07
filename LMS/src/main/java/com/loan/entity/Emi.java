package com.loan.entity;

//JPA annotations and persistence-related imports
import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Emi_Details")
public class Emi {
	
	// Primary key of the table: Loan_Id
	@Id
	
	@Column(name="Loan_Id",length=10)// Maps this field to 'Loan_Id' column in the table
	private String Loan_Id;
	
	@Column(name="Emi_Amount",length=20)// Maps this field to 'Emi_Amount' column in the table
	private String Emi_Amount;

	/*@ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "loan_id")
    private Loan loan;*/

	

	// Default constructor
	public Emi() {
		super();
	}

	
	// Parameterized constructor to quickly create an EMI object
	public Emi(String loan_Id, String emi_Amount) {
		super();
		Loan_Id = loan_Id;
		Emi_Amount = emi_Amount;
	}

	
	// Getter and setter methods
	public String getLoan_Id() {
		return Loan_Id;
	}

	public void setLoan_Id(String loan_Id) {
		Loan_Id = loan_Id;
	}

	public String getEmi_Amount() {
		return Emi_Amount;
	}

	public void setEmi_Amount(String emi_Amount) {
		Emi_Amount = emi_Amount;
	}

	
	 // toString method
	@Override
	public String toString() {
		return "Emi [Loan_Id=" + Loan_Id + ", Emi_Amount=" + Emi_Amount + "]";
	}
	
	
	
	
	
	
	
}