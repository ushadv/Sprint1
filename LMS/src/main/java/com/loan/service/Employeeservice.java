package com.loan.service;



import java.util.List;

import com.loan.entity.Employee;

public interface Employeeservice {
	Employee createEmployee(Employee employee);	
	List<Employee> getAllEmployee();
	//Customer AdminCustomer(Customer customer);
	Employee getEmployee(String EmployeeId);
	//List<Customer> getEnrollmentDetailsByCourseId(String courseId);
	Employee updateEmployee(String employeeId,Employee updatedEmployee);
	String deleteEmployee(String employeeId);
}

