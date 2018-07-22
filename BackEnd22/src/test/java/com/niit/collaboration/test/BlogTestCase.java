package com.niit.collaboration.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.BlogDAO;
import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.daoimpl.BlogDAOImpl;
import com.niit.collaboration.model.Blog;
import com.niit.collaboration.model.User;

public class BlogTestCase {
	@Autowired
	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static Blog blog;
	@Autowired
	private static BlogDAO blogDAO;
	@Autowired
	private static User user;
	@Autowired
	private static UserDAO userDAO;
	
	
	@BeforeClass
	public static void initialize() 
	{

		System.out.println(" Blog Test case initializing  " );
		try
		{
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			context.scan("com.niit.*");
			context.refresh();
			blog = (Blog) context.getBean(Blog.class);
			blogDAO = (BlogDAO) context.getBean(BlogDAO.class);
			user = (User) context.getBean(User.class);
			userDAO = (UserDAO) context.getBean(UserDAO.class);
			System.out.println(" user   "+user );
			System.out.println(" userDAO   "+user );
			System.out.println(" Blog Test case initializing Done  " );
		}
		catch(Exception e)
		{
	     	System.out.println(e);
		}
	}
	
	@Ignore
	@Test public void createBlogTestCase() 
	{
		System.out.println(" createBlogTestCase begin   " );
		
		blog.setBlogName("niit");
		blog.setBlogComment(" Blog Comment About NIIT ");
		
		user = userDAO.getUser("niraj@niit.com");
		System.out.println("Blog Testing  User Data  ");
		
		try
		{
			 System.out.println("Blog try  ");
			 user.show(user);
		 }
		 catch(Exception e)
		 {
			 System.out.println(" Error in Blog create test case " + e);
		 }
		boolean flag = blogDAO.save(blog,user);
		Assert.assertEquals("createBlogTestCase", true, flag);
		
		System.out.println(" createBlogTestCase end   " );
	}


	@Test public void getAllBlogTestCase() 
	{
		System.out.println(" get All Blog Test Case begin   " );
		
		try
		{
			 System.out.println("Blog try  ");
			 user.show(user);
		 }
		 catch(Exception e)
		 {
			 System.out.println(" Error in Blog create test case " + e);
		 }
		List <Blog> blogList = blogDAO.getAllBlog();
		Iterator items = blogList.iterator();
		while(items.hasNext())
		{
			Blog blog = (Blog) items.next();
			blog.show(blog);
		}
		
		Assert.assertEquals("getAllBlogTestCase",true, blogList);
		
	}

	@Ignore
	@Test public void getBlogByIDTestCase()
	{
		
		System.out.println("getBlogByIDTestCase    " );
		System.out.println(" ********************** " );
		
		Blog blogList = blogDAO.getBlogByID(7);
		
		
		System.out.println(" ********************** " );
		System.out.println(" ********get DATA By Blog Lsit 7************** " );
		System.out.println(" ********************** " );
		blogList.show(blogList);
		System.out.println(" ********************** " );
		System.out.println(" ********************** " );
		System.out.println(" ********************** " );
		
		
		
		Assert.assertEquals("getAllBlogTestCase",true, blogList);

		
		
		
	}
	
	
	
	
	@Ignore
	@Test
	public void deleteBlogTestCase() {
		
		System.out.println("  deleteBlogTestCase begin      ");
		Blog blog = (Blog) blogDAO.getBlogByID(14);
		boolean flag = blogDAO.delete(blog);
		Assert.assertEquals("delete blog test case", true, flag);
		System.out.println("  deleteBlogTestCase end   ");
		
	}
	
	
	
	@Ignore
	@Test
	public void updateBlogTestCase() {
		Blog blog = (Blog) blogDAO.getBlogByID(6);
		
		blog.setBlogName("pppppppppppppuuuuuuuuuuuu ");
		
		boolean flag = blogDAO.update(blog);

		Assert.assertEquals("update blog test case", true, flag);
	}
	

}
