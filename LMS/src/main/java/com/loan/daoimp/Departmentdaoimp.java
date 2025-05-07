package com.loan.daoimp;



import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.loan.dao.Departmentdao;
import com.loan.entity.Department;
import com.loan.entity.Loan;
import com.loan.util.Hibernateutil;


public class Departmentdaoimp implements Departmentdao{
	Scanner sc=new Scanner(System.in);
	@Override
	public Department createDepartment(Department department) {
		try(Session session=Hibernateutil.getSession()) {
			
			session.beginTransaction();
			session.save(department);
			session.getTransaction().commit();
			return department;
			
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
	public List<Department> getAllDepartment() {
		try(Session session=Hibernateutil.getSession()) {
			
			//execute HQL query to retrieve all students data
			Query<Department> query=session.createQuery("FROM Department_Details", Department.class);
			List<Department> departmentList=query.list();
			return departmentList;
			
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
	public Department getDepartment(String departmentID) {
		
			try(Session session=Hibernateutil.getSession()) {
					
				Department department=session.get(Department.class, departmentID);
					return department;
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
	public Department updateDepartment(String departmentID,Department updatedDepartment) {
		try(Session session=Hibernateutil.getSession()) {
			Department department=session.get(Department.class, departmentID);
				session.beginTransaction();
				
				department.setDepartmentID(departmentID);
				department.setDepartment_Name(updatedDepartment.getDepartment_Name());
				
				
				session.saveOrUpdate(department);
				session.getTransaction().commit();
				return department;
			
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
	public String deleteDepartment(String departmentID) {
		String message=null;
		try(Session session=Hibernateutil.getSession()) {
			Department department=session.get(Department.class, departmentID);
				session.beginTransaction();
				System.out.println("Are you sure  you want to delete?");
				String status=sc.next();
				if(status.equalsIgnoreCase("yes"))
				{
					session.delete(department);//data will be deleted from DB
					session.getTransaction().commit();
					session.evict(department);//data will remove from session Cache
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
	public Department updatedepartment(String departmentID, Department updatedDepartment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletedepartment(String DepartmentID) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public Department updatedepartment(String departmentID, Department updatedDepartment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletedepartment(String DepartmentID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department createDepartment(Department department) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department getDepartment(String DepartmentID) {
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
		return null;*/
	}

