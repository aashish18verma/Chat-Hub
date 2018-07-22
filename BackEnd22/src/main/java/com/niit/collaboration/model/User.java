package com.niit.collaboration.model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "C_USER_DETAILS")
@Component
public class User extends BaseDomain 
{

	@Id
	private String      userEmail;
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserContact() {
		return userContact;
	}
	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	private String      userPassword;
	private String      userName;
	private String      userAddress;
	private String      userContact;
	private String      userRole;
	private int     userEnabled;
	private String userLoginStatus;
	
	public String getUserLoginStatus() {
		return userLoginStatus;
	}
	public void setUserLoginStatus(String userLoginStatus) {
		this.userLoginStatus = userLoginStatus;
	}
	public List<Blog> getBlog() {
		return blog;
	}
	public void setBlog(List<Blog> blog) {
		this.blog = blog;
	}
	public int getUserEnabled() {
		return userEnabled;
	}
	public void setUserEnabled(int userEnabled) {
		this.userEnabled = userEnabled;
	}
	
	
	public void show(User user)
	{
	   System.out.println(user.getUserEmail());
	   System.out.println(user.userName);
	   System.out.println(user.getUserAddress());
	   System.out.println(user.getUserContact());
	   System.out.println(user.getUserEnabled());
	   System.out.println(user.getUserPassword());
	   System.out.println(user.getUserRole());
	   
	   
	   
	   
	   
	}
	
	
	// **********************
	@JsonIgnore
	@OneToMany(mappedBy="user",fetch = FetchType.EAGER)
	  private List<Blog> blog;
	
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy="user",fetch = FetchType.EAGER)
	  private List<UserMultimedia> userMultimedia;
	public List<UserMultimedia> getUserMultimedia()
	{
		return userMultimedia;
	}
	
	
	
	public void setUserMultimedia(List<UserMultimedia> userMultimedia) 
	{
		this.userMultimedia = userMultimedia;
	}

	
	@JsonIgnore
	@OneToMany(mappedBy="user",fetch = FetchType.EAGER)
	private List<Friend> friend;
	
	
	
	
	
	
	

}