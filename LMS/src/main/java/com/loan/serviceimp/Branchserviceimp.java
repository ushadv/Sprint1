package com.loan.serviceimp;

import java.util.List;
import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.loan.entity.Branch;
import com.loan.service.Branchservice;
import com.loan.util.Hibernateutil;

public class Branchserviceimp implements Branchservice {
    Scanner sc = new Scanner(System.in);

    @Override
    public Branch createBranch(Branch branch) {
        try (Session session = Hibernateutil.getSession()) {
            session.beginTransaction();
            session.save(branch);
            session.getTransaction().commit();
            return branch;
        } catch (HibernateException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Branch> getAllBranch() {
        try (Session session = Hibernateutil.getSession()) {
            Query<Branch> query = session.createQuery("FROM Branch", Branch.class); // Assuming your entity is named "Branch"
            return query.list();
        } catch (HibernateException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Branch getBranch(String branchId) {
        try (Session session = Hibernateutil.getSession()) {
            return session.get(Branch.class, branchId);
        } catch (HibernateException  e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Branch updateBranch(String branchId, Branch updatedBranch) {
        try (Session session = Hibernateutil.getSession()) {
            Branch branch = session.get(Branch.class, branchId);
            session.beginTransaction();
            branch.setBranch_Id(branchId);
            branch.setBranch_Name(updatedBranch.getBranch_Name());
            branch.setBranch_Address(updatedBranch.getBranch_Address());
            session.saveOrUpdate(branch);
            session.getTransaction().commit();
            return branch;
        } catch (HibernateException  e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public String deleteBranch(String branchId) {
        String message = null;
        try (Session session = Hibernateutil.getSession()) {
            Branch branch = session.get(Branch.class, branchId);
            session.beginTransaction();
            System.out.println("Are you sure you want to delete?");
            String status = sc.next();
            if (status.equalsIgnoreCase("yes")) {
                session.delete(branch);
                session.getTransaction().commit();
                session.evict(branch);
                message = "Object is deleted";
            } else {
                message = "User wants to retain this object!!";
            }
        } catch (HibernateException  e) {
            System.out.println(e);
        }
        return message;
    }
}
