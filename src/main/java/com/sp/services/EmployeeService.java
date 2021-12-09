package com.sp.services;

import java.util.List;

import com.sp.beans.EmployeeBean;

public interface EmployeeService {
	
	public String addEmployee(EmployeeBean employeeBean);
	
	public List<EmployeeBean> showAllEmps();
	
	public String modifyEmployee(int empId, EmployeeBean employeeBean);
	
	public String removeEmployee(int empId);
	
	public EmployeeBean getEmployee(int empId);
	
	public boolean searchEmployee(int empId);
}
