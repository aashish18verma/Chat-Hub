package com.niit.controller;
import org.hibernate.Hibernate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.RequestEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.collaboration.dao.BlogDAO;
import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.daoimpl.BlogDAOImpl;
import com.niit.collaboration.daoimpl.UserDAOImpl;
import com.niit.collaboration.model.Blog;
import com.niit.collaboration.model.User;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
  
@RestController  
public class BlogController {
	
	
	
	@GetMapping(value = "/allblog")
	public ResponseEntity<List> allblog() 
	{
		System.out.println(" Get ALL BLOG MIDDLEWARE CONTROLLER  ");
		
		BlogDAO blogDAO = new BlogDAOImpl ();
		System.out.println(" 2222222222222");
		
		List <Blog> blogList = blogDAO.getAllBlog();
		System.out.println(" 3333333333333");
		Iterator items = blogList.iterator();
		
		while(items.hasNext())
		{
			Blog blog = (Blog) items.next();
			blog.show(blog);
		}
		
		return new ResponseEntity(blogList, HttpStatus.OK);
	}
	
	//    **************** ADD Blog Code **********************
	@GetMapping(value = "/addblog")
	public ResponseEntity<String> addblog(HttpServletRequest request) 
	{
		String blogName= request.getParameter("blogName");
		String blogComment = request.getParameter("blogComment");
		String userEmail = request.getParameter("userEmail");
		
		
		
		Blog blog= new Blog();
		BlogDAO blogDAO = new BlogDAOImpl();
		
		User user = new User();
		UserDAO userDAO = new UserDAOImpl();
		
		
		
		blog.setBlogName(blogName);
		blog.setBlogComment(blogComment);
		
		System.out.println("*******************  "+ userEmail + "  **********************    ");
		
		user = userDAO.getUser(userEmail);
		try
		{
			 user.show(user);
		 }
		 catch(Exception e)
		 {
			 System.out.println(" Error in Blog create test case " + e);
		 }
		boolean flag = blogDAO.save(blog,user);
		
		if(flag == true)
		{
			
			System.out.println(" Data inserted to the Blog Table : Middleware  Restcontroller ");
			return new ResponseEntity(" Data inserted to the Blog Table ", HttpStatus.OK);
		}
		else
		{
			System.out.println(" Data not inserted to the Blog Table   : Middleware  Restcontroller ");
			return new ResponseEntity("Data not inserted to the Blog Table ", HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		
		
		
		
		
		
	}	
	
	
	
// **************** DELETE Blog Code  **********************
	
	@GetMapping(value = "/deleteblog")
	public ResponseEntity<String> deleteblog(HttpServletRequest request) 
	{
		System.out.println("    DELETE Middleware Controller :  blogID " + request.getParameter("blogID"));
		String blogID= request.getParameter("blogID");
		int bid = Integer.parseInt(blogID);
		Blog blog= new Blog();
		BlogDAO blogDAO = new BlogDAOImpl();
		System.out.println("  deleteBlogTestCase begin      ");
        blog = (Blog) blogDAO.getBlogByID(bid);
		boolean flag = blogDAO.delete(blog);
		
		return new ResponseEntity(" Data Deleted from  Blog Table ", HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/updateblog")
	public ResponseEntity<String> updateblog(HttpServletRequest request) 
	{
		System.out.println(" Update Middleware :  blogID " + request.getParameter("blogID"));
		
		String blogID= request.getParameter("blogID");
		int bid = Integer.parseInt(blogID);
		Blog blog= new Blog();
		BlogDAO blogDAO = new BlogDAOImpl();
		System.out.println("  deleteBlogTestCase begin      ");
        blog = (Blog) blogDAO.getBlogByID(bid);
        
        
        String blogName= request.getParameter("blogName");
		String blogComment = request.getParameter("blogComment");
		
        
		blog.setBlogName(blogName);
		blog.setBlogComment(blogComment);
		
        
		boolean flag = blogDAO.update(blog);
		
		return new ResponseEntity(" Data Deleted from  Blog Table ", HttpStatus.OK);
		
	}
	
		

}
