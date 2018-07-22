package com.niit.collaboration.daoimpl;



import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.dao.ChatForumCommentDAO;
import com.niit.collaboration.model.ChatForumComment;


@Transactional
@Repository("chatforumcommentDAO")
public class ChatForumCommentDAOImpl implements ChatForumCommentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	

	@SuppressWarnings("unchecked")
	public List<ChatForumComment> list() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		List<ChatForumComment> chatforumcomments = session.createQuery("from ChatForumComment").list();
		tx.commit();
		session.flush();
		session.close();
		return chatforumcomments;
	}

	public boolean save(ChatForumComment chatforumcomment) {

		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(chatforumcomment);
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

	public boolean update(ChatForumComment chatforumcomment) {
		try {
			System.out.println("ChatForumCommentDao Update called***");
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			//System.out.println("chatforumcomment=" + chatforumcomment.getChatForumComment().getName() + "& chatforumcomment =" + chatforumcomment.getChatForumComment().getName());


			session.update(chatforumcomment);
			session.getTransaction().commit();
			session.flush();
			session.close();
			System.out.println("ChatForumCommentDao Update finishd***");
			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean delete(ChatForumComment chatforumcomment) {

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.clear();
			session.delete(chatforumcomment);
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

	public ChatForumComment getChatForumCommentByID(int id) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		// ChatForumComment chatforumcomment = (ChatForumComment) session.createQuery("from ChatForumComment where
		// id=" + id).uniqueResult();

		ChatForumComment chatforumcomment = (ChatForumComment) session.get(ChatForumComment.class, id);
		tx.commit();
		session.flush();
		session.close();
		return chatforumcomment;

	}

	
	
}
