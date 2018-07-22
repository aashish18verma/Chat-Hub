package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.ChatForum;
import com.niit.collaboration.model.Chat;

public interface ChatForumDAO {	
	public List<ChatForum> list();
	public boolean save(ChatForum chatforum);
	public boolean update(ChatForum chatforum);
	public boolean delete(ChatForum chatforum);
	public ChatForum getChatForumByID(int id);
	public ChatForum getChatForumByName(String name);	
}