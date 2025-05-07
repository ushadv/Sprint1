package com.loan.serviceimp;

import java.util.List;
import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.loan.entity.Branch;
import com.loan.entity.Emi;
import com.loan.service.Branchservice;
import com.loan.service.Emiservice;
import com.loan.util.Hibernateutil;

public class Emiserviceimp implements Emiservice {
    Scanner sc = new Scanner(System.in);

    @Override
    public Emi createEmi(Emi emi) {
        try (Session session = Hibernateutil.getSession()) {
            session.beginTransaction();
            session.save(emi);
            session.getTransaction().commit();
            return emi;
        } catch (HibernateException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Emi> getAllEmi() {
        try (Session session = Hibernateutil.getSession()) {
            Query<Emi> query = session.createQuery("FROM Emi", Emi.class); // Assuming your entity is named "Branch"
            return query.list();
        } catch (HibernateException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Emi getEmi(String loanID) {
        try (Session session = Hibernateutil.getSession()) {
            return session.get(Emi.class, loanID);
        } catch (HibernateException  e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Emi updateEmi(String loanId, Emi updatedEmi) {
        try (Session session = Hibernateutil.getSession()) {
            Emi emi = session.get(Emi.class, loanId);
            session.beginTransaction();
            
            emi.setLoan_Id(loanId);
            emi.setEmi_Amount(updatedEmi.getEmi_Amount());
            
            session.saveOrUpdate(emi);
            session.getTransaction().commit();
            return emi;
        } catch (HibernateException  e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public String deleteEmi(String loanId) {
        String message = null;
        try (Session session = Hibernateutil.getSession()) {
           Emi emi = session.get(Emi.class, loanId);
            session.beginTransaction();
            System.out.println("Are you sure you want to delete?");
            String status = sc.next();
            if (status.equalsIgnoreCase("yes")) {
                session.delete(emi);
                session.getTransaction().commit();
                session.evict(emi);
                message = "Object is deleted";
            } else {
                message = "User wants to retain this object!!";
            }
        } catch (HibernateException  e) {
            System.out.println(e);
        }
        return message;
    }

	/*@Override
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
	public Emi getEmi(String LoanId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emi updateLoan(String loanId, Emi updatedEmi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEmi(String loanId) {
		// TODO Auto-generated method stub
		return null;
	}*/
}
