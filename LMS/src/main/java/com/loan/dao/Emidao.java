package com.loan.dao;

import java.util.List;

import com.loan.entity.Emi;

public interface Emidao {
	Emi createEmi(Emi emi);	
	List<Emi> getAllEmi();
	//Customer AdminCustomer(Customer customer);
	Emi getEmi(String emiID);
	//List<Customer> getEnrollmentDetailsByCourseId(String courseId);
	Emi updateEmi(String emiID,Emi updatedEmi);
	String deleteEmi(String emiID);

}