package com.loan.dao;

import java.util.List;

import com.loan.entity.Department;



public interface Departmentdao {
	Department createDepartment(Department department);	
	List<Department> getAllDepartment();
	//Orders OrdersCustomer(Orders orders);
	Department getDepartment(String departmentID);
	//List<Orders> getOrdersDetailsByCustomerId(String customerId);
	Department updatedepartment(String departmentID,Department updatedDepartment);
	String deletedepartment(String DepartmentID);
	Department updateDepartment(String departmentID, Department updatedDepartment);
	String deleteDepartment(String departmentID);
}