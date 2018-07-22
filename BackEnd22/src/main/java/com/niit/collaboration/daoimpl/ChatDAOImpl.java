package com.niit.collaboration.daoimpl;


import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.dao.ChatDAO;
import com.niit.collaboration.model.Chat;


@Transactional
@Repository("chatDAO")
public class ChatDAOImpl implements ChatDAO {

	@Autowired
	private SessionFactory sessionFactory;

	

	@SuppressWarnings("unchecked")
	public List<Chat> list() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		List<Chat> chat = session.createQuery("from Chat").list();
		tx.commit();
		session.flush();
		session.close();
		return chat;
	}

	public boolean save(Chat chat) {

		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(chat);
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

	public boolean update(Chat chat) {
		try {
			System.out.println("ChatDao Update called***");
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			//System.out.println("chat=" + chat.getChat().getName() + "& chat =" + chat.getChat().getName());


			session.update(chat);
			session.getTransaction().commit();
			session.flush();
			session.close();
			System.out.println("ChatDao Update finishd***");
			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean delete(Chat chat) {

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.clear();
			session.delete(chat);
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

	public Chat getChatByID(int id) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		// Chat chat = (Chat) session.createQuery("from Chat where
		// id=" + id).uniqueResult();

		Chat chat = (Chat) session.get(Chat.class, id);
		tx.commit();
		session.flush();
		session.close();
		return chat;

	}

	
	
}
