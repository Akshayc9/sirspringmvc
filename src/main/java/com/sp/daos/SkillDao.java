package com.sp.daos;

import java.util.List;

import com.sp.entities.SkillEn;

public interface SkillDao {

	//add
	public String saveSkill(SkillEn skillEn);
	//delete
	public String deleteSkill(int skId);
	//update
	public String updateSkill(int skId, SkillEn skillEn);
	//get/search skill
	public SkillEn getSkill(int skId);
	//get all skills
	public List<SkillEn> getAllSkills();
	
}
