package com.niit.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaboration.dao.ChatDataDAO;
import com.niit.collaboration.daoimpl.ChatDataDAOImpl;
import com.niit.collaboration.model.ChatData;
import com.niit.collaboration.model.Message;
import com.niit.collaboration.model.OutputMessage;

@RestController 
public class ChatController 
{

	
	@GetMapping(value = "/addChat")
	public ResponseEntity<String> addChat(HttpServletRequest request) 
	{
			// USE This url for test it 
		// http://localhost:8084/MyMiddleware/addChat?ToUserEmail=niraj@niit.com&FromUserEmail=rajeev@niit.com&ChatMessage=About NIIT
		
		
		ChatData chatData= new ChatData();
		ChatDataDAO chatDataDAO = new ChatDataDAOImpl();
		
		
		String  ToUserEmail = request.getParameter("ToUserEmail");
		String  FromUserEmail = request.getParameter("FromUserEmail"); 
		String ChatMessage = request.getParameter("ChatMessage");
		
		System.out.println(" *********From Middle ware Controller ************** ");
		System.out.println("ToUserEmail "+ ToUserEmail);
		System.out.println("FromUserEmail "+ FromUserEmail);
		System.out.println("ChatMessage  "+ ChatMessage);
		
		System.out.println(" *********************** ");
		
		
		chatData.setToUserEmail(ToUserEmail);
		chatData.setFromUserEmail(FromUserEmail);
		chatData.setChatMessage(ChatMessage);
		
		
		boolean flag = chatDataDAO.addChat(chatData);
		System.out.println(" Chat Data Added  dfrsdf");
		return new ResponseEntity<String>("Data Added to database ",HttpStatus.OK); 
	}
	

	@GetMapping(value = "/getChat")
	public ResponseEntity<List> getChat(HttpServletRequest request) 
	{
		
		//http://localhost:8084/MyMiddleware/getChat?ToUserEmail=niraj@ibm.com&FromUserEmail=rajeev@niit.com
		String  ToUserEmail = request.getParameter("ToUserEmail");
		String  FromUserEmail = request.getParameter("FromUserEmail"); 
	
		
		ChatDataDAO chatDataDAO = new ChatDataDAOImpl();
		List <ChatData> chatData = (List) chatDataDAO.getAllChatByToFrom(ToUserEmail,FromUserEmail);
		
		System.out.println("*********    getChat  Middleware  ************** ");
		System.out.println("ToUserEmail "+ ToUserEmail);
		System.out.println("FromUserEmail "+ FromUserEmail);
				
		System.out.println(" *********************** ");
		
		return new ResponseEntity(chatData,HttpStatus.OK); 
 
	}
	
	
	@MessageMapping("/message")
	@SendTo("/chat/messages")
	public Message getMessages(Message message) {
		System.out.println(message);
		return message;
	}
	
	
	
}
