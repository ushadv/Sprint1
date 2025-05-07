package com.loan.serviceimp;

import java.util.List;
import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.loan.entity.Customer;
import com.loan.service.Customerservice;
import com.loan.util.Hibernateutil;

public class Customerserviceimp implements Customerservice {
    Scanner sc = new Scanner(System.in);

    @Override
    public Customer createCustomer(Customer customer) {
        try (Session session = Hibernateutil.getSession()) {
            session.beginTransaction();
            session.save(customer);
            session.getTransaction().commit();
            return customer;
        } catch (HibernateException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Customer> getAllCustomer() {
        try (Session session = Hibernateutil.getSession()) {
            Query<Customer> query = session.createQuery("FROM Customer", Customer.class); // Assuming your entity is named "Branch"
            return query.list();
        } catch (HibernateException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Customer getCustomer(String customerId) {
        try (Session session = Hibernateutil.getSession()) {
            return session.get(Customer.class, customerId);
        } catch (HibernateException  e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Customer updateCustomer(String customerId, Customer updatedCustomer) {
        try (Session session = Hibernateutil.getSession()) {
        	Customer customer = session.get(Customer.class, customerId);
            session.beginTransaction();
            customer.setCustomerID(customerId);
            customer.setCustomer_Name(updatedCustomer.getCustomer_Name());
            customer.setCustomer_ac_no(updatedCustomer.getCustomer_ac_no());
            customer.setCustomer_Address(updatedCustomer.getCustomer_Address());
            session.saveOrUpdate(customer);
            session.getTransaction().commit();
            return customer;
        } catch (HibernateException  e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public String deleteCustomer(String customerId) {
        String message = null;
        try (Session session = Hibernateutil.getSession()) {
           Customer customer = session.get(Customer.class, customerId);
            session.beginTransaction();
            System.out.println("Are you sure you want to delete?");
            String status = sc.next();
            if (status.equalsIgnoreCase("yes")) {
                session.delete(customer);
                session.getTransaction().commit();
                session.evict(customer);
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
