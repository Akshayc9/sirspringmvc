package com.sp.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.beans.EmployeeBean;
import com.sp.daos.EmployeeDaoImpl;
import com.sp.daos.SkillDaoImpl;
import com.sp.entities.EmployeeEn;
import com.sp.entities.SkillEn;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDaoImpl empdao;
	
	@Autowired
	SkillDaoImpl skdao;
	
	@Autowired
	SkillServiceImpl skservice;
	
	@Override
	public String addEmployee(EmployeeBean employeeBean) {
		System.out.println(employeeBean);
		return empdao.saveEmployee(beanToEntity(employeeBean));
	}

	@Override
	public List<EmployeeBean> showAllEmps() {
		List<EmployeeEn> emps = empdao.getAllEmployees();
		return entitiesToBean(emps);
	}

	@Override
	public String modifyEmployee(int empId, EmployeeBean employeeBean) {
		return empdao.updateEmployee(empId, beanToEntity(employeeBean));
	}

	private EmployeeEn beanToEntity(EmployeeBean employeeBean) {
		if (employeeBean == null) {
			return null;
		}
				
		String[] skills = employeeBean.getEmpSkills();
		
		List<SkillEn> sks = new ArrayList<>();
		for (String string : skills) {
			SkillEn sk = new SkillEn();
			sk.setSkillName(string);
			sks.add(sk);
		}

		
		
		
		EmployeeEn entity = new EmployeeEn();
		entity.setEmpId(employeeBean.getEmpId());
		entity.setEmpName(employeeBean.getEmpName());
		entity.setEmpAge(employeeBean.getEmpAge());
		entity.setEmpGender(employeeBean.getEmpGender());
		entity.setEmpSalary(employeeBean.getEmpSalary());
		entity.setSkills(sks);
		System.out.println(entity);
		return entity;
	}

	
	private List<EmployeeBean> entitiesToBean(List<EmployeeEn> emps) {
		List<EmployeeBean> beans = new ArrayList<EmployeeBean>();
		
		for (EmployeeEn employeeEn : emps) {
		
			List<SkillEn> lists = employeeEn.getSkills();
			List<String> arr = new ArrayList<String>();
			String in = "";
			for (SkillEn sken : lists) {
				in = sken.getSkillName();
				arr.add(in);
			}
			
			String[] myArray = new String[arr.size()];
			arr.toArray(myArray);			
			
			EmployeeBean bean = new EmployeeBean(employeeEn.getEmpId(), employeeEn.getEmpName(), employeeEn.getEmpAge(),
					employeeEn.getEmpGender(), employeeEn.getEmpSalary(),myArray);
			beans.add(bean);
		}
		System.out.println(beans);
		return beans;
	}
	
	private EmployeeBean entityToBean(EmployeeEn employeeEn) {
		
		List<SkillEn> lists = employeeEn.getSkills();
		List<String> arr = new ArrayList<String>();
		String in = "";
		for (SkillEn sken : lists) {
			in = sken.getSkillName();
			arr.add(in);
		}
		
		String[] myArray = new String[arr.size()];
		arr.toArray(myArray);
		
		EmployeeBean bean = new EmployeeBean();
		bean.setEmpId(employeeEn.getEmpId());
		bean.setEmpAge(employeeEn.getEmpAge());	
		bean.setEmpName(employeeEn.getEmpName());	
		bean.setEmpGender(employeeEn.getEmpGender());	
		bean.setEmpSalary(employeeEn.getEmpSalary());
		bean.setEmpSkills(myArray);
		System.out.println(bean);
		return bean;
	}

	@Override
	public String removeEmployee(int empId) {
		return empdao.deleteEmployee(empId);
	}

	@Override
	public EmployeeBean getEmployee(int empId) {
		return entityToBean(empdao.getEmployee(empId));
	}
	
	@Override
	public boolean searchEmployee(int empId) {
		return empdao.searchEmployee(empId);
	}
}
