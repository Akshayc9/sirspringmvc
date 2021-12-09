package com.sp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.beans.SkillsBean;
import com.sp.daos.SkillDaoImpl;
import com.sp.entities.SkillEn;

@Service
public class SkillServiceImpl implements SkillService{

	@Autowired
	SkillDaoImpl skdao;
	
	@Override
	public String addSkill(SkillsBean skillsBean) {
		return skdao.saveSkill(beanToEntity(skillsBean));
	}

	@Override
	public String removeSkill(int skId) {
		return skdao.deleteSkill(skId);
	}

	@Override
	public String modifySkill(int skId, SkillsBean skillsBean) {
		return skdao.updateSkill(skId, beanToEntity(skillsBean));
	}

	@Override
	public SkillsBean showSkill(int skId) {
		return entityToBean(skdao.getSkill(skId));
	}

	private SkillsBean entityToBean(SkillEn skill) {
		SkillsBean bean = new SkillsBean();
		bean.setSkillId(skill.getSkillId());
		bean.setSkillName(skill.getSkillName());
		return bean;
	}

	@Override
	public List<SkillsBean> showAllSkills() {
		List<SkillEn> sks = skdao.getAllSkills();
		return entitiesToBean(sks);
	}

	
	private List<SkillsBean> entitiesToBean(List<SkillEn> sks) {
		List<SkillsBean> beans = new ArrayList<SkillsBean>();
		for (SkillEn skillEn : sks) {
			SkillsBean bean = new SkillsBean(skillEn.getSkillId(),skillEn.getSkillName());
			beans.add(bean);
		}
		return beans;
	}

	private SkillEn beanToEntity(SkillsBean skillsBean) {
		if (skillsBean == null) {
			return null;
		}
		SkillEn entity = new SkillEn();
		entity.setSkillId(skillsBean.getSkillId());
		entity.setSkillName(skillsBean.getSkillName());
		return entity;
	}
}
