package com.niit.collaboration.test;

import org.junit.Assert;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.ChatDAO;
import com.niit.collaboration.model.Chat;

public class ChatTestCase {
	@Autowired
	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static Chat chat;
	@Autowired
	private static ChatDAO chatDAO;

	@BeforeClass
	public static void initialize() {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		chat = (Chat) context.getBean("chat");

		chatDAO = (ChatDAO) context.getBean("chatDAO");

	}

	@Test
	public void createChatTestCase() {
		chat.setId(3004);
		chat.setMessage("My chat");

	

		boolean flag = chatDAO.save(chat);
		Assert.assertEquals("createChatTestCase", true, flag);
	}

	@Test
	public void deleteChatTestCase() {
		Chat chat = (Chat) chatDAO.getChatByID(3004);
		boolean flag = chatDAO.delete(chat);
		Assert.assertEquals("delete chat test case", true, flag);
	}

	@Test
	public void updateChatTestCase() {
		Chat chat = (Chat) chatDAO.getChatByID(3007);
		chat.setId(3012);
		chat.setMessage("MCameras");

	
		boolean flag = chatDAO.update(chat);

		Assert.assertEquals("update chat test case", true, flag);
	}

}
