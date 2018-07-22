package com.niit.collaboration.test;

import org.junit.Assert;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.ChatForumCommentDAO;
import com.niit.collaboration.model.ChatForumComment;

public class ChatForumCommentTestCase {
	@Autowired
	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static ChatForumComment chatforumcomment;
	@Autowired
	private static ChatForumCommentDAO chatforumcommentDAO;

	@BeforeClass
	public static void initialize() {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		chatforumcomment = (ChatForumComment) context.getBean("chatforumcomment");

		chatforumcommentDAO = (ChatForumCommentDAO) context.getBean("chatforumcommentDAO");

	}

	@Test
	public void createChatForumCommentTestCase() {
		chatforumcomment.setId(3004);
		chatforumcomment.setMessage("My chatforumcomment");


		boolean flag = chatforumcommentDAO.save(chatforumcomment);
		Assert.assertEquals("createChatForumCommentTestCase", true, flag);
	}

	@Test
	public void deleteChatForumCommentTestCase() {
		ChatForumComment chatforumcomment = (ChatForumComment) chatforumcommentDAO.getChatForumCommentByID(3004);
		boolean flag = chatforumcommentDAO.delete(chatforumcomment);
		Assert.assertEquals("delete chatforumcomment test case", true, flag);
	}

	@Test
	public void updateChatForumCommentTestCase() {
		ChatForumComment chatforumcomment = (ChatForumComment) chatforumcommentDAO.getChatForumCommentByID(3007);
		chatforumcomment.setId(3012);
		chatforumcomment.setMessage("MCameras");

		

		boolean flag = chatforumcommentDAO.update(chatforumcomment);

		Assert.assertEquals("update chatforumcomment test case", true, flag);
	}

}
