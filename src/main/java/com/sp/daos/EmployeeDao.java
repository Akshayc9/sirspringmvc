package com.sp.daos;

import java.util.List;

import com.sp.entities.EmployeeEn;

public interface EmployeeDao {
	
	public String saveEmployee(EmployeeEn employeeEn);

	public List<EmployeeEn> getAllEmployees();
	
	public String updateEmployee(int empId, EmployeeEn employeeEn);
	
	public EmployeeEn getEmployee(int empId);
	
	public boolean searchEmployee(int empId);
	
	public String deleteEmployee(int empId);
}
