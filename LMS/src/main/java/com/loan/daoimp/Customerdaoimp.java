package com.loan.daoimp;



import java.util.List;
import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;


import com.loan.dao.Customerdao;
import com.loan.entity.Customer;
import com.loan.util.Hibernateutil;


public class Customerdaoimp implements Customerdao{
	Scanner sc=new Scanner(System.in);
	@Override
	public Customer createCustomer(Customer customer) {
		try(Session session=Hibernateutil.getSession()) {
			
			session.beginTransaction();
			session.save(customer);
			session.getTransaction().commit();
			return customer;
			
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
	public List<Customer> getAllCustomer() {
		try(Session session=Hibernateutil.getSession()) {
			
			//execute HQL query to retrieve all students data
			Query<Customer> query=session.createQuery("FROM Customer_Details",Customer.class);
			List<Customer> customerList=query.list();
			return customerList;
			
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
	public Customer getCustomer(String customerID) {
		
			try(Session session=Hibernateutil.getSession()) {
					
				Customer customer=session.get(Customer.class, customerID);
					return customer;
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
	public  Customer updateCustomer(String customerID,Customer updatedCustomer) {
		try(Session session=Hibernateutil.getSession()) {
			Customer customer=session.get(Customer.class, customerID);
				session.beginTransaction();
				
				customer.setCustomerID(customerID);
				customer.setCustomer_Name(updatedCustomer.getCustomer_Name());
				customer.setCustomer_ac_no(updatedCustomer.getCustomer_ac_no());
				customer.setCustomer_Address(updatedCustomer.getCustomer_Address());
				
				
				session.saveOrUpdate(customer);
				session.getTransaction().commit();
				return customer;
			
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
	public String deleteCustomer(String customerID) {
		String message=null;
		try(Session session=Hibernateutil.getSession()) {
			Customer customer=session.get(Customer.class, customerID);
				session.beginTransaction();
				System.out.println("Are you sure  you want to delete?");
				String status=sc.next();
				if(status.equalsIgnoreCase("yes"))
				{
					session.delete(customer);//data will be deleted from DB
					session.getTransaction().commit();
					session.evict(customer);//data will remove from session Cache
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

	public Customerdaoimp() {
		super();
	}

	

	
}