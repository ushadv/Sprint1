package com.loan.dao;

import java.util.List;

import com.loan.entity.Customer;



public interface Customerdao {
	Customer createCustomer(Customer customer);	
	List<Customer> getAllCustomer();
	//Customer BranchCustomer(Customer customer);
	Customer getCustomer(String CustomerID);
	//List<Customer> getEnrollmentDetailsByCourseId(String courseId);
	Customer updateCustomer(String CustomerID,Customer updatedCustomer);
	String deleteCustomer(String customerID);

}