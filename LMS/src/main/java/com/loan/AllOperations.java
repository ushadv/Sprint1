package com.loan;



import java.util.List;

import java.util.Scanner;
import com.loan.entity.Branch;
import com.loan.entity.Customer;
import com.loan.entity.Department;
import com.loan.entity.Emi;
import com.loan.entity.Employee;
import com.loan.entity.Loan;
import com.loan.exception.ResourceNotFoundException;
import com.loan.serviceimp.*;
import com.mysql.cj.Session;
import com.loan.service.*;

public class AllOperations {
	  static Branchservice branchService = new Branchserviceimp();
	  static Scanner sc=new Scanner(System.in);
	  public static Branch BranchInputs()
		{		
			sc.nextLine();
			System.out.println("Enter Branch_Id");
			String Branch_Id=sc.nextLine();

			System.out.println("Enter Branch_Name");
			String Branch_Name=sc.nextLine();
			
			
			System.out.println("Enter Branch_Address");
			String Branch_Address=sc.nextLine();
			
		
			return new Branch(Branch_Id, Branch_Name, Branch_Address);
							
			}
	  public static Branch updatedBranchData()
		{
		  	
				sc.nextLine();
				System.out.println("Enter Branch_Id");
				String Branch_Id=sc.nextLine();

				System.out.println("Enter Branch_Name");
				String Branch_Name=sc.nextLine();
				
				
				
				System.out.println("Enter Branch_Address");
				String Branch_Address=sc.nextLine();
				
			
				return new Branch(Branch_Id, Branch_Name, Branch_Address);
								
				}
	  public static void BranchOperations()
		{
			while(true) {
				System.out.println("Press 1.Add Branch Details\nPress 2.Retrieve All Branch Data\n"
						+ "Press 3.Update Branch Data\nPress 4.Delete Branch Data\n"
						+ "Press 5.To getback to the main menu\nEnter your choice: ");
				int input=sc.nextInt();	
				
				switch(input) {
				case 1:
					Branch user=BranchInputs();
					Branch savedEntity=branchService.createBranch(user);
					System.out.println("User Data has been saved successfully"+ savedEntity);
					break;
				
				case 2:
					List<Branch> users=branchService.getAllBranch();
					for(Branch user1:users)
					{
						System.out.println(user1);
					}
					break;
					
				case 3:sc.nextLine();
					System.out.println("Enter Branch Id to update the infromation");
				       String uId=sc.next();
				       Branch u=branchService.getBranch(uId);
				       if(u!=null) {
				    	   Branch us=updatedBranchData();
				     //service
				    	   Branch updatedInfo=branchService.updateBranch(uId, us);
				       System.out.println("Branch Data has been updated Successfully"+ updatedInfo);
				       }
				       
				       else
				       {
				    	   throw new ResourceNotFoundException("branch Id not found");
				       }
				       
					break;
				
				case 4:
					System.out.println("Enter branch Id to delete the infromation");
				       String id=sc.next();
				       String message=branchService.deleteBranch(id);
				       System.out.println(message);
					break;
				case 5:MainOperation.mainOps();
				}
				
				}
			}
	  
	  static Loanservice loanservice = new Loanserviceimp();
	  public static Loan LoanInputs()
		{		
			sc.nextLine();
			System.out.println("Enter Loan_Id");
			String Loan_Id=sc.nextLine();

			System.out.println("Enter Loan_Type");
			String Loan_Type=sc.nextLine();
			
			System.out.println("Enter Interest_Rate");
			float Interest_Rate=sc.nextFloat();
			
			System.out.println("Enter Loan_Amount");
			int Loan_Amount=sc.nextInt();
			
			System.out.println("Enter Repayment_Year");
			int Repayment_Year=sc.nextInt();
			
		
			return new Loan(Loan_Id,Loan_Type , Interest_Rate,Loan_Amount,Repayment_Year);
							
			}
	  public static Loan updatedLoanData()
		{
		  	
		  sc.nextLine();
			System.out.println("Enter Loan_Id");
			String Loan_Id=sc.nextLine();

			System.out.println("Enter Loan_Type");
			String Loan_Type=sc.nextLine();
			
			System.out.println("Enter Interest_Rate");
			float Interest_Rate=sc.nextFloat();
			
			System.out.println("Enter Loan_Amount");
			int Loan_Amount=sc.nextInt();
			
			System.out.println("Enter Repayment_Year");
			int Repayment_Year=sc.nextInt();
			
			
			return new Loan(Loan_Id,Loan_Type , Interest_Rate,Loan_Amount,Repayment_Year);
								
				}
	  public static void LoanOperations()
		{
			while(true) {
				System.out.println("Press 1.Add Loan Details\nPress 2.Retrieve All Loan Data\n"
						+ "Press 3.Update Loan Data\nPress 4.Delete Loan Data\n"
						+ "Press 5.To getback to the main menu\nEnter your choice: ");
				int input=sc.nextInt();	
				
				switch(input) {
				case 1:
					Loan user=LoanInputs();
					Loan savedEntity=loanservice.createLoan(user);
					System.out.println("Loan Data has been saved successfully"+ savedEntity);
					break;
				
				case 2:
					List<Loan> users=loanservice.getAllLoan();
					for(Loan user1:users)
					{
						System.out.println(user1);
					}
					break;
					
				case 3:sc.nextLine();
					System.out.println("Enter Branch Id to update the infromation");
				       String uId=sc.next();
				       Loan u=loanservice.getLoan(uId);
				       if(u!=null) {
				    	   Loan us=updatedLoanData();
				     //service
				    	   Loan updatedInfo=loanservice.updateLoan(uId, us);
				       System.out.println("loan Data has been updated Successfully"+ updatedInfo);
				       }
				       
				       else
				       {
				    	   throw new ResourceNotFoundException("loan Id not found");
				       }
				       
					break;
				
				case 4:
					System.out.println("Enter loan Id to delete the infromation");
				       String id=sc.next();
				       String message=loanservice.deleteLoan(id);
				       System.out.println(message);
					break;
				case 5:MainOperation.mainOps();
				}
				
				}
			}
	  
	  
	  static Customerservice customerservice = new Customerserviceimp();
	  public static Customer CustomerInputs()
		{		
			sc.nextLine();
			System.out.println("Enter CustomerID");
			String CustomerID=sc.nextLine();

			System.out.println("Enter Customer_Name ");
			String  Customer_Name=sc.nextLine();
			
			System.out.println("Enter Customer_ac_no ");
			int Customer_ac_no=sc.nextInt();
			
			sc.nextLine();
			
			System.out.println("Enter Customer_Address ");
			String  Customer_Address=sc.nextLine();
			
			return new Customer(CustomerID,Customer_Name,Customer_ac_no,Customer_Address);
							
			}
	  public static Customer updatedCustomerData()
		{
		  sc.nextLine();
			System.out.println("Enter CustomerID");
			String CustomerID=sc.nextLine();

			System.out.println("Enter Customer_Name ");
			String  Customer_Name=sc.nextLine();
			
			System.out.println("Enter Customer_ac_no ");
			int Customer_ac_no=sc.nextInt();
			
			sc.nextLine();
			
			System.out.println("Enter Customer_Address ");
			String  Customer_Address=sc.nextLine();
			
			return new Customer(CustomerID,Customer_Name,Customer_ac_no,Customer_Address);
						
								
				}
	  public static void CustomerOperations()
	  {
			while(true) {
				System.out.println("Press 1.Add Customer Details\nPress 2.Retrieve All Customer Data\n"
						+ "Press 3.Update Customer Data\nPress 4.Delete Customer Data\n"
						+ "Press 5.To getback to the main menu\nEnter your choice: ");
				int input=sc.nextInt();	
				
				switch(input) {
				case 1:
					Customer user=CustomerInputs();
					Customer savedEntity=customerservice.createCustomer(user);
					System.out.println("Customer Data has been saved successfully"+ savedEntity);
					break;
				
				case 2:
					List<Customer> users=customerservice.getAllCustomer();
					for(Customer user1:users)
					{
						System.out.println(user1);
					}
					break;
					
				case 3:sc.nextLine();
					System.out.println("Enter Customer Id to update the infromation");
				       String uId=sc.next();
				       Customer u=customerservice.getCustomer(uId);
				       if(u!=null) {
				    	   Customer us=updatedCustomerData();
				     //service
				    	   Customer updatedInfo=customerservice.updateCustomer(uId, us);
				       System.out.println("Customer Data has been updated Successfully"+ updatedInfo);
				       }
				       
				       else
				       {
				    	   throw new ResourceNotFoundException("Customer Id not found");
				       }
				       
					break;
				
				case 4:
					System.out.println("Enter Customer Id to delete the infromation");
				       String id=sc.next();
				       String message=customerservice.deleteCustomer(id);
				       System.out.println(message);
					break;
				case 5:MainOperation.mainOps();
				}
			}
				}
	  
	  
	  static Employeeservice employeeservice = new Employeeserviceimp();
	  public static Employee EmployeeInputs()
		{		
			sc.nextLine();
			System.out.println("Enter Emp_Id");
			String Emp_Id=sc.nextLine();

			System.out.println("Enter Emp_Name");
			String Emp_Name=sc.nextLine();
			
			System.out.println("Enter Emp_Address");
			String Emp_Address=sc.nextLine();

			System.out.println("Enter Emp_Cont_no");
			long Emp_Cont_no=sc.nextLong();
			

			sc.nextLine();
			System.out.println("Enter Branch_Id");
			String Branch_Id=sc.nextLine();
			
			
			
		
			return new Employee(Emp_Id,Emp_Name, Emp_Address,Emp_Cont_no, Branch_Id);
							
			}
	  public static Employee updatedEmployeeData()
		{
		  	
		  sc.nextLine();
			System.out.println("Enter Emp_Id");
			String Emp_Id=sc.nextLine();

			System.out.println("Enter Emp_Name");
			String Emp_Name=sc.nextLine();
			
			System.out.println("Enter Emp_Address");
			String Emp_Address=sc.nextLine();
			
			System.out.println("Enter Emp_Cont_no");
			long Emp_Cont_no=sc.nextLong();

			sc.nextLine();
			System.out.println("Enter Branch_Id");
			String Branch_Id=sc.nextLine();
			
			
			
		
			
			return new Employee(Emp_Id,Emp_Name, Emp_Address,Emp_Cont_no,Branch_Id);
			
	
								
				}
	  public static void EmployeeOperations()
	  {
			while(true) {
				System.out.println("Press 1.Add Employee Details\nPress 2.Retrieve All Employee Data\n"
						+ "Press 3.Update Employee Data\nPress 4.Delete Employee Data\n"
						+ "Press 5.To getback to the main menu\nEnter your choice: ");
				int input=sc.nextInt();	
				
				switch(input) {
				case 1:
					Employee user=EmployeeInputs();
					Employee savedEntity=employeeservice.createEmployee(user);
					System.out.println("Employee Data has been saved successfully"+ savedEntity);
					break;
				
				case 2:
					List<Employee> users=employeeservice.getAllEmployee();
					for(Employee user1:users)
					{
						System.out.println(user1);
					}
					break;
					
				case 3:sc.nextLine();
					System.out.println("Enter Employee Id to update the infromation");
				       String uId=sc.next();
				       Employee u=employeeservice.getEmployee(uId);
				       if(u!=null) {
				    	   Employee us=updatedEmployeeData();
				     //service
				    	   Employee updatedInfo=employeeservice.updateEmployee(uId, us);
				       System.out.println("Employee Data has been updated Successfully"+ updatedInfo);
				       }
				       
				       else
				       {
				    	   throw new ResourceNotFoundException("Employee Id not found");
				       }
				       
					break;
				
				case 4:
					System.out.println("Enter Employee Id to delete the infromation");
				       String id=sc.next();
				       String message=employeeservice.deleteEmployee(id);
				       System.out.println(message);
					break;
				case 5:MainOperation.mainOps();
				}
			}
				
				}
			
			
		   
			
			static Emiservice emiservice = new Emiserviceimp();
			  public static Emi EmiInputs()
				{		
					sc.nextLine();
					System.out.println("Enter Loan_Id");
					String Loan_Id=sc.nextLine();

					System.out.println("Enter Emi_Amount");
					String Emi_Amount=sc.nextLine();
					
					
					
				
					return new Emi(Loan_Id,Emi_Amount);
									
					}
			  public static Emi updatedEmiData()
				{
				  	
				    sc.nextLine();
					System.out.println("Enter Loan_Id");
					String Loan_Id=sc.nextLine();

					System.out.println("Enter Emi_Amount");
					String Emi_Amount=sc.nextLine();
					
					
					return new Emi(Loan_Id,Emi_Amount);
										
						}
			  public static void EmiOperations()
			  {
					while(true) {
						System.out.println("Press 1.Add Emi Details\nPress 2.Retrieve All Emi Data\n"
								+ "Press 3.Update Emi Data\nPress 4.Delete Emi Data\n"
								+ "Press 5.To getback to the main menu\nEnter your choice: ");
						int input=sc.nextInt();	
						
						switch(input) {
						case 1:
							Emi user=EmiInputs();
							Emi savedEntity=emiservice.createEmi(user);
							System.out.println("Emi Data has been saved successfully"+ savedEntity);
							break;
						
						case 2:
							List<Emi> users=emiservice.getAllEmi();
							for(Emi user1:users)
							{
								System.out.println(user1);
							}
							break;
							
						case 3:sc.nextLine();
							System.out.println("Enter Loan Id to update the infromation");
						       String uId=sc.next();
						       Emi u=emiservice.getEmi(uId);
						       if(u!=null) {
						    	   Emi us=updatedEmiData();
						     //service
						    	   Emi updatedInfo=emiservice.updateEmi(uId, us);
						       System.out.println("Emi Data has been updated Successfully"+ updatedInfo);
						       }
						       
						       else
						       {
						    	   throw new ResourceNotFoundException("loan Id not found");
						       }
						       
							break;
						
						case 4:
							System.out.println("Enter loan Id to delete the infromation");
						       String id=sc.next();
						       String message=emiservice.deleteEmi(id);
						       System.out.println(message);
							break;
							
						case 5:MainOperation.mainOps();
						}
						
					}	}
					
					static Departmentservice departmentservice = new Departmentserviceimp();
					  public static Department DepartmentInputs()
						{		
							sc.nextLine();
							System.out.println("Enter DepartmentID");
							String DepartmentID=sc.nextLine();

							System.out.println("Enter Department_Name ");
							String  Department_Name=sc.nextLine();
							
							return new Department(DepartmentID, Department_Name);
											
							}
					  public static Department updatedDepartmentData()
						{
						  	
						  sc.nextLine();
							System.out.println("Enter DepartmentID");
							String DepartmentID=sc.nextLine();

							System.out.println("Enter Department_Name ");
							String  Department_Name=sc.nextLine();
							
							return new Department(DepartmentID, Department_Name);
												
								}
					  public static void DepartmentOperations()
					  {
							while(true) {
								System.out.println("Press 1.Add Department Details\nPress 2.Retrieve All Department Data\n"
										+ "Press 3.Update Department Data\nPress 4.Delete Department Data\n"
										+ "Press 5.To getback to the main menu\nEnter your choice: ");
								int input=sc.nextInt();	
								
								switch(input) {
								case 1:
									Department user=DepartmentInputs();
									Department savedEntity=departmentservice.createDepartment(user);
									System.out.println("Department Data has been saved successfully"+ savedEntity);
									break;
								
								case 2:
									List<Department> users=departmentservice.getAllDepartment();
									for(Department user1:users)
									{
										System.out.println(user1);
									}
									break;
									
								case 3:sc.nextLine();
									System.out.println("Enter Loan Id to update the infromation");
								       String uId=sc.next();
								       Department u=departmentservice.getDepartment(uId);
								       if(u!=null) {
								    	   Department us=updatedDepartmentData();
								     //service
								    	   Department updatedInfo=departmentservice.updateDepartment(uId, us);
								       System.out.println("Emi Data has been updated Successfully"+ updatedInfo);
								       }
								       
								       else
								       {
								    	   throw new ResourceNotFoundException("Department Id not found");
								       }
								       
									break;
								
								case 4:
									System.out.println("Enter Department Id to delete the infromation");
								       String id=sc.next();
								       String message=departmentservice.deleteDepartment(id);
								       System.out.println(message);
									break;
								case 5:MainOperation.mainOps();
								}
								
								}
							
							

		   
}}