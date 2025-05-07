package com.loan.daoimp;


import java.util.List;
import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.logicalcobwebs.proxool.admin.Admin;

import com.loan.dao.Branchdao;
import com.loan.dao.Loandao;
import com.loan.entity.Branch;
import com.loan.entity.Emi;
import com.loan.entity.Loan;
import com.loan.util.Hibernateutil;


public class Emidaoimp implements Loandao{
	Scanner sc=new Scanner(System.in);
	@Override
	public Emi createEmi(Emi emi) {
		try(Session session=Hibernateutil.getSession()) {
			
			session.beginTransaction();
			session.save(emi);
			session.getTransaction().commit();
			return emi;
			
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
	public List<Emi> getAllEmi() {
		try(Session session=Hibernateutil.getSession()) {
			
			//execute HQL query to retrieve all students data
			Query<Emi> query=session.createQuery("FROM Emi_DEtails", Emi.class);
			List<Emi> emiList=query.list();
			return emiList;
			
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
	public Emi getEmi(String loanID) {
		
			try(Session session=Hibernateutil.getSession()) {
					
				Emi emi=session.get(Emi.class, loanID);
					return emi;
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
	public Emi updateEmi(String loanID,Emi updatedEmi) {
		try(Session session=Hibernateutil.getSession()) {
			Emi emi=session.get(Emi.class, loanID);
				session.beginTransaction();
				
				emi.setLoan_Id(loanID);
				emi.setEmi_Amount(updatedEmi.getEmi_Amount());
				
				
				
				session.saveOrUpdate(emi);
				session.getTransaction().commit();
				return emi;
			
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
	public String deleteEmi(String loanID) {
		String message=null;
		try(Session session=Hibernateutil.getSession()) {
			Emi emi=session.get(Emi.class, loanID);
				session.beginTransaction();
				System.out.println("Are you sure  you want to delete?");
				String status=sc.next();
				if(status.equalsIgnoreCase("yes"))
				{
					session.delete(emi);//data will be deleted from DB
					session.getTransaction().commit();
					session.evict(emi);//data will remove from session Cache
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

	@Override
	public Loan createLoan(Loan loan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Loan> getAllLoan() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Loan getLoan(String LoanID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Loan updateLoan(String LoanID, Loan updatedLoan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteLoan(String loanID) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public Loan createLoan(Loan loan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Loan> getAllLoan() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Loan getLoan(String LoanID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Loan updateLoan(String LoanID, Loan updatedLoan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteLoan(String loanID) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public Loan createLoan(Loan loan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Loan> getAllLoan() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Loan getLoan(String LoanID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Loan updateLoan(String LoanID, Loan updatedLoan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteLoan(String loanID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emi createEmi(Emi emi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emi updateEmi(String LoanId, Emi updatedEmi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emi updateEmi(String LoanID, Emi updatedEmi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emi createEmi(Emi emi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emi> getAllEmi() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emi getEmi(String LoanID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emi updateEmi(String LoanID, Emi updatedEmi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEmi(String loanID) {
		// TODO Auto-generated method stub
		return null;
	}*/

}