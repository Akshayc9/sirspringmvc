package com.sp.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Employee_Table")
public class EmployeeEn {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int empId;
	private String empName;
	private int empAge;
	private String empGender;
	private double empSalary;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
	        name = "EMPLOYEE_SKILL",
	        joinColumns = @JoinColumn(
	                name = "EMPLOYEE_ID",
	                referencedColumnName = "empId"
	        ),
	        inverseJoinColumns = @JoinColumn(
	                name = "SKILL_ID",
	                referencedColumnName = "skillId"
	        )
	)
	private List<SkillEn> skills = new ArrayList<>();
	
	public EmployeeEn() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeEn(int empId, String empName, int empAge, String empGender, double empSalary, List<SkillEn> skills) {
	super();
	this.empId = empId;
	this.empName = empName;
	this.empAge = empAge;
	this.empGender = empGender;
	this.empSalary = empSalary;
	this.skills = skills;
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

	public List<SkillEn> getSkills() {
		return skills;
	}

	public void setSkills(List<SkillEn> sks) {
		this.skills = sks;
	}

	@Override
	public String toString() {
		return "EmployeeEn [empId=" + empId + ", empName=" + empName + ", empAge=" + empAge + ", empGender=" + empGender
				+ ", empSalary=" + empSalary + ", skills=" + skills + "]";
	}

	
	
}
