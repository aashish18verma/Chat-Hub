package com.niit.collaboration.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.niit.collaboration.model.UserMultimedia;

public interface UserMultimediaDAO 
{
	public boolean saveUserMultimedia(UserMultimedia userMultimedia,MultipartFile image);
	public boolean deleteUserMultimedia(UserMultimedia userMultimedia);
	public List<UserMultimedia> getAllUserMultimedia();
}











