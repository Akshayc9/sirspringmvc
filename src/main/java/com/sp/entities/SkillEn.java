package com.sp.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name = "Skill_Table")
public class SkillEn {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int skillId;
	private String skillName;
	
	@ManyToMany(mappedBy = "skills", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<EmployeeEn> employeeRef;
	
	@Override
	public String toString() {
		return "SkillEn [skillId=" + skillId + ", skillName=" + skillName + "]";
	}

	public SkillEn() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SkillEn(int skillId, String skillName) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
//		this.employeeRef = employeeRef;
	}

	
	
	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
}
