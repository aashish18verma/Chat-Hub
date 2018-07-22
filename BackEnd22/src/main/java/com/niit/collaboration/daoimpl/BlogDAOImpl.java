package com.niit.collaboration.daoimpl;

import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.config.ApplicationContextConfig;
import com.niit.collaboration.dao.BlogDAO;
import com.niit.collaboration.model.Blog;
import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.User;

@Transactional
@ComponentScan("com.niit.collaboration.daoimpl")
@Component
public class BlogDAOImpl implements BlogDAO
{
	@Autowired
	private SessionFactory sessionFactory;

	public List<Blog> getAllBlog()
	{
		SessionFactory sessionFactory = ApplicationContextConfig.getSessionFactory(ApplicationContextConfig.getDataSource());
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Blog> blogs = session.createQuery("from Blog").list();
		tx.commit();
		session.flush();
		session.close();
		return blogs;
		
	}

	
	public boolean save(Blog blog,User user)
	{

		try 
		{
			SessionFactory sessionFactory = ApplicationContextConfig.getSessionFactory(ApplicationContextConfig.getDataSource());
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			blog.setBlogCreatedDate(new Date());
			blog.setBlogLikes(0);
			blog.setBlogStatus("  blog  Status   ");
			blog.setUser(user);
			session.save(blog);
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

	
	
	public boolean update(Blog blog)
	{
		try 
		{
			SessionFactory sessionFactory = ApplicationContextConfig.getSessionFactory(ApplicationContextConfig.getDataSource());
			System.out.println("BlogDao Update called***");
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(blog);
			session.getTransaction().commit();
			session.flush();
			session.close();
			System.out.println("ProductDao Update finishd***");
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}

	}
	

	public boolean delete(Blog blog) 
	{

		try
		{
			SessionFactory sessionFactory = ApplicationContextConfig.getSessionFactory(ApplicationContextConfig.getDataSource());
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.clear();
			session.delete(blog);
			session.getTransaction().commit();
			session.flush();
			session.close();
			return true;
		}
		catch (Exception e) 
		{
			System.out.println("Error in  Delete Blog " + e.getMessage());
			return false;
		}

	}

	public Blog getBlogByID(int id) 
	{

		System.out.println(" getBlogByID   Begin ");
		SessionFactory sessionFactory = ApplicationContextConfig.getSessionFactory(ApplicationContextConfig.getDataSource());
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
	 	Blog blog = (Blog) session.get(Blog.class, id);
		tx.commit();
		session.flush();
		session.close();
		System.out.println(" getBlogByID   End ");
		return blog;

	}
	

	public List<Blog>  getBlogByName(String userEmail) {
		SessionFactory sessionFactory = ApplicationContextConfig.getSessionFactory(ApplicationContextConfig.getDataSource());
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List <Blog>blog = (List) session.createQuery("from Blog where userEmail='" + userEmail + "'").uniqueResult();
		tx.commit();
		session.flush();
		session.close();
		return blog;
	}

	
}
