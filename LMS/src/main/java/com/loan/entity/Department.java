package com.loan.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
@Table(name="Department_Details")
public class Department{
	
	// This is the primary key column for the Department table
	@Id
	@Column(name="DepartmentID",length=10)
	private String DepartmentID;
	
	@Column(name="Department_Name",length=30) // Column to store department name with a max length of 30
	private String Department_Name;
	
	/*@OneToMany(mappedBy = "department")
    private List<Loan> loans;*/


	 // Default constructor 
	public Department() {
		super();
	}

	// Parameterized constructor to initialize department fields
	public Department(String departmentID, String department_Name) {
		super();
		DepartmentID = departmentID;
		Department_Name = department_Name;
	}

	
	// Getter and Setter methods
	public String getDepartmentID() {
		return DepartmentID;
	}

	public void setDepartmentID(String departmentID) {
		DepartmentID = departmentID;
	}

	public String getDepartment_Name() {
		return Department_Name;
	}

	public void setDepartment_Name(String department_Name) {
		Department_Name = department_Name;
	}

	
	// toString method to print Department details
	@Override
	public String toString() {
		return "Department [DepartmentID=" + DepartmentID + ", Department_Name=" + Department_Name + "]";
	}
	
	
}