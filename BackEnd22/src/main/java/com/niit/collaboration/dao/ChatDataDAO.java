package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.ChatData;

public interface ChatDataDAO 
{
	
	public boolean addChat(ChatData chatData);
	public boolean deleteChat(ChatData chatData);
	public boolean updateChat(ChatData chatData);
	public List<ChatData> getAllChat();
	public List<ChatData> getAllChatByToFrom(String toUserEmail,String fromUserEmail );
	
	
	
	
	
	

}
