package com.niit.collaboration.model;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Table(name="C_BLOG")
@Component
public class Blog extends BaseDomain  {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int blogID;
	public int getBlogID()
	{
		return blogID;
	}


	public void setBlogID(int blogID) {
		this.blogID = blogID;
	}


	public String getBlogName() {
		return blogName;
	}


	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}


	public String getBlogComment() {
		return blogComment;
	}


	public void setBlogComment(String blogComment) {
		this.blogComment = blogComment;
	}


	public Date getBlogCreatedDate() {
		return blogCreatedDate;
	}


	public void setBlogCreatedDate(Date blogCreatedDate) {
		this.blogCreatedDate = blogCreatedDate;
	}


	public String getBlogStatus() {
		return blogStatus;
	}


	public void setBlogStatus(String blogStatus) {
		this.blogStatus = blogStatus;
	}


	public int getBlogLikes() {
		return blogLikes;
	}


	public void setBlogLikes(int blogLikes) {
		this.blogLikes = blogLikes;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	private String blogName;
	private String blogComment;
	private Date blogCreatedDate;
	private String blogStatus;
	private int blogLikes;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	  @JoinColumn(name = "userEmail")
	  private User user;
	
	
	
	public void show(Blog blog)
	{
		try
		{
		
		System.out.println(" ************************* ");
		System.out.println(" Blog Id " + blog.getBlogID());
		System.out.println(" Blog Name " + blog.getBlogName());
		System.out.println(" Blog Comment " + blog.getBlogComment());
		//System.out.println(" Blog User " + blog.getUser().getUserEmail());
		System.out.println(" Blog Status " + blog.getBlogStatus());
		System.out.println(" Blog Likes " + blog.getBlogLikes());
		System.out.println(" Blog Creatiion Date  " + blog.getBlogCreatedDate());
		
		
		System.out.println(" ************************* ");
		
		}
		catch(Exception e)
		{
			
			System.out.println(" Error in  Show Blog  "+e);
		}
	}
	
	
	
	
}

