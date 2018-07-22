package com.niit.collaboration.model;

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

import org.hibernate.annotations.Generated;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "C_FRIEND")
@Component
public class Friend extends BaseDomain {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int friendID;
	
	
	String FreindType;  //CNF   NCNF REQESTED
	
	
	
	
	public String getFreindType() {
		return FreindType;
	}

	public void setFreindType(String freindType) {
		FreindType = freindType;
	}

	public int getFriendID() {
		return friendID;
	}

	public void setFriendID(int friendID) {
		this.friendID = friendID;
	}

	public User getUser() 
	{
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFriendUserEmailID() {
		return friendUserEmailID;
	}

	public void setFriendUserEmailID(String friendUserEmailID) {
		this.friendUserEmailID = friendUserEmailID;
	}

	
	@ManyToOne(fetch = FetchType.EAGER)
	  @JoinColumn(name = "userEmail")
	  private User user;
	 
	  String friendUserEmailID;
	  
	  
	  
	  public void show(Friend friend)
	  {
		  System.out.println(friendID);
		  System.out.println(friendUserEmailID);
		  System.out.println(friendUserEmailID);
		  System.out.println(user.getUserEmail());
		  
		  
		  
		  
		  
		  
		  
		  
	  }
	  
	  
	
}

