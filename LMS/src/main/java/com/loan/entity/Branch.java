package com.loan.entity;






import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "Branch_Details")
public class Branch {
	
	// Primary key column for the Branch table
	@Id
	
	@Column(name="Branch_Id",length=10)
	private String Branch_Id;
	
	@Column(name="Branch_Name",length=20) // Column to store the name of the branch
	private String Branch_Name;
	
	@Column(name="Branch_Address",length=20)// Column to store the address of the branch
	private String Branch_Address ;

	/*@OneToMany(mappedBy = "branch")
    private List<Employee> employees;

    @OneToMany(mappedBy = "branch")
    private List<Loan> loans;*/
	
	// Default constructor
	public Branch() {
		super();
	}


	// Parameterized constructor to initialize the Branch object
	public Branch(String branch_Id, String branch_Name, String branch_Address) {
		super();
		Branch_Id = branch_Id;
		Branch_Name = branch_Name;
		Branch_Address = branch_Address;
	}


	// Getter and Setter methods
	public String getBranch_Id() {
		return Branch_Id;
	}



	public void setBranch_Id(String branch_Id) {
		Branch_Id = branch_Id;
	}



	public String getBranch_Name() {
		return Branch_Name;
	}



	public void setBranch_Name(String branch_Name) {
		Branch_Name = branch_Name;
	}



	public String getBranch_Address() {
		return Branch_Address;
	}



	public void setBranch_Address(String branch_Address) {
		Branch_Address = branch_Address;
	}


	// ToString method to print Branch details
	@Override
	public String toString() {
		return "Branch [Branch_Id=" + Branch_Id + ", Branch_Name=" + Branch_Name + ", Branch_Address=" + Branch_Address
				+ "]";
	}



	
	
	
	
}