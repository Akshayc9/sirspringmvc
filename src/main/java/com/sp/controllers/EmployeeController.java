package com.sp.controllers;

import java.util.HashMap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sp.beans.EmployeeBean;
import com.sp.services.EmployeeServiceImpl;
import com.sp.services.SkillServiceImpl;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

	public EmployeeController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	EmployeeServiceImpl service;

	@Autowired
	SkillServiceImpl skservice;
	
//	@Autowired
//	CityServiceImpl ctService;
//	
//	@Autowired
//	HobbiesServiceImpl hbService;

	@RequestMapping(method = RequestMethod.GET, value = "/save")
	public ModelAndView startPage() {
		HashMap<String, Object> model = new HashMap<String, Object>();
		model.put("message", "::Employee Home Page::");
		model.put("empBean", new EmployeeBean());
		model.put("emplist", service.showAllEmps());
		model.put("skilllist", skservice.showAllSkills());
//		model.put("ctlist", ctService.showAllCities());
//		model.put("hblist", hbService.showAllHobbies());
		return new ModelAndView("employee", model);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/save")
	public ModelAndView loadStartPage(@ModelAttribute(value = "empBean") EmployeeBean employeeBean) {
		HashMap<String, Object> model = new HashMap<String, Object>();
		System.out.println(employeeBean);
		String msg = service.addEmployee(employeeBean);
		model.put("message", msg);
		model.put("empBean", new EmployeeBean());
		model.put("skilllist", skservice.showAllSkills());
//		model.put("ctlist", ctService.showAllCities());
//		model.put("hblist", hbService.showAllHobbies());
		model.put("emplist", service.showAllEmps());
		return new ModelAndView("employee",model);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/update/{empId}")
	public ModelAndView updateRecord(@PathVariable("empId") int empId) {
		HashMap<String, Object> model = new HashMap<String, Object>();
		model.put("emplist", service.showAllEmps());
		model.put("empBean", service.getEmployee(empId));
		model.put("skilllist", skservice.showAllSkills());
//		model.put("ctlist", ctService.showAllCities());
//		model.put("hblist", hbService.showAllHobbies());
		return new ModelAndView("employee",model);
	}
	
//	@RequestMapping(method = RequestMethod.POST, value = "/update")
//	public ModelAndView editRecord(@ModelAttribute("empBean") EmployeeBean employeeBean) {
//		HashMap<String, Object> model = new HashMap<String, Object>();
//		int empId = employeeBean.getEmpId();
//		model.put("emplist", service.showAllEmps());
//		model.put("empBean", new EmployeeBean());
//		return new ModelAndView("empsearch",model);
//	}

	@RequestMapping(method = RequestMethod.GET, value = "/delete/{empId}")
	public ModelAndView deleteRecord(@PathVariable("empId") int empId) {
		HashMap<String, Object> model = new HashMap<String, Object>();
		String msg = service.removeEmployee(empId);
		model.put("message", msg);
		model.put("emplist", service.showAllEmps());
		return new ModelAndView("emplist",model);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/search")
	public ModelAndView searchRecord(@ModelAttribute("empBean") EmployeeBean employeeBean) {
		HashMap<String, Object> model = new HashMap<String, Object>();
		int empId = employeeBean.getEmpId();
		boolean flag = service.searchEmployee(empId);
		String msg = "Employee ID " +empId+ " found";
		if (!flag) {
			msg = "Employee ID " +empId+ " not found";
		}
		model.put("message", msg);
		//model.put("empBean", service.searchEmployee(empId));
		return new ModelAndView("emplist",model);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/search")
	public ModelAndView getRecord() {
		HashMap<String, Object> model = new HashMap<String, Object>();
		model.put("emplist", service.showAllEmps());
		model.put("empBean", new EmployeeBean());
		return new ModelAndView("empsearch",model);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public ModelAndView listEmps() {
		HashMap<String, Object> model = new HashMap<String, Object>();
		model.put("emplist", service.showAllEmps());
		return new ModelAndView("emplist",model);
	}
}
