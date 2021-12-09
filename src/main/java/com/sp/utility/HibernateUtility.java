package com.sp.utility;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateUtility {

	public static void cleanUpResources(Session session, Transaction transaction) {
		if (session!=null) {
			if (transaction!=null) {
				session.flush();
				transaction.commit();
				session.close();
			}
		}
	}
}
