package com.sp.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sp.entities.SkillEn;
import com.sp.utility.HibernateUtility;

@Repository
public class SkillDaoImpl implements SkillDao {

	@Autowired
	SessionFactory sFactory;

	Session session = null;
	Transaction tr = null;
	
	@Override
	public String saveSkill(SkillEn skillEn) {
		session = sFactory.openSession();
		tr = session.beginTransaction();
		try {
			if (skillEn != null) {
				session.save(skillEn);
				return "Skills Saved";
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			return "Problem in Saving Skill";
		} finally {
			HibernateUtility.cleanUpResources(session, tr);
		}
		return null;
	}

	@Override
	public String deleteSkill(int skId) {
		session = sFactory.openSession();
		SkillEn sEn = session.get(SkillEn.class, skId);
		try {
			if (skId>0 && sEn !=null) {
				tr = session.beginTransaction();
				session.delete(sEn);
				return "Skill with ID " +skId+" Deleted";
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			return "Problem in Deleting Skill";
		} finally {
			HibernateUtility.cleanUpResources(session, tr);
		}
		return null;
	}

	@Override
	public String updateSkill(int skId, SkillEn skillEn) {
		session = sFactory.openSession();
		SkillEn sEn = session.get(SkillEn.class, skId);
		try {
			if (skId>0 && sEn !=null) {
				tr = session.beginTransaction();
				SkillEn sk = new SkillEn();
				sk.setSkillName(skillEn.getSkillName());
				session.update(sk);
				return "Skill with ID " +skId+" Updated";
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			HibernateUtility.cleanUpResources(session, tr);
		}
		return null;
	}

	@Override
	public SkillEn getSkill(int skId) {
		session = sFactory.openSession();
		try {
				tr = session.beginTransaction();
				SkillEn sEn = session.get(SkillEn.class, skId);
				return sEn;
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			HibernateUtility.cleanUpResources(session, tr);
		}
		return null;
	}

	@Override
	public List<SkillEn> getAllSkills() {
		session = sFactory.openSession();
		tr = session.beginTransaction();
		List<SkillEn> skills = session.createCriteria(SkillEn.class).list();			
		if (skills.isEmpty()) {
			System.out.println("Nothing to display");
		}
		session.close();
		return skills;
	}
	
	
}
