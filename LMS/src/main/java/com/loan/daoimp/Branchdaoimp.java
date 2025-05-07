package com.loan.daoimp;


import java.util.List;
import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.logicalcobwebs.proxool.admin.Admin;

import com.loan.dao.Branchdao;
import com.loan.entity.Branch;
import com.loan.util.Hibernateutil;


public class Branchdaoimp implements Branchdao{
	Scanner sc=new Scanner(System.in);
	@Override
	public Branch createBranch(Branch branch) {
		try(Session session=Hibernateutil.getSession()) {
			
			session.beginTransaction();
			session.save(branch);
			session.getTransaction().commit();
			return branch;
			
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
	public List<Branch> getAllBranch() {
		try(Session session=Hibernateutil.getSession()) {
			
			//execute HQL query to retrieve all students data
			Query<Branch> query=session.createQuery("FROM Branch_Details",Branch.class);
			List<Branch> branchList=query.list();
			return branchList;
			
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
	public Branch getBranch(String branchID) {
		
			try(Session session=Hibernateutil.getSession()) {
					
				Branch branch=session.get(Branch.class, branchID);
					return branch;
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
	public  Branch updateBranch(String branchID,Branch updatedBranch) {
		try(Session session=Hibernateutil.getSession()) {
			Branch branch=session.get(Branch.class, branchID);
				session.beginTransaction();
				
				branch.setBranch_Id(branchID);
				branch.setBranch_Name(updatedBranch.getBranch_Name());
				branch.setBranch_Address(updatedBranch.getBranch_Address());
				
				
				session.saveOrUpdate(branch);
				session.getTransaction().commit();
				return branch;
			
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
	public String deleteBranch(String branchID) {
		String message=null;
		try(Session session=Hibernateutil.getSession()) {
			Branch branch=session.get(Branch.class, branchID);
				session.beginTransaction();
				System.out.println("Are you sure  you want to delete?");
				String status=sc.next();
				if(status.equalsIgnoreCase("yes"))
				{
					session.delete(branch);//data will be deleted from DB
					session.getTransaction().commit();
					session.evict(branch);//data will remove from session Cache
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

	public Branchdaoimp() {
		super();
	}

	/*@Override
	public Branch updateBranch(String BranchID, Branch updatedBranch) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Branch createBranch(Branch branch) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Branch updateBranch(String BranchId, Branch updatedBranch) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Branch updateBranch(String BranchID, Branch updatedBranch) {
		// TODO Auto-generated method stub
		return null;
	}*/

}