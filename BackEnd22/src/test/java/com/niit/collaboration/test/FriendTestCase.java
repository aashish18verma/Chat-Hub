package com.niit.collaboration.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.FriendDAO;
import com.niit.collaboration.daoimpl.FriendDAOImpl;
import com.niit.collaboration.model.Friend;
import com.niit.collaboration.model.User;

public class FriendTestCase {

	@BeforeClass
	public static void initialize() {
		System.out.println("initialize() ");

	}

	
	@Ignore
	@Test
	public void createFriendTestCase() {
		System.out.println("createFriendTestCase() ");
		FriendDAO friendDAO = new FriendDAOImpl();
		Friend friend = new Friend();
		
		User user = new User();
		user.setUserEmail("niraj@niit.com");
		
		friend.setUser(user);
		
		friend.setFriendUserEmailID("rajeev@niit.com");
		friendDAO.addFriendList(friend);
		
		
		
		
	}


	@Ignore
	@Test
	public void deleteFriendTestCase() 
	{
		System.out.println("deleteFriendTestCase() ");
	
	}

	@Test
	public void updateFriendTestCase() {
		System.out.println("updateFriendTestCase()");
		
		FriendDAO friendDAO = new FriendDAOImpl();
		Friend friend = new Friend();
		User user = new User();
		user.setUserEmail("niraj@niit.com");
		friend.setUser(user);
		friend.setFriendUserEmailID("rajeev@niit.com");
		friendDAO.update_noncnf_to_cnf(friend);
		
	}

	
	@Ignore
	@Test
	public void allnoncnfFriendTestCase() {
		
		System.out.println(" All  noncnf Friend ");
		FriendDAO friendDAO = new FriendDAOImpl();
		List <Friend> friend = friendDAO.noncnfFriendList("niraj@niit.com","noncnf");
		Iterator item = friend.iterator();
		
		while(item.hasNext())
		{
			Friend f =  (Friend) item.next();
			System.out.println(f.getFriendID());
			f.show(f);
			
		}
		
	}
	
	
	@Ignore
	@Test
	public void allFriendTestCase() {
		
		System.out.println(" All Friend");
		
		FriendDAO friendDAO = new FriendDAOImpl();
		List <Friend> friend = friendDAO.allFriendList();
		Iterator item = friend.iterator();
		
		while(item.hasNext())
		{
			Friend f =  (Friend) item.next();
			System.out.println(f.getFriendID());
			
			f.show(f);
			
		}
		
		
	}

}
