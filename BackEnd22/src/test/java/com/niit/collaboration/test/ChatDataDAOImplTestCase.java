package com.niit.collaboration.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.BlogDAO;
import com.niit.collaboration.dao.ChatDataDAO;
import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.Blog;
import com.niit.collaboration.model.ChatData;
import com.niit.collaboration.model.User;


public class ChatDataDAOImplTestCase {

	@Autowired
	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static ChatData chatData;
	@Autowired
	private static ChatDataDAO chatDataDAO;
	@Autowired
	
	@BeforeClass
	public static void initialize() 
	{
		System.out.println(" Blog Test case initializing  " );
		try
		{
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			context.scan("com.niit.*");
			context.refresh();
			chatData = (ChatData) context.getBean(ChatData.class);
		   chatDataDAO = (ChatDataDAO) context.getBean(ChatDataDAO.class);
			
			
			
			System.out.println(" chatData   "+chatData );
			System.out.println(" chatDataDAO   "+chatDataDAO );
			System.out.println(" chatDataDAO Test case initializing Done  " );
			
		}
		catch(Exception e)
		{
	     	System.out.println(e);
		}
	}

	@Ignore
	@Test
	public void addChattest()
	{
		
		chatData.setToUserEmail("rajeev@niit.com");
		chatData.setFromUserEmail("niraj@niit.com");
		chatData.setChatMessage("Hello Mr. Rajeev");
		
		boolean flag = chatDataDAO.addChat(chatData);
		
		
		
		assertTrue("Test case ",flag);
		
	}
	
	@Test
	public void getChatDataTest()
	{
		
		List <ChatData> chatData = chatDataDAO.getAllChatByToFrom("niraj@ibm.com","rajeev@niit.com");
		
		Iterator item = chatData.iterator();
		
		while(item.hasNext())
		{
			ChatData c = (ChatData)item.next();
			c.show();
			  
		}
		
			assertNotNull("Test case ",chatData);
		
	}

}
