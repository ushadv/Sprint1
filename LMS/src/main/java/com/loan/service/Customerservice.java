package com.loan.service;

import java.util.List;

import com.loan.entity.Customer;

public interface Customerservice {
	Customer createCustomer(Customer customer);	
	List<Customer> getAllCustomer();
	//Customer AdminCustomer(Customer customer);
	Customer getCustomer(String CustomerID);
	//List<Customer> getEnrollmentDetailsByCourseId(String courseId);
	Customer updateCustomer(String customerID,Customer updatedCustomer);
	String deleteCustomer(String customerID);
}