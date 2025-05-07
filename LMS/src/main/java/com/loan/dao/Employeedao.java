package com.loan.dao;




import java.util.List;

import org.logicalcobwebs.proxool.admin.Admin;

import com.loan.entity.Branch;
import com.loan.entity.Employee;

public interface Employeedao {
	Employee createEmployee(Employee employee);	
	List<Employee> getAllEmployee();
	//Customer BranchCustomer(Customer customer);
	Employee getEmployee(String EmployeeID);
	//List<Customer> getEnrollmentDetailsByCourseId(String courseId);
	Employee updateEmployee(String EmployeeID,Employee updatedEmployee);
	String deleteEmployee(String employeeID);

}
