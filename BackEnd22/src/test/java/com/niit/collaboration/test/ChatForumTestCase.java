package com.niit.collaboration.test;

import org.junit.Assert;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.ChatForumDAO;
import com.niit.collaboration.model.ChatForum;

public class ChatForumTestCase {
	@Autowired
	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static ChatForum chatforum;
	@Autowired
	private static ChatForumDAO chatforumDAO;

	@BeforeClass
	public static void initialize() {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		chatforum = (ChatForum) context.getBean("chatforum");

		chatforumDAO = (ChatForumDAO) context.getBean("chatforumDAO");

	}

	@Test
	public void createChatForumTestCase() {
		chatforum.setId(3004);
		chatforum.setMessage("My chatforum");

		

		boolean flag = chatforumDAO.save(chatforum);
		Assert.assertEquals("createChatForumTestCase", true, flag);
	}

	@Test
	public void deleteChatForumTestCase() {
		ChatForum chatforum = (ChatForum) chatforumDAO.getChatForumByID(3004);
		boolean flag = chatforumDAO.delete(chatforum);
		Assert.assertEquals("delete chatforum test case", true, flag);
	}

	@Test
	public void updateChatForumTestCase() {
		ChatForum chatforum = (ChatForum) chatforumDAO.getChatForumByID(3007);
		chatforum.setId(3012);
		chatforum.setMessage("MCameras");

		

		boolean flag = chatforumDAO.update(chatforum);

		Assert.assertEquals("update chatforum test case", true, flag);
	}

}
