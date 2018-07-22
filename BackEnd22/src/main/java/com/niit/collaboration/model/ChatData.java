package com.niit.collaboration.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "C_CHATData")
@Component

public class ChatData extends BaseDomain
{
	 @Id
	 @GeneratedValue (strategy = GenerationType.AUTO)
	 private int chatID;
	 public int getChatID() {
		return chatID;
	}
	public void setChatID(int chatID) {
		this.chatID = chatID;
	}
	public String getToUserEmail() {
		return toUserEmail;
	}
	public void setToUserEmail(String toUserEmail) {
		this.toUserEmail = toUserEmail;
	}
	public String getFromUserEmail() {
		return fromUserEmail;
	}
	public void setFromUserEmail(String fromUserEmail) {
		this.fromUserEmail = fromUserEmail;
	}
	public String getChatMessage() {
		return chatMessage;
	}
	public void setChatMessage(String chatMessage) {
		this.chatMessage = chatMessage;
	}
	public Date getChatDate() {
		return chatDate;
	}
	public void setChatDate(Date chatDate) {
		this.chatDate = chatDate;
	}
	public String getChatTime() {
		return chatTime;
	}
	public void setChatTime(String chatTime) {
		this.chatTime = chatTime;
	}
	String toUserEmail;
	 String fromUserEmail;
	 String chatMessage;
	 Date chatDate;
	 String chatTime;
	 
	 
	 public void show()
	 {
	 	
		 
		 	System.out.println("Current Date " + chatDate);
		 	System.out.println("Current Time " +chatTime);
		 	System.out.println("toUserEmail " +toUserEmail);
		 	System.out.println("fromUserEmail " +fromUserEmail);
		 	System.out.println("chatMessage " +chatMessage);
		 	System.out.println("chatID " +chatID);
		 	
		 	
		 	
		 	
		 	
		 	
	 }

}








