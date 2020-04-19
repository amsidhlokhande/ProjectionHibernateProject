package com.amsidh.hibernate.app;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.amsidh.hibernate.domains.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(UserDetails.class)
				/*.setProjection(Projections.count("userId"))*/.addOrder(Order.desc("userId"))
				;
		
		
		/*Criteria criteria = session.createCriteria(UserDetails.class)
				.setProjection(Projections.property("userId"));
		*/

		List<UserDetails> users = (List<UserDetails>) criteria.list();
		for (UserDetails userDetails : users) {
			System.out.println(userDetails.getUserName());
		}

		session.getTransaction().commit();
		session.close();

	}

}
