package com.niit.collaboration.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.niit.collaboration.model.User;
@Component
public interface UserDAO
{
	public List<User> getAllUser();
	public User getUser(String userEmail);
	public List<User> getUserByLoginStatus(String userLoginStatus);
	public User save(User user);
	public boolean update(User user);
	public boolean delete(User user);
	public boolean validate(String id,String password);
	public boolean changeStatus(String userEmail, String userLoginStatus);
}
