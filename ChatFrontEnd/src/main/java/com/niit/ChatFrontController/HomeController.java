package com.niit.ChatFrontController;  
  
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
  
@Controller  
public class HomeController 
{  
      
    @RequestMapping(value="/", method=RequestMethod.GET)  
    public String home() {  
    	System.out.println(" Home PAge of Front Controller");
        return "home";  
    } 
    
    @RequestMapping(value="/login", method=RequestMethod.GET)  
    public String login() {  
    	System.out.println(" Login PAge of Front Controller");
        return "login";  
    } 
    
    @RequestMapping(value="/register", method=RequestMethod.GET)  
    public String  register() {  
    	System.out.println(" Register PAge of Front Controller");
        return "register";  
    }
    
    
    @RequestMapping(value="/blog", method=RequestMethod.GET)  
    public String  blog()
    {  
    	System.out.println(" Blog PAge of Front Controller");
        return "blog";  
    }
      
    @RequestMapping(value="/admin", method=RequestMethod.GET)  
    public String privateHome() {  
    	System.out.println(" Admin Front Controller");
    	
        return "privatePage";  
    }
    

    @RequestMapping(value="/chat", method=RequestMethod.GET)  
    public String  chat()
    {  
    	System.out.println(" Blog PAge of Front Controller");
        return "chat";  
    }
    @RequestMapping(value="/profile", method=RequestMethod.GET)  
    public String  profile()
    {  
    	System.out.println(" Profile  Controller");
        return "profile";  
    }
    
    @RequestMapping(value="/friends", method=RequestMethod.GET)  
    public String  friends()
    {  
    	System.out.println("  Profile  Controller  ");
        return "friends";  
    }
    
        
}  