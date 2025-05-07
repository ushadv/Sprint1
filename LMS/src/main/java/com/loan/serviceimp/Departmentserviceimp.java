

package com.loan.serviceimp;

import java.util.List;
import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.loan.entity.Department;
import com.loan.service.Departmentservice;
import com.loan.util.Hibernateutil;

public class Departmentserviceimp implements Departmentservice {
    Scanner sc = new Scanner(System.in);

    @Override
    public Department createDepartment(Department department) {
        try (Session session = Hibernateutil.getSession()) {
            session.beginTransaction();
            session.save(department);
            session.getTransaction().commit();
            return department;
        } catch (HibernateException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Department> getAllDepartment() {
        try (Session session = Hibernateutil.getSession()) {
            Query<Department> query = session.createQuery("FROM Department", Department.class); // Assuming your entity is named "Branch"
            return query.list();
        } catch (HibernateException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Department getDepartment(String departmentID) {
        try (Session session = Hibernateutil.getSession()) {
            return session.get(Department.class, departmentID);
        } catch (HibernateException  e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Department updateDepartment(String departmentId, Department updatedDepartment) {
        try (Session session = Hibernateutil.getSession()) {
        	Department department = session.get(Department.class, departmentId);
            session.beginTransaction();
            
            department.setDepartmentID(departmentId);
            department.setDepartment_Name(updatedDepartment.getDepartment_Name());
            
            session.saveOrUpdate(department);
            session.getTransaction().commit();
            return department;
        } catch (HibernateException  e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public String deleteDepartment(String departmentId) {
        String message = null;
        try (Session session = Hibernateutil.getSession()) {
        	Department department = session.get(Department.class, departmentId);
            session.beginTransaction();
            System.out.println("Are you sure you want to delete?");
            String status = sc.next();
            if (status.equalsIgnoreCase("yes")) {
                session.delete(department);
                session.getTransaction().commit();
                session.evict(department);
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
	public Department updateDepartment(String departmentID, Department updatedDepartment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteDepartment(String departmentID) {
		// TODO Auto-generated method stub
		return null;
	}*/

	
}
