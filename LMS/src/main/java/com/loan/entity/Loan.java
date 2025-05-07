package com.loan.entity;

//Importing necessary Java and JPA (Java Persistence API) packages
import java.util.List;


import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


//This class is marked as a JPA entity, meaning it maps to a database table
@Entity

//Specifies the database table name that this entity maps to
@Table(name = "Loan_Details")
public class Loan {
	
	// Marks Loan_Id as the primary key of the table
	@Id
	
	@Column(name="Loan_Id",length=10)// Maps to column 'Loan_Id' in the database, with a max length of 10
	private String Loan_Id;
	
	@Column(name="Loan_Type",length=20)// Loan type (e.g., Home Loan, Car Loan)
	private String Loan_Type;
	
	@Column(name="Interest_Rate",length=20)// Interest rate for the loan
	private float Interest_Rate ;
	
	@Column(name="Loan_Amount",length=20)// Amount for the loan
	private int Loan_Amount ;
	
	@Column(name="Repayment_Year",length=20)// Years to repay the loan
	private int Repayment_Year ;
	
	
	/*@ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "DepartmentID")
    private Department department;

    @OneToMany(mappedBy = "loan")
    private List<Emi> emis;*/
	
	/*@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CustomerID")
	private Customer customer;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Branch_Id")
	private Branch branch;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DepartmentID")
	private Department department;*/

	// Default constructor
	public Loan() {
		super();
	}

	// Parameterized constructor to create a loan object with initial values
	public Loan(String loan_Id, String loan_Type, float interest_Rate, int loan_Amount, int repayment_Year) {
		super();
		Loan_Id = loan_Id;
		Loan_Type = loan_Type;
		Interest_Rate = interest_Rate;
		Loan_Amount = loan_Amount;
		Repayment_Year = repayment_Year;
	}

	
	// Getters and setters for each field
	public String getLoan_Id() {
		return Loan_Id;
	}

	public void setLoan_Id(String loan_Id) {
		Loan_Id = loan_Id;
	}

	public String getLoan_Type() {
		return Loan_Type;
	}

	public void setLoan_Type(String loan_Type) {
		Loan_Type = loan_Type;
	}

	public float getInterest_Rate() {
		return Interest_Rate;
	}

	public void setInterest_Rate(float interest_Rate) {
		Interest_Rate = interest_Rate;
	}

	public int getLoan_Amount() {
		return Loan_Amount;
	}

	public void setLoan_Amount(int loan_Amount) {
		Loan_Amount = loan_Amount;
	}

	public int getRepayment_Year() {
		return Repayment_Year;
	}

	public void setRepayment_Year(int repayment_Year) {
		Repayment_Year = repayment_Year;
	}
	
	
	// toString() method for logging/debugging purposess
	@Override
	public String toString() {
	    return "Loan [Loan_Id=" + Loan_Id + ", Loan_Type=" + Loan_Type + ", Interest_Rate=" + Interest_Rate
	            + ", Loan_Amount=" + Loan_Amount + ", Repayment_Year=" + Repayment_Year+"]";
	}

	
	
	
	
	
	
}