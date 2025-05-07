package com.loan.util;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.loan.entity.Branch;
import com.loan.entity.Customer;
import com.loan.entity.Department;
import com.loan.entity.Emi;
import com.loan.entity.Employee;
import com.loan.entity.Loan;


public class Hibernateutil {

	private final static SessionFactory sessionFactory=buildSessionFactory();
	private static SessionFactory buildSessionFactory()
	{

		try {
			return new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Branch.class)
					.addAnnotatedClass(Loan.class)
					.addAnnotatedClass(Customer.class)
					.addAnnotatedClass(Emi.class)
					.addAnnotatedClass(Employee.class)
					.addAnnotatedClass(Department.class)
					.buildSessionFactory();
			
		}catch (Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session getSession()
	{
	  return getSessionFactory().openSession(); //session opened
	}
		

}