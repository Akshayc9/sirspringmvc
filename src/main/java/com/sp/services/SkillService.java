package com.sp.services;

import java.util.List;

import com.sp.beans.SkillsBean;

public interface SkillService {

	//add
	public String addSkill(SkillsBean skillsBean);
	//delete
	public String removeSkill(int skId);
	//update
	public String modifySkill(int skId, SkillsBean skillsBean);
	//get/search skill
	public SkillsBean showSkill(int skId);
	//get all skills
	public List<SkillsBean> showAllSkills();
}
