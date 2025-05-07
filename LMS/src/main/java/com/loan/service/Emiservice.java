package com.loan.service;


import java.util.List;

import com.loan.entity.Emi;

public interface Emiservice {
	Emi createEmi(Emi emi);	
	List<Emi> getAllEmi();
	//Customer AdminCustomer(Customer customer);
	Emi getEmi(String LoanId);
	//List<Customer> getEnrollmentDetailsByCourseId(String courseId);
	Emi updateEmi(String loanId,Emi updatedEmi);
	String deleteEmi(String loanId);
}
