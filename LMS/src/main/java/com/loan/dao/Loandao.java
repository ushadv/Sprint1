package com.loan.dao;

import java.util.List;

import com.loan.entity.Emi;
import com.loan.entity.Loan;

public interface Loandao {
	Loan createLoan(Loan loan);	
	List<Loan> getAllLoan();
	//Customer AdminCustomer(Customer customer);
	Loan getLoan(String LoanID);
	//List<Customer> getEnrollmentDetailsByCourseId(String courseId);
	Loan updateLoan(String LoanID,Loan updatedLoan);
	String deleteLoan(String loanID);
	Emi updateEmi(String loanID, Emi updatedEmi);
	Emi getEmi(String loanID);
	List<Emi> getAllEmi();
	Emi createEmi(Emi emi);
	String deleteEmi(String loanID);

}
