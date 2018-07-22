package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Blog;
import com.niit.collaboration.model.User;

public interface BlogDAO 
	{
		public List<Blog> getAllBlog();
		public boolean save(Blog blog ,User user);
		public boolean update(Blog blog);
		public boolean delete(Blog blog);
		public Blog getBlogByID(int id);
		public List<Blog> getBlogByName(String name);
	}


