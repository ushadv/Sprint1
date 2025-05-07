package com.loan.service;

import java.util.List;

import com.loan.entity.Department;

public interface Departmentservice {
		Department createDepartment(Department department);	
		List<Department> getAllDepartment();
		//Customer AdminCustomer(Customer customer);
		Department getDepartment(String DepartmentID);
		//List<Customer> getEnrollmentDetailsByCourseId(String courseId);
		Department updateDepartment(String departmentID,Department updatedDepartment);
		String deleteDepartment(String departmentID);
	}

