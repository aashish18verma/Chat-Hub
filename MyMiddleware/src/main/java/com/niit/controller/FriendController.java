package com.niit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import com.niit.collaboration.dao.FriendDAO;
import com.niit.collaboration.daoimpl.FriendDAOImpl;
import com.niit.collaboration.daoimpl.UserDAOImpl;
import com.niit.collaboration.model.Friend;
import com.niit.collaboration.model.User;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

@RestController  
public class FriendController
{
	
	
	
	@GetMapping(value = "/allcnfFriend")
	public ResponseEntity <List> allcnfFriend(HttpServletRequest request)
	{
		String useremail = (String) request.getParameter("useremail");
		String friendType = (String) request.getParameter("friendType");
		
	System.out.println("useremail "+useremail);
	System.out.println("friendType "+friendType);

	
		
		
		try
		{
			FriendDAO friendDAO = new FriendDAOImpl();
			List <Friend> friends = friendDAO.cnfFriendList(useremail,friendType);
			return new ResponseEntity(friends, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity(null, HttpStatus.NO_CONTENT);
		}
	}

	
	
	
	@GetMapping(value = "/allnoncnfFriend")
	public ResponseEntity <List> allnoncnfFriend(HttpServletRequest request)
	{
		String useremail = (String) request.getParameter("useremail");
		String friendType = (String) request.getParameter("friendType");
		
	System.out.println("useremail "+useremail);
	System.out.println("friendType "+friendType);

	
		
		
		try
		{
			FriendDAO friendDAO = new FriendDAOImpl();
			List <Friend> friends = friendDAO.noncnfFriendList(useremail,friendType);
			return new ResponseEntity(friends, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity(null, HttpStatus.NO_CONTENT);
		}
	}

	
	
	
	
	@GetMapping(value = "/allFriend")
	public ResponseEntity <List> allFriend()
	{
		try
		{
			FriendDAO friendDAO = new FriendDAOImpl();
			List <Friend> friends = friendDAO.allFriendList();
			return new ResponseEntity(friends, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity(null, HttpStatus.NO_CONTENT);
		}
	}

	
	
	
	
	
	// updatenoncnfFriendList
	
	@GetMapping(value = "/updatenoncnfFriendList")
	public ResponseEntity <String> updatenoncnfFriendList(HttpServletRequest request )
	{
		System.out.println(" updatenoncnfFriendList  Middleware Controller is Invoked  " );
		
		
		String friendID = (String) request.getParameter("friendID");
		String friendType = (String) request.getParameter("friendType");
		
		Friend friend = new Friend();
		
		int fid = Integer.parseInt(friendID);
		
		friend.setFriendID(fid);
		friend.setFreindType(friendType);

		FriendDAO friendDAO = new FriendDAOImpl();
		
 	    friendDAO.update_noncnf_to_cnf(friend);
 	
 	
 	    
		
		System.out.println("from Middlerware saveFriendRequest controller :   friendID 	  "+friendID );
		System.out.println("from Middlerware saveFriendRequest controller :   friendType "+friendType );
		
		return new ResponseEntity("Friend Request Stored in the data base ",HttpStatus.OK);
		
		
		
	}
	
	
	
	
	
	
	@GetMapping(value = "/saveFriendRequest")
	public ResponseEntity <String> saveFriendRequest(HttpServletRequest request )
	{
		System.out.println("saveFriendRequest  Middleware Controller is Invoked  " );
		
		
		String userEmail = (String) request.getParameter("userEmail");
		String friendUserEmail = (String) request.getParameter("friendUserEmail");
		String friendType = (String) request.getParameter("friendType");
		
		
		Friend friend = new Friend();
		
		User user = new UserDAOImpl().getUser(userEmail);
		
		
		friend.setUser(user);
		friend.setFriendUserEmailID(friendUserEmail);
		friend.setFreindType(friendType);

		FriendDAO friendDAO = new FriendDAOImpl();
		
		friendDAO.sendFriendRequest(friend);
		
		System.out.println("from Middlerware saveFriendRequest controller :   userEmail 	  "+userEmail );
		System.out.println("from Middlerware saveFriendRequest controller :   friendUserEmail "+friendUserEmail );
		System.out.println("from Middlerware saveFriendRequest controller :   friendType "+friendType );
		
		return new ResponseEntity("Friend Request Stored in the data base ",HttpStatus.OK);
		
		
		
	}
}
