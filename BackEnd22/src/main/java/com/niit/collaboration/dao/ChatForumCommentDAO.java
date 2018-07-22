package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.ChatForumComment;

public interface ChatForumCommentDAO {
	public List<ChatForumComment> list();
	public boolean save(ChatForumComment chatforumcomment);
	public boolean update(ChatForumComment chatforumcomment);
	public boolean delete(ChatForumComment chatforumcomment);
	public ChatForumComment getChatForumCommentByID(int id);


}
