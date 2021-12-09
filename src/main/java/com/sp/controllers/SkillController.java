package com.sp.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sp.beans.SkillsBean;
import com.sp.services.SkillServiceImpl;

@Controller
@RequestMapping(value = "/skill")
public class SkillController {

	public SkillController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	SkillServiceImpl serImpl;

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView addSkill() {
		HashMap<String, Object> model = new HashMap<String, Object>();
		model.put("skillBean", new SkillsBean());
		model.put("message", "::Skill Set::");
		return new ModelAndView("welcome",model);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView addNewSkill(@ModelAttribute("skillBean") SkillsBean sBean) {
		HashMap<String, Object> model = new HashMap<String, Object>();
		String msg = serImpl.addSkill(sBean);
		model.put("message", msg);
		return new ModelAndView("welcome",model);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView showSkill() {
		HashMap<String, Object> model = new HashMap<String, Object>();
		model.put("skillBean", new SkillsBean());
		model.put("sklist",serImpl.showAllSkills());
		return new ModelAndView("showskills",model);
	}

	@RequestMapping(value = "/delete/{skid}", method = RequestMethod.GET)
	public ModelAndView deleteSkill(@PathVariable("skid") int skid) {
		HashMap<String, Object> model = new HashMap<String, Object>();
		String msg = serImpl.removeSkill(skid);
		model.put("message", msg);
		model.put("sklist",serImpl.showAllSkills());
		return new ModelAndView("showskills",model);
	}

	@RequestMapping(value = "/edit/{skid}", method = RequestMethod.GET)
	public ModelAndView updateSkill(@PathVariable("skid") int skid) {
		HashMap<String, Object> model = new HashMap<String, Object>();
		model.put("skillBean", serImpl.showSkill(skid));
		//		String msg = serImpl.modifySkill(empId, skillsBean);
		//		model.put("skillBean", new SkillsBean());
		//		model.put("message", msg);
		//		//model.put("sklist",serImpl.showAllSkills());
		return new ModelAndView("welcome",model);
	}

	//	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	//	public ModelAndView changeSkill() {
	//		HashMap<String, Object> model = new HashMap<String, Object>();
	//		model.put("sklist",serImpl.showAllSkills());
	//		return new ModelAndView("welcome",model);
	//	}
	//	
}
