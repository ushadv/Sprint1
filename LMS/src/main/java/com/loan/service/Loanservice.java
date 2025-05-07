package com.loan.service;


import java.util.List;

import com.loan.entity.Loan;

public interface Loanservice {
	Loan createLoan(Loan loan);	
	List<Loan> getAllLoan();
	//Customer AdminCustomer(Customer customer);
	Loan getLoan(String LoanId);
	//List<Customer> getEnrollmentDetailsByCourseId(String courseId);
	Loan updateLoan(String loanId,Loan updatedLoan);
	String deleteLoan(String loanId);
}
