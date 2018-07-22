package com.niit.collaboration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.User;
import com.niit.collaboration.daoimpl.*;

@Controller
public class UserRestService {
	
	@Autowired
	private User user;
	@Autowired
	private UserDAO userDao;
	

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> registerUser(@RequestBody User user) {
		user.setUserEnabled(0);
		User saveduser = userDao.save(user);
		return new ResponseEntity<User>(saveduser, HttpStatus.OK);

	}


	
	  @RequestMapping(value = "/getallUsers", method = RequestMethod.GET)
	  public ResponseEntity<?> getAllUsers() 
	  {
		  List<User> userList = userDao.getAllUser();
		  System.out.println(userList.toString());
	 
	 return new ResponseEntity<List<User>>(userList, HttpStatus.OK); }
	

	  /*
	 @GetMapping("/user/{id}") public ResponseEntity<User>
	 getUserById(@PathVariable("id")String id)
	  
	  { // log.debug("****************Starting of method getUserById");
	  //log.info("****************Trying to get user details of the id" +id);
	  
	  user=userDAO.getUser(id); if(user==null) { user=new User(); //
	  user.setEr("404"); // user.E("User doesnot exist with id"+id);
	  
	 log.info("*********Name of user is" +user.getName());
	 log.debug("**************Ending of method getUserByID"); return new
	  ResponseEntity<User>(user,HttpStatus.OK); }
	 */

}
