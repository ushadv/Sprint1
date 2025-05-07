package com.loan.entity;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "Employee_Details")
public class Employee {
	
	// Primary key of the Employee table
	@Id
	
	@Column(name="Emp_Id",length=10)
	private String Emp_Id;
	
	@Column(name="Emp_Name",length=20)// Column for employee name with max length 20
	private String Emp_Name;
	
	@Column(name="Emp_Address",length=20)// Column for employee address with max length 20
	private String Emp_Address ;
	
	@Column(name="Emp_Cont_no",length=20)// Column for employee contact number
	private long Emp_Cont_no ;
	
	
	
	@Column(name="Branch_Id",length=10)//insertable = false, updatable = false,
	private String Branch_Id;

	
	/*@ManyToOne
	@JoinColumn(name = "Branch_Id")
	private Branch branch;

    @OneToMany(mappedBy = "employee")
    private List<Customer> customers;*/
	

	// Default constructor
	public Employee() {
		super();
	}

	// Parameterized constructor to initialize all fields
	public Employee(String emp_Id, String emp_Name, String emp_Address, long emp_Cont_no2, String branch_Id) {
		super();
		Emp_Id = emp_Id;
		Emp_Name = emp_Name;
		Emp_Address = emp_Address;
		Emp_Cont_no = emp_Cont_no2;
		Branch_Id = branch_Id;
	}

	// Getter and Setter methods
	public String getEmp_Id() {
		return Emp_Id;
	}
	
	public void setEmp_Id(String emp_Id) {
		Emp_Id = emp_Id;
	}

	public String getEmp_Name() {
		return Emp_Name;
	}

	public void setEmp_Name(String emp_Name) {
		Emp_Name = emp_Name;
	}

	public String getEmp_Address() {
		return Emp_Address;
	}

	public void setEmp_Address(String emp_Address) {
		Emp_Address = emp_Address;
	}

	public long getEmp_Cont_no() {
		return Emp_Cont_no;
	}
	
	public void setEmp_Cont_no(long l) {
		Emp_Cont_no = l;
	}

	public String getBranch_Id() {
		return Branch_Id;
	}

	public void setBranch_Id(String branch_Id) {
		Branch_Id = branch_Id;
	}

	// toString() method to display Employee object information
	@Override
	public String toString() {
		return "Employee [Emp_Id=" + Emp_Id + ", Emp_Name=" + Emp_Name + ", Emp_Address=" + Emp_Address
				+ ", Emp_Cont_no=" + Emp_Cont_no + ", Branch_Id=" + Branch_Id + "]";
	}



	
	
	
	
}