package com.loan.service;


import java.util.List;

import com.loan.entity.Branch;


public interface Branchservice {
	Branch createBranch(Branch branch);	
	List<Branch> getAllBranch();
	//Customer AdminCustomer(Customer customer);
	Branch getBranch(String BranchID);
	//List<Customer> getEnrollmentDetailsByCourseId(String courseId);
	Branch updateBranch(String branchID,Branch updatedBranch);
	String deleteBranch(String branchID);
}