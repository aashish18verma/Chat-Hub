package com.niit.collaboration.daoimpl;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.niit.collaboration.config.ApplicationContextConfig;
import com.niit.collaboration.dao.ChatDataDAO;
import com.niit.collaboration.model.Blog;
import com.niit.collaboration.model.ChatData;

@Transactional
@ComponentScan("com.niit.collaboration.daoimpl")
@Component
public class ChatDataDAOImpl implements  ChatDataDAO
{
	public boolean addChat(ChatData chatData) 
	{
		System.out.println(" ************************  ");
		System.out.println(" addChat : BackEnd  ");
		System.out.println(" ************************  ");
		
		
		try 
		{
			SessionFactory sessionFactory = ApplicationContextConfig.getSessionFactory(ApplicationContextConfig.getDataSource());
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			
			chatData.setChatDate(new Date());
			Calendar calendar = Calendar.getInstance();        
			int hour = calendar.get(Calendar.HOUR);
			int minute = calendar.get(Calendar.MINUTE);
			int second = calendar.get(Calendar.SECOND);
			String current_time = hour+":"+minute+":"+second;
			chatData.setChatTime(current_time);
			
			chatData.show();
			
			session.save(chatData);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}

		
		
		
		

	}

	
	
	
	public boolean deleteChat(ChatData chatData) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateChat(ChatData chatData) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<ChatData> getAllChat() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ChatData> getAllChatByToFrom(String toUserEmail, String fromUserEmail) {
		
		SessionFactory sessionFactory = ApplicationContextConfig.getSessionFactory(ApplicationContextConfig.getDataSource());
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		//List <ChatData>chatData = (List) session.createQuery("from ChatData where  toUserEmail='"+toUserEmail+"'").list();
		List <ChatData>chatData = (List) session.createQuery("from ChatData where  fromUserEmail='"+toUserEmail+"' and toUserEmail='"+fromUserEmail+"'" ).list();
		
		tx.commit();
		session.flush();
		session.close();
		return chatData;
		
		
		
		
	}

}
