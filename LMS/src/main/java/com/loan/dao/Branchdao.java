package com.loan.dao;


import java.util.List;

import org.logicalcobwebs.proxool.admin.Admin;

import com.loan.entity.Branch;

public interface Branchdao {
	Branch createBranch(Branch branch);	
	List<Branch> getAllBranch();
	//Customer BranchCustomer(Customer customer);
	Branch getBranch(String BranchID);
	//List<Customer> getEnrollmentDetailsByCourseId(String courseId);
	Branch updateBranch(String BranchID,Branch updatedBranch);
	String deleteBranch(String brachID);

}
