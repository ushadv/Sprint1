package com.loan.daoimp;


import java.util.List;
import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.loan.dao.Employeedao;
import com.loan.dao.Loandao;
import com.loan.entity.Employee;
import com.loan.entity.Loan;
import com.loan.util.Hibernateutil;


public class Employeedaoimp implements Employeedao{
	Scanner sc=new Scanner(System.in);
	@Override
	public Employee createEmployee(Employee employee) {
		try(Session session=Hibernateutil.getSession()) {
			
			session.beginTransaction();
			session.save(employee);
			session.getTransaction().commit();
			return employee;
			
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
	public List<Employee> getAllEmployee() {
		try(Session session=Hibernateutil.getSession()) {
			
			//execute HQL query to retrieve all students data
			Query<Employee> query=session.createQuery("FROM Employee_Details", Employee.class);
			List<Employee> employeeList=query.list();
			return employeeList;
			
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
	public Employee getEmployee(String employeeID) {
		
			try(Session session=Hibernateutil.getSession()) {
					
				Employee employee=session.get(Employee.class, employeeID);
					return employee;
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
	public Employee updateEmployee(String employeeID,Employee updatedEmployee) {
		try(Session session=Hibernateutil.getSession()) {
			Employee employee=session.get(Employee.class, employeeID);
				session.beginTransaction();
				
				employee.setEmp_Id(employeeID);
				employee.setEmp_Name(updatedEmployee.getEmp_Name());
				employee.setEmp_Address(updatedEmployee.getEmp_Address());
				employee.setEmp_Cont_no(updatedEmployee.getEmp_Cont_no());
				employee.setBranch_Id(updatedEmployee.getBranch_Id());
				
				session.saveOrUpdate(employee);
				session.getTransaction().commit();
				return employee;
			
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
	public String deleteEmployee(String employeeID) {
		String message=null;
		try(Session session=Hibernateutil.getSession()) {
			Employee employee=session.get(Employee.class, employeeID);
				session.beginTransaction();
				System.out.println("Are you sure  you want to delete?");
				String status=sc.next();
				if(status.equalsIgnoreCase("yes"))
				{
					session.delete(employee);//data will be deleted from DB
					session.getTransaction().commit();
					session.evict(employee);//data will remove from session Cache
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