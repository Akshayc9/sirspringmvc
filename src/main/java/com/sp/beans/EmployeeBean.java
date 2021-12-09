package com.sp.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeBean {
	
	private int empId;
	private String empName;
	private int empAge;
	private String empGender;
	private double empSalary;
	private String[] empSkills;
	@Override
	public String toString() {
		return "EmployeeBean [empId=" + empId + ", empName=" + empName + ", empAge=" + empAge + ", empGender="
				+ empGender + ", empSalary=" + empSalary + ", empSkills=" + Arrays.toString(empSkills) + "]";
	}
	public int getEmpId() {
		return empId;
	}
	public String getEmpName() {
		return empName;
	}
	public int getEmpAge() {
		return empAge;
	}
	public String getEmpGender() {
		return empGender;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public String[] getEmpSkills() {
		return empSkills;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	public void setEmpSkills(String[] empSkills) {
		this.empSkills = empSkills;
	}
	public EmployeeBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeBean(int empId, String empName, int empAge, String empGender, double empSalary, String[] empSkills) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAge = empAge;
		this.empGender = empGender;
		this.empSalary = empSalary;
		this.empSkills = empSkills;
	}
}
