package com.niit.collaboration.daoimpl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.niit.collaboration.config.ApplicationContextConfig;
import com.niit.collaboration.dao.FriendDAO;
import com.niit.collaboration.model.Blog;
import com.niit.collaboration.model.Friend;



@Transactional
@ComponentScan("com.niit.collaboration.daoimpl")
@Component
public class FriendDAOImpl implements FriendDAO
{

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean addFriendList(Friend friend)
	{
		
		try 
		{
			SessionFactory sessionFactory = ApplicationContextConfig.getSessionFactory(ApplicationContextConfig.getDataSource());
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(friend);
			tx.commit();
			session.flush();
			session.close();
			
			System.out.println(" Data added to the Friend using :   addFriendList  ");
			return true;
			
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		
		
		
	}

	public boolean sendFriendRequest(Friend friend) {
	
		
		try 
		{
			SessionFactory sessionFactory = ApplicationContextConfig.getSessionFactory(ApplicationContextConfig.getDataSource());
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			
			session.save(friend);
			tx.commit();
			session.flush();
			session.close();
			
			System.out.println(" Data added to the Friend using :   addFriendList  ");
			return true;
			
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteFriendRequest(Friend friend) {
		
		return false;
	}

	public List<Friend> cnfFriendList(String friendType) {
		
		
		
		return null;
	}
	
	public List<Friend> cnfFriendList(String userEmail,String friendType)
	{
		
		SessionFactory sessionFactory = ApplicationContextConfig.getSessionFactory(ApplicationContextConfig.getDataSource());
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		List<Friend> friend = session.createQuery(" from Friend where userEmail='"+userEmail+"' and freindtype='"+friendType+"'").list();
		tx.commit();
		
		session.flush();
		session.close();
		return friend;
	}

	

	public List<Friend> noncnfFriendList(String userEmail,String friendType)
	{
		
		SessionFactory sessionFactory = ApplicationContextConfig.getSessionFactory(ApplicationContextConfig.getDataSource());
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		List<Friend> friend = session.createQuery(" from Friend where friendUserEmailID='"+userEmail+"' and freindtype='"+friendType+"'").list();
		tx.commit();
		
		session.flush();
		session.close();
		return friend;
	}

	public List<Friend> requestedFriendList(String friendType) {
		
		return null;
	}

	public List<Friend> allFriendList() 
	{
		
		SessionFactory sessionFactory = ApplicationContextConfig.getSessionFactory(ApplicationContextConfig.getDataSource());
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		List<Friend> friend = session.createQuery("from Friend where freindType='cnf'").list();
		tx.commit();
		
		session.flush();
		session.close();
		return friend;
		
	}

	
	public boolean update_noncnf_to_cnf(Friend friend) {
		
		
		SessionFactory sessionFactory = ApplicationContextConfig.getSessionFactory(ApplicationContextConfig.getDataSource());
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		try
		{
			
			Query qry = session.createQuery("update Friend  set FreindType = 'cnf'  where friendID='"+friend.getFriendID()+"'");
			System.out.println(" From Bckend update_noncnf_to_cnf" );	          
			int res = qry.executeUpdate();
		    System.out.println("Command successfully executed....");
		    System.out.println("Numer of records effected due to update query"+res);
		         session.close();
				          sessionFactory.close();
		
		
				          return true;
		}
		catch(Exception e)
		{
	        System.out.println("Error iin  update_noncnf_to_cnf "+e);
			return false;
		}
	}

}
