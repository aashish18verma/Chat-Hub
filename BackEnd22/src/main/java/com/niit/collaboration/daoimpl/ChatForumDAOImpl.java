package com.niit.collaboration.daoimpl;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.dao.ChatForumDAO;
import com.niit.collaboration.model.ChatForum;


@Transactional
@Repository("chatforumDAO")
public class ChatForumDAOImpl implements ChatForumDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<ChatForum> list() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		List<ChatForum> chatforums = session.createQuery("from ChatForum").list();
		tx.commit();
		session.flush();
		session.close();
		return chatforums;
	}

	public boolean save(ChatForum chatforum) {

		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(chatforum);
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

	public boolean update(ChatForum chatforum) {
		try {
			System.out.println("ChatForumDao Update called***");
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			//System.out.println("chatforum=" + chatforum.getChatForum().getName() + "& chatforum =" + chatforum.getChatForum().getName());


			session.update(chatforum);
			session.getTransaction().commit();
			session.flush();
			session.close();
			System.out.println("ChatForumDao Update finishd***");
			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean delete(ChatForum chatforum) {

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.clear();
			session.delete(chatforum);
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

	public ChatForum getChatForumByID(int id) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		// ChatForum chatforum = (ChatForum) session.createQuery("from ChatForum where
		// id=" + id).uniqueResult();

		ChatForum chatforum = (ChatForum) session.get(ChatForum.class, id);
		tx.commit();
		session.flush();
		session.close();
		return chatforum;

	}

	public ChatForum getChatForumByName(String name) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		ChatForum chatforum = (ChatForum) session.createQuery("from ChatForum where name='" + name + "'").uniqueResult();
		tx.commit();
		session.flush();
		session.close();
		return chatforum;

	}

	
}
