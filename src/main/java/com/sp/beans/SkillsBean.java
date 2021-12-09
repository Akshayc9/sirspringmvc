package com.sp.beans;

public class SkillsBean {

	private int skillId;
	private String skillName;
	public SkillsBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SkillsBean [skillId=" + skillId + ", skillName=" + skillName + "]";
	}
	public SkillsBean(int skillId, String skillName) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
	}
	public int getSkillId() {
		return skillId;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	
	
}
