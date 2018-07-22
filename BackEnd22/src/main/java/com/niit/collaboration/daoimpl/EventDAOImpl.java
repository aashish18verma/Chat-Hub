package com.niit.collaboration.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.dao.EventDAO;
import com.niit.collaboration.model.Event;

@Transactional
@Repository("eventDAO")
public class EventDAOImpl implements EventDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Event> list() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		List<Event> events = session.createQuery("from Event").list();
		tx.commit();
		session.flush();
		session.close();
		return events;
	}

	public boolean save(Event event) {

		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(event);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Event event) {
		try {
			System.out.println("EventDao Update called***");
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			// System.out.println("event=" + event.getEvent().getName() + "&
			// event =" + event.getEvent().getName());

			session.update(event);
			session.getTransaction().commit();
			session.flush();
			session.close();
			System.out.println("EventDao Update finishd***");
			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean delete(Event event) {

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.clear();
			session.delete(event);
			session.getTransaction().commit();
			session.flush();
			session.close();
			return true;
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public Event getEventByID(int id) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		// Event event = (Event) session.createQuery("from Event where
		// id=" + id).uniqueResult();

		Event event = (Event) session.get(Event.class, id);
		tx.commit();
		session.flush();
		session.close();
		return event;

	}

	public Event getEventByName(String name) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Event event = (Event) session.createQuery("from Event where name='" + name + "'").uniqueResult();
		tx.commit();
		session.flush();
		session.close();
		return event;

	}

}
