package com.niit.controller;  
  
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Hibernate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.daoimpl.UserDAOImpl;
import com.niit.collaboration.model.User;

import java.util.*;

  
@RestController  
public class HomeController {  
      
    @RequestMapping(value="/", method=RequestMethod.GET)  
    public String home() {  
    	
    	System.out.println(" Middleware Controller is running");
    	
    	
        return "home";  
    }  
    
    
    @GetMapping(value = "/addUser")
	public ResponseEntity <String> addUser(HttpServletRequest request )
    {
    	System.out.println("Add User Middleware Controller  " );
    	String userEmail = request.getParameter("userEmail");
		String userPassword = request.getParameter("userPassword");
		String userName = request.getParameter("userName");
		String userAddress = request.getParameter("userAddress");
		String userContact = request.getParameter("userContact");
		
		
    	User user = new User();
    	
    	user.setUserEmail(userEmail);
    	user.setUserPassword(userPassword);
    	user.setUserName(userName);
    	user.setUserAddress(userAddress);
    	user.setUserContact(userContact);
    	
    	
    	
    	try
    	{
    	UserDAO userDAO = new UserDAOImpl();
    	
    	userDAO.save(user);
    	return new ResponseEntity("data stored in the database ", HttpStatus.OK);
    	}
    	catch(Exception e)
    	{
    	 return new ResponseEntity("data not stored in the database "+e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }   
    
    
    @GetMapping(value = "/alluser")
	public ResponseEntity<List> getAllUser() {

    	
    	System.out.println("GET ALL USER Controller ");

    		UserDAO userDAO = new UserDAOImpl();
    		List <User>user =userDAO.getAllUser();
    		
    		Iterator item = user.iterator();
    		
    		while(item.hasNext())
    		{
    			User u = (User) item.next();
    			u.show(u);
    			
    		}

		return new ResponseEntity(user, HttpStatus.OK);
	}
    
    
    
    @GetMapping(value = "/getuserbyemail")
   	public ResponseEntity<User> getuserbyemail(@RequestParam("emailID") String email) {
  	   	System.out.println("GET Data By user name Controller updated ");
       	System.out.println("Data Comming From Front End  " + email);
       	UserDAO userDAO = new UserDAOImpl();
       	User user =userDAO.getUser(email);
       	
       	if (user == null) {
            System.out.println("User with email " + email + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
       	
       	user.show(user);
       	userDAO.changeStatus(email, "Y");
       			
   		return new ResponseEntity<User>(user, HttpStatus.OK);
   	}

    
    
    @GetMapping(value = "/getuserbyloginstatus")
   	public ResponseEntity<List> getuserbyloginstatus(@RequestParam("loginstatus") String loginstatus) {
  	   	System.out.println("getuserbyloginstatus Middleware Controller  ");
       	System.out.println("Data Comming From Front End  " + loginstatus);
       	UserDAO userDAO = new UserDAOImpl();
       	List <User> user =userDAO.getUserByLoginStatus(loginstatus);
       	
       	if (user.size() == 0)
       	{
            System.out.println("User with email " + loginstatus + " not found");
            return new ResponseEntity<List>(HttpStatus.NOT_FOUND);
        }
       	
       	
       	
       			
   		return new ResponseEntity<List>(user, HttpStatus.OK);
   	}
    
    
    
  
    @GetMapping(value = "/logout")
   	public ResponseEntity<User> logout(@RequestParam("emailID") String email) {
  	   	System.out.println(" Logout Middleware Controller ");
       	System.out.println(" Data Comming From Front End  " + email);
       	UserDAO userDAO = new UserDAOImpl();
       	User user =userDAO.getUser(email);
       	
       	if (user == null) {
            System.out.println("User with email " + email + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
       	
       	user.show(user);
       	userDAO.changeStatus(email, "N");
       			
   		return new ResponseEntity<User>(user, HttpStatus.OK);
   	}

    
    
    
      
    @RequestMapping(value="/admin", method=RequestMethod.GET)  
    public String privateHome() {  
        return "privatePage";  
    }  
}  