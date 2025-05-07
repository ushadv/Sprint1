package com.loan.serviceimp;


import java.util.List;
import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.loan.entity.Loan;
import com.loan.service.Loanservice;
import com.loan.util.Hibernateutil;

public class Loanserviceimp implements Loanservice {
	Scanner sc=new Scanner(System.in);
	@Override
	public Loan createLoan(Loan loan) {
		try(Session session=Hibernateutil.getSession()) {
			
			session.beginTransaction();
			session.save(loan);
			session.getTransaction().commit();
			return loan;
			
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	@Override
	public List<Loan> getAllLoan() {
		try(Session session=Hibernateutil.getSession()) {
			
			//execute HQL query to retrieve all students data
			Query<Loan> query=session.createQuery("FROM Loan", Loan.class);
			List<Loan> loanList=query.list();
			return loanList;
			
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	
	@Override
	public Loan getLoan(String loanID) {
		
			try(Session session=Hibernateutil.getSession()) {
					
				Loan loan=session.get(Loan.class, loanID);
					return loan;
				}
				catch (HibernateException e) {
					System.out.println(e);
				}
				catch (Exception e) {
					System.out.println(e);
				}
				
				return null;
			}

    
	@Override
	public Loan updateLoan(String loanID,Loan updatedLoan) {
		try(Session session=Hibernateutil.getSession()) {
			Loan loan=session.get(Loan.class, loanID);
				session.beginTransaction();
				
				loan.setLoan_Id(loanID);
				loan.setLoan_Type(updatedLoan.getLoan_Type());
				loan.setInterest_Rate(updatedLoan.getInterest_Rate());
				loan.setLoan_Amount(updatedLoan.getLoan_Amount());
				loan.setRepayment_Year(updatedLoan.getRepayment_Year());
				
				session.saveOrUpdate(loan);
				session.getTransaction().commit();
				return loan;
			
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public String deleteLoan(String loanID) {
		String message=null;
		try(Session session=Hibernateutil.getSession()) {
			Loan loan=session.get(Loan.class, loanID);
				session.beginTransaction();
				System.out.println("Are you sure  you want to delete?");
				String status=sc.next();
				if(status.equalsIgnoreCase("yes"))
				{
					session.delete(loan);//data will be deleted from DB
					session.getTransaction().commit();
					session.evict(loan);//data will remove from session Cache
					message="Object is deleted";
					
				}else
				{
					message="User wants to retain this object!!";
				}
				
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return message;

}

}