package com.sp.daos;

import java.util.InputMismatchException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sp.entities.EmployeeEn;
import com.sp.utility.HibernateUtility;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	SessionFactory sfactory;
	
	Session session = null;
	Transaction tr = null;
	
	@Override
	public String saveEmployee(EmployeeEn employeeEn) {
		session = sfactory.openSession();
		tr = session.beginTransaction();
		try {
			if (employeeEn !=null) {
				session.save(employeeEn);
				return "Employee Record Added Successfully";
			} 
		} catch (NullPointerException e) {
			e.printStackTrace();
			return "Problem in Employee Save ";
		}
		finally {
			HibernateUtility.cleanUpResources(session, tr);
		}
		return null;
	}

	@Override
	public List<EmployeeEn> getAllEmployees() {
		session = sfactory.openSession();
		List<EmployeeEn> cr = session.createCriteria(EmployeeEn.class).list();
		if (cr.isEmpty()) {
			System.out.println("Employee list empty");
		}
		session.close();
		return cr;
	}
	

	@Override
	public String updateEmployee(int empId, EmployeeEn employeeEn) {
		session = sfactory.openSession();
		tr = session.beginTransaction();
		
		try {
			if (empId >0 && employeeEn != null) {
				EmployeeEn emp = session.get(EmployeeEn.class, empId);
				emp.setEmpId(employeeEn.getEmpId());
				emp.setEmpName(employeeEn.getEmpName());
				emp.setEmpAge(employeeEn.getEmpAge());
				emp.setEmpGender(employeeEn.getEmpGender());
				emp.setEmpSalary(employeeEn.getEmpSalary());
				emp.setSkills(employeeEn.getSkills());
//				emp.setCity(employeeEn.getCity());
//				emp.setHobbies(employeeEn.getHobbies());
				session.update(emp);
				return "Employee with ID "+empId+"  Successfully Updated";
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (InputMismatchException e) {
			e.printStackTrace();
		} finally {
			HibernateUtility.cleanUpResources(session, tr);
		}
		return "Employee can not up update";
	}

	@Override
	public EmployeeEn getEmployee(int empId) {
		session = sfactory.openSession();
		if (empId > 0) {
			EmployeeEn emp = session.get(EmployeeEn.class, empId);
			return emp;
		}
		session.close();
		return null;
	}
	
	@Override
	public boolean searchEmployee(int empId) {
		session = sfactory.openSession();
		tr = session.beginTransaction();
		try {
			if (empId > 0) {
				EmployeeEn emp = session.get(EmployeeEn.class, empId);
				if (emp!=null) {
					return true;
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			HibernateUtility.cleanUpResources(session, tr);
		}
		return false;
	}

	@Override
	public String deleteEmployee(int empId) {
		session = sfactory.openSession();
		tr = session.beginTransaction();
		try {
			EmployeeEn en = session.get(EmployeeEn.class, empId);
			session.delete(en);
			return "Employee with ID "+empId+"  Successfully Deleted";
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			HibernateUtility.cleanUpResources(session, tr);
		}
		return "Employee can not delete";
	}
}
